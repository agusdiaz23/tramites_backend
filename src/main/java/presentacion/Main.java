package presentacion;

import java.util.*;

import jakarta.persistence.EntityManager;
import logica.*;
import datatypes.*;
import persistencia.Conexion;

public class Main {
    public static void main()
    {

        EntityManager em = Conexion.getInstancia().getEntityManager();
        em.getTransaction().begin();
        Usuario u = new Usuario();
        u.setCi("123");
        em.persist(u);
        em.getTransaction().commit();
        em.close();
    }
}
