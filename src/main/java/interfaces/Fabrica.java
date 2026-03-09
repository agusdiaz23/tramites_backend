package interfaces;

import logica.*;

public class Fabrica {

    private static Fabrica instancia = null;

    private Fabrica(){}

    public static Fabrica getInstancia() {
        if(instancia == null){
            instancia = new Fabrica();
        }
        return instancia;
    }

    public IControladorEventoTramite getControladorEventoTramite(){return new ControladorEventoTramite();}
    public IControladorAsignarTramite getControladorAsignarTramite(){return new ControladorAsignarTramite();}
    public IControladorTramite getControladorTramite() {
        return new ControladorTramite();
    }
    public IControladorUsuario getControladorUsuario() {
        return new ControladorUsuario();
    }
    public IControladorPerfil getControladorPerfil() {
        return new ControladorPerfil();
    }

}
