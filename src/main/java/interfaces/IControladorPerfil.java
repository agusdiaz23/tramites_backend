package interfaces;
import datatypes.*;
import excepciones.YaTienePerfil;
import jakarta.persistence.EntityManager;
import logica.PerfilFuncionario;
import persistencia.Conexion;

import java.util.ArrayList;
import java.util.List;

public interface IControladorPerfil {
    public void AltaPerfil(DtUsuario usuario, DtPerfil perfil) throws YaTienePerfil;

    public List<DtPerfilCiudadano> verPerfilesCiudadano();

    public List<DtPerfilFuncionario> verPerfilesFuncionarioJefes();
    public List<DtPerfilFuncionario> verPerfilesFuncionarioInspectores();
    public List<Object[]> verPerfilesFuncionarioInfoUsuario();
}
