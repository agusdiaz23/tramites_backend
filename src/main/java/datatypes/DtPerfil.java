package datatypes;

public abstract class DtPerfil {
    private int id;
    private String ciUsuario;

    public DtPerfil(){}
    public DtPerfil(String ciUsuario){
        this.ciUsuario = ciUsuario;}

    public DtPerfil(int id, String ciUsuario){
        this.id = id;
        this.ciUsuario = ciUsuario;}

    public String getCiUsuario() {
        return ciUsuario;
    }
    public void setCiUsuario(String ciUsuario) {
        this.ciUsuario = ciUsuario;
    }
    public void setId(int id){this.id = id;}
    public int getId(){return this.id;};
}
