package logica;

import datatypes.DtPerfilFuncionario;
import datatypes.DtTramite;
import datatypes.EstadoAsignado;
import excepciones.FuncionarioYaAsignado;
import excepciones.YaExisteUsuarioExcepcion;
import interfaces.IControladorAsignarTramite;
import jakarta.persistence.EntityManager;
import persistencia.Conexion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorAsignarTramite implements IControladorAsignarTramite {

    private static ManejadorPerfil manejadorPerfil = ManejadorPerfil.getInstancia();
    private static ManejadorTramite manejadorTramite = ManejadorTramite.getInstancia();
    private static ManejadorAsignaTramite manejadorAsignaTramite = ManejadorAsignaTramite.getInstancia();

    public void asignarTramite(DtPerfilFuncionario dtFuncAsigna, DtTramite dtTramite,
                               DtPerfilFuncionario dtFuncAsignado) throws FuncionarioYaAsignado {
        EntityManager em = Conexion.getInstancia().getEntityManager();

        Tramite tramite = manejadorTramite.buscarTramite(dtTramite.getId(), em);
        PerfilFuncionario funcAsignado = (PerfilFuncionario) manejadorPerfil.traerPerfil(dtFuncAsignado.getId(), em);

        if(!manejadorAsignaTramite.funcionarioEstaAsignadoATramite(funcAsignado, tramite)){
            //debe ser jefe
            PerfilFuncionario funcAsigna = (PerfilFuncionario) manejadorPerfil.traerPerfil(dtFuncAsigna.getId(), em);

            em.getTransaction().begin();

            AsignaTramite nuevoAsignaTramite = new AsignaTramite();

            nuevoAsignaTramite.setTramite(tramite);
            nuevoAsignaTramite.setFuncionarioAsignado(funcAsignado);
            nuevoAsignaTramite.setFuncionarioAsigna(funcAsigna);

            em.persist(nuevoAsignaTramite);
            em.getTransaction().commit();
            em.close();
        }else{
            throw new FuncionarioYaAsignado("El funcionario ya esta asignado a este tramite.");
        }

    }

    public void DesasignarTramite(DtTramite dtTramite, DtPerfilFuncionario dtFuncInspector){
        EntityManager em = Conexion.getInstancia().getEntityManager();

        em.getTransaction().begin();

        Tramite tramite = manejadorTramite.buscarTramite(dtTramite.getId(), em);
        PerfilFuncionario funcInspector = (PerfilFuncionario) manejadorPerfil.traerPerfil(dtFuncInspector.getId(), em);

        //traigo unicamente las asignaciones activas
        AsignaTramite asignaTramite = manejadorAsignaTramite.traerAsignaTramiteActivo(tramite, funcInspector, em);

        asignaTramite.setEstado(EstadoAsignado.INACTIVO);
        asignaTramite.setFechaDesasignado(LocalDate.now());

        em.persist(asignaTramite);
        em.getTransaction().commit();
        em.close();
    }

    //PENSADO PARA DESASIGNAR FUNCIONARIO
    public List<DtPerfilFuncionario> traerFuncionariosAsignados(DtPerfilFuncionario dtFuncJefe,
                                                                DtTramite dtTramite, DtPerfilFuncionario dtFuncInspector){
        //SE PUEDE COMPLEJIZAR LA FUNCION PARA APLICAR VARIOS FILTROS
        //TRAE TODOS LOS ASIGNADOS POR TRAMITE.

        EntityManager em = Conexion.getInstancia().getEntityManager();
        PerfilFuncionario funcJefe = (PerfilFuncionario) manejadorPerfil.traerPerfil(dtFuncJefe.getId(), em);
        PerfilFuncionario funcInspector = (PerfilFuncionario) manejadorPerfil.traerPerfil(dtFuncInspector.getId(), em);
        Tramite tramite = manejadorTramite.buscarTramite(dtTramite.getId(), em);

        List<DtPerfilFuncionario> perfiles = new ArrayList<>();

        //carga lazy irrelevante, se estiman pocos registros.
        for(AsignaTramite at : manejadorAsignaTramite.traerAsignadosActivosPorTramite(tramite, em)){
            perfiles.add(at.getFuncionarioAsignado().obtenerDt());
        }
        return perfiles;
    }

}
