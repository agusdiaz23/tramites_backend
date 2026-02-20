package logica;

import datatypes.DtPerfilCiudadano;
import datatypes.DtTramite;
import interfaces.IControladorTramite;

public class ControladorTramite implements IControladorTramite{
    private static ManejadorPerfil manejadorPerfil = ManejadorPerfil.getInstancia();
    public void nuevoTramite(DtPerfilCiudadano dtPerfilCiudadano, DtTramite tramite){

        Tramite nuevoTramite = new Tramite(tramite.getFechaInicio(), tramite.getFechaVencimiento(),
                tramite.getFechaFinalizado(), tramite.getTipo(), tramite.getEstado());

        //Busca el perfil sin comprobar tipos, se entiende que desde el front llega el id de un perfil valido.
        PerfilCiudadano perfilCiudadano = (PerfilCiudadano) manejadorPerfil.traerPerfil(dtPerfilCiudadano.getId());
        perfilCiudadano.agregarTramite(nuevoTramite);

        nuevoTramite.setPerfilCiudadano(perfilCiudadano);

    }
}
