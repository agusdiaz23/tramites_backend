package logica;

import datatypes.DtTramite;
import jakarta.persistence.EntityManager;
import persistencia.Conexion;

public class ManejadorTramite{
    private static ManejadorTramite instancia = null;

    private ManejadorTramite(){}

    public static ManejadorTramite getInstancia(){
        if(instancia==null){
            instancia = new ManejadorTramite();
        }
        return instancia;
    }

    public Tramite buscarTramite(int id){
        EntityManager em = Conexion.getInstancia().getEntityManager();
        Tramite tramite;

        em.getTransaction().begin();
        tramite = em.find(Tramite.class, id);
        em.close();

        return tramite;
    }


}
