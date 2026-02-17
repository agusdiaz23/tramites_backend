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

        DtPerfilCiudadano ciudadano = new DtPerfilCiudadano();
        ciudadano.setDireccion("mikasa");
        ciudadano.setEstadoCivil(EstadoCivil.DIVORCIADO);
       // ciudadano.setFechaNacimiento(new Date("2004-01-12"));

        Fabrica.getInstancia().getControladorAltaUsuario().AltaUsuario(usuario);
        Fabrica.getInstancia().getControladorAltaFuncionario().AltaPerfil(usuario,funcionario);
        Fabrica.getInstancia().getControladorAltaFuncionario().AltaPerfil(usuario,ciudadano);

    }
}
