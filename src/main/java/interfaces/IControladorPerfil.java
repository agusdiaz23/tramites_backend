package interfaces;
import datatypes.*;

import java.util.List;

public interface IControladorPerfil {
    public void AltaPerfil(DtUsuario usuario, DtPerfil perfil);
    public List<DtPerfilCiudadano> verPerfilesCiudadano();
}
