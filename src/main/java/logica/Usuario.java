package logica;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @Column(name = "ci_usuario", unique = true)
    private String ci;
    @Column
    private String nombre;
    @Column
    private String apellido;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Perfil> perfiles = new ArrayList<>();

    public Usuario(){}
    public Usuario(String ci, String nombre, String apellido, List<Perfil> perfiles){
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.perfiles = perfiles;
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
    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
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
    public List<Perfil> getPerfiles() { return perfiles;}

    //void agregarPerfil
    //void getPerfilCiudadano
    //void getPerfilFuncionario


}
