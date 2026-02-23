package interfaces;

import datatypes.DtEventoTramite;
import datatypes.DtPerfil;
import datatypes.DtTramite;

public interface IControladorEventoTramite{
    public void nuevoEvento(DtTramite dtTramite, DtPerfil perfil,
                            DtEventoTramite dtNuevoEvento);


}
