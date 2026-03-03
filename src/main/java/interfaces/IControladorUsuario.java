package interfaces;

import datatypes.DtUsuario;
import excepciones.YaExisteUsuarioExcepcion;

public interface IControladorUsuario {

    void AltaUsuario(DtUsuario usuario) throws YaExisteUsuarioExcepcion;

}
