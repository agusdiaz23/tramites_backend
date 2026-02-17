package interfaces;

import logica.ControladorPerfil;
import logica.ControladorUsuario;

public class Fabrica {

    private static Fabrica instancia = null;

    private Fabrica(){}

    public static Fabrica getInstancia() {
        if(instancia == null){
            instancia = new Fabrica();
        }
        return instancia;
    }

    public IControladorUsuario getControladorAltaUsuario() {
        return new ControladorUsuario();
    }
    public IControladorPerfil getControladorAltaFuncionario() {
        return new ControladorPerfil();
    }
}
