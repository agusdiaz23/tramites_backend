package logica;

import datatypes.Cargo;
import datatypes.DtPerfilFuncionario;
import jakarta.persistence.EntityManager;
import persistencia.Conexion;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Objects;

public class ManejadorPerfil {
    private static ManejadorPerfil instancia = null;

    private ManejadorPerfil(){}

    public static ManejadorPerfil getInstancia() {
        if(instancia == null){
            instancia = new ManejadorPerfil();
        }
        return instancia;
    }

    public Perfil traerPerfil(int id, EntityManager em){
        return em.find(Perfil.class, id);
    }

    public List<PerfilCiudadano> traerPerfilesCiudadanos(){
        EntityManager em = Conexion.getInstancia().getEntityManager();
        return em.createQuery("SELECT p FROM PerfilCiudadano p", PerfilCiudadano.class).getResultList();
    }

    public List<PerfilFuncionario> verPerfilesFuncionarioJefes(EntityManager em){

        return em.createQuery("SELECT pf FROM PerfilFuncionario pf " +
                        "WHERE pf.cargo = :cargo", PerfilFuncionario.class)
                        .setParameter("cargo", Cargo.JEFE).getResultList();
    }

    public List<PerfilFuncionario> verPerfilesFuncionarioInspectores(EntityManager em){
        return em.createQuery("SELECT pf FROM PerfilFuncionario pf " +
                        "WHERE pf.cargo = :cargo", PerfilFuncionario.class)
                .setParameter("cargo", Cargo.INSPECTOR).getResultList();
    }

    public List<Object[]> verPerfilesFuncionarioInfoUsuario(EntityManager em){
        return em.createQuery("SELECT pf,u FROM PerfilFuncionario pf " +
                "JOIN FETCH pf.usuario u").getResultList();
    }

    public List<Object[]> verPerfilesFuncionarioPorTramite(int idTramite, EntityManager em){
        //trae informacion del usuario mediante join fetch
        return em.createQuery("SELECT pf,u,t FROM AsignaTramite at " +
                "JOIN at.funcionarioAsignado pf " +
                "JOIN pf.usuario u " +
                "JOIN at.tramite t " +
                "WHERE t.id = :idTramite").setParameter("idTramite", idTramite).getResultList();
    }

    public List<Object[]> verPerfilesCiudadanoPorTramite(int idTramite, EntityManager em){
        //trae informacion del usuario mediante join fetch
        return em.createQuery("SELECT pc, t FROM Tramite t " +
                "JOIN t.ciudadano pc " +
                "WHERE t.id = idTramite").setParameter("idTramite", idTramite) .getResultList();
    }
}
