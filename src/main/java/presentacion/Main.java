package presentacion;

import java.text.SimpleDateFormat;
import java.util.*;

import interfaces.Fabrica;
import datatypes.*;

public class Main {
    public static void main()
    {
        DtUsuario usuario =  new DtUsuario("123", "agus", "diaz");
        DtPerfilFuncionario funcionario = new DtPerfilFuncionario();
        funcionario.setCargo(Cargo.INSPECTOR);

        DtPerfilCiudadano ciudadano = new DtPerfilCiudadano();
        ciudadano.setDireccion("mikasa");
        ciudadano.setEstadoCivil(EstadoCivil.DIVORCIADO);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha;

        try {
            fecha = sdf.parse("17/02/2026");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ciudadano.setFechaNacimiento(fecha);


        Fabrica.getInstancia().getControladorAltaUsuario().AltaUsuario(usuario);
        Fabrica.getInstancia().getControladorAltaFuncionario().AltaPerfil(usuario,funcionario);
        Fabrica.getInstancia().getControladorAltaFuncionario().AltaPerfil(usuario,ciudadano);

    }
}
