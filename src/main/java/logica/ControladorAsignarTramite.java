package logica;

import datatypes.DtPerfilFuncionario;
import datatypes.DtTramite;
import interfaces.IControladorAsignarTramite;
import jakarta.persistence.EntityManager;
import persistencia.Conexion;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class ControladorAsignarTramite implements IControladorAsignarTramite {

    private static ManejadorPerfil manejadorPerfil = ManejadorPerfil.getInstancia();
    private static ManejadorTramite manejadorTramite = ManejadorTramite.getInstancia();

    public void asignarTramite(DtPerfilFuncionario dtFuncAsigna, DtTramite dtTramite,
                               List<DtPerfilFuncionario> dtFuncAsignados){
        EntityManager em = Conexion.getInstancia().getEntityManager();

        PerfilFuncionario funcAsigna = (PerfilFuncionario) manejadorPerfil.traerPerfil(dtFuncAsigna.getId());

        Tramite tramite = manejadorTramite.buscarTramite(dtTramite.getId());
        List<PerfilFuncionario> funcAsignados = new ArrayList<>();
        AsignaTramite nuevoAsignaTramite = new AsignaTramite();

        for(DtPerfilFuncionario dtFuncAsignado:dtFuncAsignados){
            funcAsignados.add((PerfilFuncionario) manejadorPerfil.traerPerfil(dtFuncAsignado.getId()));
        }

        nuevoAsignaTramite.setTramite(tramite);
        nuevoAsignaTramite.setFuncionariosAsignados(funcAsignados);
        nuevoAsignaTramite.setFuncionarioAsigna(funcAsigna);


        em.getTransaction().begin();
        em.persist(nuevoAsignaTramite);
        em.getTransaction().commit();
        em.close();


//        tramite.setAsignaTramite(nuevoAsignaTramite);

    }
}
