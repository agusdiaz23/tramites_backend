package logica;

import datatypes.DtUsuario;
import interfaces.IControladorAltaUsuario;

public class ControladorAltaUsuario implements IControladorAltaUsuario{

    private ManejadorUsuario manejadorUsuario = ManejadorUsuario.getInstancia();

    public void AltaUsuario(DtUsuario usuario){
        if(!manejadorUsuario.existeUsuario(usuario.getCi())){
            System.out.print("no existe usuario, voy a crearlo");
            manejadorUsuario.registrarUsuario(usuario);
        }else{
            //excepcion existe usuario
        }
    }
}
