package logica;

import datatypes.DtPerfilCiudadano;
import datatypes.DtPerfilFuncionario;
import datatypes.DtUsuario;
import datatypes.DtPerfil;
import interfaces.IControladorPerfil;

public class ControladorPerfil implements IControladorPerfil {
    private static ManejadorUsuario manejadorUsuario = ManejadorUsuario.getInstancia();

    public void AltaPerfil(DtUsuario usuario, DtPerfil dtPerfil){
        //pre: El usuario existe, sino no llegas hasta aca.
        Usuario objetoUsuario = manejadorUsuario.traerUsuario(usuario.getCi());

        if(dtPerfil instanceof DtPerfilFuncionario){
            //Hago polimorfismo y creo instancia PerfilFuncionario
            DtPerfilFuncionario dtPerfilFuncionario = (DtPerfilFuncionario) dtPerfil;
            PerfilFuncionario perfil = new PerfilFuncionario(dtPerfilFuncionario.getCargo());
            objetoUsuario.agregarPerfil(perfil);
        }
        else if(dtPerfil instanceof DtPerfilCiudadano){
            //Hago polimorfismo y creo instancia PerfilCiudadano
            DtPerfilCiudadano dtPerfilCiudadano = (DtPerfilCiudadano) dtPerfil;
            PerfilCiudadano perfil = new PerfilCiudadano(dtPerfilCiudadano.getDireccion(),
                    dtPerfilCiudadano.getFechaNacimiento(), dtPerfilCiudadano.getEstadoCivil());
            objetoUsuario.agregarPerfil(perfil);
            System.out.println("todo ok");
        }else{
            //KABUM
        }

    }
}
