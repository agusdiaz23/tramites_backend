package interfaces;

import datatypes.DtUsuario;
import excepciones.YaExisteUsuarioExcepcion;

import java.util.List;

public interface IControladorUsuario {

    void AltaUsuario(DtUsuario usuario) throws YaExisteUsuarioExcepcion;
    List<String> verCiUsuarios();
}
