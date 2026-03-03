package logica;

import java.util.*;
import jakarta.persistence.*;
import persistencia.Conexion;

@Entity
public class Usuario {

    @Id
    @Column(name = "ci_usuario", unique = true)
    private String ci;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String email;
    @Column
    private String contrasena;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Perfil> perfiles = new ArrayList<>();

    public Usuario(){}
    public Usuario(String ci, String nombre, String apellido, String email,
                   String contrasena, List<Perfil> perfiles){
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
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
    public void setEmail(String email) {this.email = email;}

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
    public String getEmail() {return email;}

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    void agregarPerfil(Perfil perfil) {
        EntityManager em = Conexion.getInstancia().getEntityManager();

        em.getTransaction().begin();
        this.perfiles.add(perfil);  //no tengo claro si antes tengo q polimorfear
        perfil.setUsuario(this);
        em.persist(perfil);
        em.getTransaction().commit();
        em.close();
    }

}
