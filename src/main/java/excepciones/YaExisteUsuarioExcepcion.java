package excepciones;

public class YaExisteUsuarioExcepcion extends RuntimeException {
    public YaExisteUsuarioExcepcion(String message) {
        super(message);
    }
}
