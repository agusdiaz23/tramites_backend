package interfaces;

import logica.ControladorAsignarTramite;
import logica.ControladorPerfil;
import logica.ControladorTramite;
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

    public IControladorAsignarTramite getControladorAsignarTramite(){return new ControladorAsignarTramite();}
    public IControladorTramite getControladorTramite() {
        return new ControladorTramite();
    }
    public IControladorUsuario getControladorAltaUsuario() {
        return new ControladorUsuario();
    }
    public IControladorPerfil getControladorAltaFuncionario() {
        return new ControladorPerfil();
    }
}
