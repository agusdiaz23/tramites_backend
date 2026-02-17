package datatypes;

public class DtPerfilFuncionario extends DtPerfil {

    private Cargo cargo;
    // private archivos legajo;  seria un tipo coleccion archivos para cv

    public DtPerfilFuncionario() {
        super();
    }
    public DtPerfilFuncionario(int id, Cargo cargo, String ciUsuario) {
        super(id,ciUsuario);
        this.cargo = cargo;
    }
    public Cargo getCargo() {
        return cargo;
    }
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}