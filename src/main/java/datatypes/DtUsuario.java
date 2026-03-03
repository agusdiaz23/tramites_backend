package datatypes;

public class DtUsuario {
    private String ci;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;

    public DtUsuario(){}
    public DtUsuario(String ci, String nombre, String apellido, String email, String contrasena){
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
    }

    public String getCi() {
        return ci;
    }
    public void setCi(String ci) {
        this.ci = ci;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getContrasena() {return contrasena;}
    public void setContrasena(String contrasena) {this.contrasena = contrasena;}
}
