package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.EstadoCivil;
import jakarta.persistence.*;

@Entity
public class PerfilCiudadano {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String direccion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tramite> tramites = new ArrayList<>();


    public PerfilCiudadano(){}
    public PerfilCiudadano(String direccion, Date fecha, EstadoCivil estado){
        this.direccion= direccion;
        this.fechaNacimiento = fecha;
        this.estadoCivil = estado;
    }

    public int getId(){return this.id;}
    public String getDireccion(){return this.direccion;}
    public Date getFechaNacimiento(){return this.fechaNacimiento;}
    public EstadoCivil getEstadoCivil(){return this.estadoCivil;}
    public void setId(int id){this.id=id;}
    public void setDireccion(String direccion){this.direccion=direccion;}
    public void setFechaNacimiento(Date fecha){this.fechaNacimiento=fecha;}
    public void setEstadoCivil(EstadoCivil estado){this.estadoCivil = estado;}
}
