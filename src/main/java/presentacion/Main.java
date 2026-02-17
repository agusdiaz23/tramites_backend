package presentacion;

import java.util.*;

import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;
import jakarta.persistence.EntityManager;
import logica.*;
import datatypes.*;
import persistencia.Conexion;

public class Main {
    public static void main()
    {
        DtUsuario usuario =  new DtUsuario("123", "agus", "diaz");
        DtPerfilFuncionario funcionario = new DtPerfilFuncionario();
        funcionario.setCargo(Cargo.INSPECTOR);

        Fabrica.getInstancia().getControladorAltaUsuario().AltaUsuario(usuario);
        Fabrica.getInstancia().getControladorAltaFuncionario().AltaPerfil(usuario,funcionario);
    }
}
