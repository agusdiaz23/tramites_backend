package excepciones;

public class FuncionarioYaAsignado extends RuntimeException {
    public FuncionarioYaAsignado(String message) {
        super(message);
    }
}
