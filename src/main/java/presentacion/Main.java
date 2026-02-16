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
        Fabrica.getInstancia().getControladorAltaUsuario().AltaUsuario(new DtUsuario("123", "agus", "diaz"));
    }
}
