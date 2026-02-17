package logica;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    private Usuario usuario;

    public Perfil(){}

    public int getId(){return this.id;}
    public void setId(int id){this.id=id;}
    public Usuario getUsuario(){return this.usuario;}
    public void setUsuario(Usuario usuario){this.usuario = usuario;}
}
