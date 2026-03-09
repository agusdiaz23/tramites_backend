package logica;

import datatypes.DtUsuario;
import excepciones.YaExisteUsuarioExcepcion;
import interfaces.IControladorUsuario;

import java.util.ArrayList;
import java.util.List;

public class ControladorUsuario implements IControladorUsuario {

    private ManejadorUsuario manejadorUsuario = ManejadorUsuario.getInstancia();

    public void AltaUsuario(DtUsuario usuario){

        if(!manejadorUsuario.existeUsuario(usuario.getCi())){
            System.out.print("no existe usuario, voy a crearlo");
            manejadorUsuario.registrarUsuario(usuario);
        }else{
             throw new  YaExisteUsuarioExcepcion("ya existe un usuario con esa cedula");
        }
    }

    public List<String> verCiUsuarios(){

        List<Usuario> usuarios = ManejadorUsuario.getInstancia().verUsuarios();

        List<String> ciUsuarios = new ArrayList<>();
        for(Usuario u : usuarios){
            ciUsuarios.add(u.getCi());
        }
        return ciUsuarios;
    }
}
