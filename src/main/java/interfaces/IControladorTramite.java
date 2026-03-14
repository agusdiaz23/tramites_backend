package interfaces;

import datatypes.DtPerfilCiudadano;
import datatypes.DtTramite;

import java.util.List;

public interface IControladorTramite {
    public void nuevoTramite(int idPerfilCiudadano, DtTramite tramite);
    public List<DtTramite> verTramites();
}
