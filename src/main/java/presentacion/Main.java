package presentacion;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import interfaces.Fabrica;
import datatypes.*;
import logica.PerfilFuncionario;

public class Main {
    public static void main() {
        DtUsuario usuario = new DtUsuario("123", "agus", "diaz");
        DtPerfilFuncionario funcionario = new DtPerfilFuncionario();
        funcionario.setCargo(Cargo.INSPECTOR);

        DtPerfilCiudadano ciudadano = new DtPerfilCiudadano();
        ciudadano.setId(2);
        ciudadano.setDireccion("mikasa");
        ciudadano.setEstadoCivil(EstadoCivil.DIVORCIADO);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate fechaNacimiento, fechaInicio, fechaVencimiento;

        fechaNacimiento = LocalDate.of(2004, 01, 12);

        ciudadano.setFechaNacimiento(fechaNacimiento);

        DtTramite tramite = new DtTramite();

        fechaInicio = LocalDate.of(2026,2,19);
        fechaVencimiento = LocalDate.of(2026,4,19);
        tramite.setId(1);
        tramite.setFechaInicio(fechaInicio);
        tramite.setFechaFinalizado(fechaVencimiento);
        tramite.setEstado(EstadoTramite.EN_ESPERA);
        tramite.setTipo(TipoTramite.INDIVIDUAL);

        Fabrica.getInstancia().getControladorAltaUsuario().AltaUsuario(usuario);
        Fabrica.getInstancia().getControladorAltaFuncionario().AltaPerfil(usuario,funcionario);
        Fabrica.getInstancia().getControladorAltaFuncionario().AltaPerfil(usuario,ciudadano);

        Fabrica.getInstancia().getControladorTramite().nuevoTramite(ciudadano, tramite);

        DtPerfilFuncionario funcAsigna = new DtPerfilFuncionario();
        DtUsuario usuarios, usuarioFuncAsigna;
        List<DtPerfilFuncionario> funcionariosAsignados = new ArrayList<>();
        DtPerfilFuncionario funcAsignado;

        usuarioFuncAsigna = new DtUsuario("3000", "agus", "crak");
        funcAsigna.setId(3);
        funcAsigna.setCargo(Cargo.JEFE);

        Fabrica.getInstancia().getControladorAltaUsuario().AltaUsuario(usuarioFuncAsigna);
        Fabrica.getInstancia().getControladorAltaFuncionario().AltaPerfil(usuarioFuncAsigna,funcAsigna);

        for(int i = 0; i < 2; i++){
            String str;
            str = String.valueOf(i);

            usuarios = new DtUsuario(str, "user"+str, "apellido"+str);
            funcAsignado = new DtPerfilFuncionario();
            funcAsignado.setId(i+4);
            funcAsignado.setCargo(Cargo.INSPECTOR);

            Fabrica.getInstancia().getControladorAltaUsuario().AltaUsuario(usuarios);
            Fabrica.getInstancia().getControladorAltaFuncionario().AltaPerfil(usuarios,funcAsignado);

            funcionariosAsignados.add(funcAsignado);
        }

        Fabrica.getInstancia().getControladorAsignarTramite().asignarTramite(funcAsigna,
                tramite, funcionariosAsignados);

    }
}
