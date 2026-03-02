package logica;

import datatypes.DtUsuario;
import jakarta.persistence.EntityManager;
import persistencia.Conexion;

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

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setCi(usuario.getCi());
        nuevoUsuario.setNombre(usuario.getNombre());
        nuevoUsuario.setApellido(usuario.getApellido());

        System.out.print("   Voy a crear el usuario: " + usuario.getCi() + usuario.getNombre() + usuario.getApellido());

        em.getTransaction().begin();
        em.persist(nuevoUsuario);
        em.getTransaction().commit();
        em.close();
    }

}
