package logica;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @Column(name = "ci_usuario", nullable = false, unique = true)
    private String ci;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;

    @OneToOne(cascade = CascadeType.ALL)
    private PerfilCiudadano ciudadano;

    @OneToOne(cascade = CascadeType.ALL)
    private PerfilFuncionario funcionario;


    public Usuario(){
        super();
    }
    public Usuario(String ci, String nombre, String apellido){
        super();
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public void setCi(String ci){
        this.ci = ci;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getCi(){
        return this.ci;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }

}
