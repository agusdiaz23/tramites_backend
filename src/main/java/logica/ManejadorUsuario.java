package logica;

import datatypes.DtUsuario;
import jakarta.persistence.EntityManager;
import persistencia.Conexion;

import java.util.List;


public class ManejadorUsuario {
    private static ManejadorUsuario instancia = null;

    private ManejadorUsuario(){}

    public static ManejadorUsuario getInstancia() {
        if(instancia == null){
            instancia = new ManejadorUsuario();
        }
        return instancia;
    }

    public boolean existeUsuario(String ci){
        EntityManager em;
        boolean existe;

        em = Conexion.getInstancia().getEntityManager();
        em.getTransaction().begin();

        existe = (em.find(Usuario.class, ci) != null);
        em.close();

        System.out.print("Llegue a checkeo usuario");

        return existe;
    }

    public Usuario traerUsuario(String ci, EntityManager em){
        return em.find(Usuario.class, ci);
    }

    public void registrarUsuario(DtUsuario usuario){
        EntityManager em = Conexion.getInstancia().getEntityManager();

        Usuario nuevoUsuario = new Usuario(usuario.getCi(), usuario.getNombre(), usuario.getApellido(),
                usuario.getEmail(), usuario.getContrasena());

        System.out.print("   Voy a crear el usuario: " + usuario.getCi() + usuario.getNombre() + usuario.getApellido());

        em.getTransaction().begin();
        em.persist(nuevoUsuario);
        em.getTransaction().commit();
        em.close();
    }

    public List<Perfil> traerPerfilesUsuario(Usuario u, EntityManager em){
        return em.createQuery("SELECT p FROM Perfil p WHERE p.usuario = u", Perfil.class).getResultList();
    }

    public boolean tienePerfilFuncionario(Usuario u){
        EntityManager em = Conexion.getInstancia().getEntityManager();

        long resultados = (long) em.createQuery("SELECT COUNT(pf) " +
                "FROM PerfilFuncionario pf " +
                "WHERE pf.usuario = :usuario").setParameter("usuario", u).getSingleResult();

        return resultados > 0;
    }

    public boolean tienePerfilCiudadano(Usuario u){
        EntityManager em = Conexion.getInstancia().getEntityManager();

        long resultados = (long) em.createQuery("SELECT COUNT(pc) " +
                "FROM PerfilCiudadano pc " +
                "WHERE pc.usuario = :usuario").setParameter("usuario", u).getSingleResult();

        return resultados > 0;
    }

    public List<Usuario> verUsuarios(){
        EntityManager em = Conexion.getInstancia().getEntityManager();

        return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }

}
