package interfaces;

import logica.ControladorAltaPerfil;
import logica.ControladorAltaUsuario;

public class Fabrica {

    private static Fabrica instancia = null;

    private Fabrica(){}

    public static Fabrica getInstancia() {
        if(instancia == null){
            instancia = new Fabrica();
        }
        return instancia;
    }

    public IControladorAltaUsuario getControladorAltaUsuario() {
        return new ControladorAltaUsuario();
    }
    public IControladorAltaPerfil getControladorAltaFuncionario() {
        return new ControladorAltaPerfil();
    }
}
