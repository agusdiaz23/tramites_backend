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


}
