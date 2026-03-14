package logica;

import datatypes.DtPerfilCiudadano;
import datatypes.DtPerfilFuncionario;
import datatypes.DtTramite;
import interfaces.IControladorTramite;
import jakarta.persistence.EntityManager;
import persistencia.Conexion;

import java.util.ArrayList;
import java.util.List;

public class ControladorTramite implements IControladorTramite{
    private static ManejadorPerfil manejadorPerfil = ManejadorPerfil.getInstancia();
    private static ManejadorTramite manejadorTramite = ManejadorTramite.getInstancia();

    public void nuevoTramite(int idPerfilCiudadano, DtTramite tramite){
        EntityManager em = Conexion.getInstancia().getEntityManager();

        Tramite nuevoTramite = new Tramite(tramite.getFechaInicio(), tramite.getFechaVencimiento(),
                tramite.getFechaFinalizado(), tramite.getTipo(), tramite.getEstado());

        //Busca el perfil sin comprobar tipos, se entiende que desde el front llega el id de un perfil valido.
        PerfilCiudadano perfilCiudadano = (PerfilCiudadano) manejadorPerfil.traerPerfil(idPerfilCiudadano , em);
      //perfilCiudadano.agregarTramite(nuevoTramite);

        nuevoTramite.setPerfilCiudadano(perfilCiudadano);

        em.getTransaction().begin();
        em.persist(nuevoTramite);
        em.getTransaction().commit();
        em.close();
    }

    public List<DtTramite> verTramites(){
        EntityManager em = Conexion.getInstancia().getEntityManager();

        List<DtTramite> retorno = new ArrayList<>();

        for(Tramite t : manejadorTramite.traerTramites(em)){
            System.out.println("ID DEL TRAMITE EN CONTROLADOR | VER TRAMITES: " + t.obtenerDt().getId());
            retorno.add(t.obtenerDt());
        }
        return retorno;
    }



}
