package logica;

import jakarta.persistence.EntityManager;
import persistencia.Conexion;

import javax.swing.text.html.parser.Entity;

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
}
