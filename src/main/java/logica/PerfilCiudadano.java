package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtTramite;
import datatypes.EstadoCivil;
import jakarta.persistence.*;
import persistencia.Conexion;

@Entity
public class PerfilCiudadano extends Perfil {

    @Column
    private String direccion;
    //@Temporal(TemporalType.DATE)
    private LocalDate fechaNacimiento;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Tramite> tramites = new ArrayList<>();


    public PerfilCiudadano(){}
    public PerfilCiudadano(String direccion, LocalDate fecha, EstadoCivil estado){
        this.direccion= direccion;
        this.fechaNacimiento = fecha;
        this.estadoCivil = estado;
    }

    public String getDireccion(){return this.direccion;}
    public LocalDate getFechaNacimiento(){return this.fechaNacimiento;}
    public EstadoCivil getEstadoCivil(){return this.estadoCivil;}
    public void setDireccion(String direccion){this.direccion=direccion;}
    public void setFechaNacimiento(LocalDate fecha){this.fechaNacimiento=fecha;}
    public void setEstadoCivil(EstadoCivil estado){this.estadoCivil = estado;}
//
//    public void agregarTramite(Tramite tramite) {
//
//        this.tramites.add(tramite);
//
//    }
}
