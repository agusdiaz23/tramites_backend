package logica;

public class ManejadorFuncionario {
    private static ManejadorFuncionario instancia = null;

    private ManejadorFuncionario(){}

    public static ManejadorFuncionario getInstancia(){
        if(instancia == null){
            instancia = new ManejadorFuncionario();
        }
        return instancia;
    }
}
