package logica;

import datatypes.DtEventoTramite;
import datatypes.DtPerfil;
import datatypes.DtTramite;
import interfaces.IControladorEventoTramite;
import jakarta.persistence.EntityManager;
import persistencia.Conexion;

import javax.swing.text.html.parser.Entity;

public class ControladorEventoTramite implements IControladorEventoTramite {

    private static ManejadorTramite manejadorTramite = ManejadorTramite.getInstancia();

    public void nuevoEvento(DtTramite dtTramite, DtPerfil perfil,
                            DtEventoTramite dtNuevoEvento){
        Tramite tramite = manejadorTramite.buscarTramite(dtTramite.getId());

        if(tramite.getEventosDisponibles().contains(dtNuevoEvento.getTipo())){
        //si la coleccion de eventos disponibles del tramite contiene el tipo de nuevoEvento
            EntityManager em = Conexion.getInstancia().getEntityManager();

            EventoTramite eventoTramite = new EventoTramite(dtNuevoEvento.getFecha(),
                    dtNuevoEvento.getTipo(), dtNuevoEvento.getMotivo());

            tramite.actualizarEstadoTramite(dtNuevoEvento.getTipo());
            tramite.actualizarEventosDisponibles();
            eventoTramite.setTramite(tramite);

            em.getTransaction().begin();
            em.persist(eventoTramite);
            em.persist(tramite);
            em.getTransaction().commit();
            em.close();
        }else{
            //excepcion tramite no acepta ese evento
        }


    }
}
