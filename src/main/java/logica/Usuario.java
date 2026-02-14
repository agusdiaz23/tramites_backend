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

    @OneToOne(cascade = CascadeType.ALL)
    private PerfilCiudadano ciudadano;

    @OneToOne(cascade = CascadeType.ALL)
    private PerfilFuncionario funcionario;

    public Usuario(){}
    public Usuario(String ci, String nombre, String apellido, PerfilCiudadano ciudadano,
                   PerfilFuncionario funcionario){
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudadano = ciudadano;
        this.funcionario = funcionario;
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
    public void setCiudadano(PerfilCiudadano ciudadano) {
        this.ciudadano = ciudadano;
    }
    public void setFuncionario(PerfilFuncionario funcionario) {
        this.funcionario = funcionario;
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
    public PerfilFuncionario getFuncionario() {
        return funcionario;
    }
    public PerfilCiudadano getCiudadano() {
        return ciudadano;
    }

}
