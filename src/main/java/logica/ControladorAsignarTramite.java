package logica;

import datatypes.DtPerfilFuncionario;
import datatypes.DtTramite;
import excepciones.YaExisteUsuarioExcepcion;
import interfaces.IControladorAsignarTramite;
import jakarta.persistence.EntityManager;
import persistencia.Conexion;

import java.util.ArrayList;
import java.util.List;

public class ControladorAsignarTramite implements IControladorAsignarTramite {

    private static ManejadorPerfil manejadorPerfil = ManejadorPerfil.getInstancia();
    private static ManejadorTramite manejadorTramite = ManejadorTramite.getInstancia();

    public void asignarTramite(DtPerfilFuncionario dtFuncAsigna, DtTramite dtTramite,
                               List<DtPerfilFuncionario> dtFuncAsignados){
        EntityManager em = Conexion.getInstancia().getEntityManager();

        PerfilFuncionario funcAsigna = (PerfilFuncionario) manejadorPerfil.traerPerfil(dtFuncAsigna.getId(), em);

        em.getTransaction().begin();

        Tramite tramite = manejadorTramite.buscarTramite(dtTramite.getId(), em);
        List<PerfilFuncionario> funcAsignados = new ArrayList<>();
        AsignaTramite nuevoAsignaTramite = new AsignaTramite();

        for(DtPerfilFuncionario dtFuncAsignado:dtFuncAsignados){
            funcAsignados.add((PerfilFuncionario) manejadorPerfil.traerPerfil(dtFuncAsignado.getId(), em));
        }

        nuevoAsignaTramite.setTramite(tramite);
        nuevoAsignaTramite.setFuncionariosAsignados(funcAsignados);
        nuevoAsignaTramite.setFuncionarioAsigna(funcAsigna);

        em.persist(nuevoAsignaTramite);
        em.getTransaction().commit();
        em.close();


    }
}
