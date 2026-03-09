package interfaces;

import datatypes.DtPerfilCiudadano;
import datatypes.DtTramite;

public interface IControladorTramite {
    public void nuevoTramite(int idPerfilCiudadano, DtTramite tramite);
}
