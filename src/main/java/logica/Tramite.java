package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.*;
import jakarta.persistence.*;

@Entity
public class Tramite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
  //  @Temporal(TemporalType.TIMESTAMP)
    private LocalDate fechaInicio;
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDate fechaVencimiento;
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDate fechaFinalizado;
    @Enumerated(EnumType.STRING)
    private TipoTramite tipo;
    @Enumerated(EnumType.STRING)
    private EstadoTramite estado;

    @ManyToOne
    private PerfilCiudadano ciudadano;
    //@OneToOne(cascade = CascadeType.ALL) //CAMBIAR A LIST PARA HISTORIAL DE ASIGNACIONES
    //private AsignaTramite asignaTramite;
    @OneToOne(cascade = CascadeType.ALL)
    private Autorizacion autorizacion;
    @OneToMany(cascade = CascadeType.ALL)
    private List<EventoTramite> eventosTramites = new ArrayList<>();

    public Tramite() {}

    public Tramite(LocalDate fechaInicio, LocalDate fechaVencimiento, LocalDate fechaFinalizado,
                   TipoTramite tipo, EstadoTramite estado) {
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaFinalizado = fechaFinalizado;
        this.tipo = tipo;
        this.estado = estado;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public void setFechaFinalizado(LocalDate fechaFinalizado) {
        this.fechaFinalizado = fechaFinalizado;
    }
    public void setTipo(TipoTramite tipo) {
        this.tipo = tipo;
    }
    public void setEstado(EstadoTramite estado) {
        this.estado = estado;
    }
    public void setPerfilCiudadano(PerfilCiudadano ciudadano){this.ciudadano=ciudadano;}

    public int getId() {
        return id;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }
    public LocalDate getFechaFinalizado() {
        return fechaFinalizado;
    }
    public TipoTramite getTipo() {
        return tipo;
    }
    public EstadoTramite getEstado() {
        return estado;
    }
    public PerfilCiudadano getPerfilCiudadano(){ return ciudadano;}

   /* public AsignaTramite getAsignaTramite() {
        return asignaTramite;
    }

    public void setAsignaTramite(AsignaTramite asignaTramite) {
        this.asignaTramite = asignaTramite;
    }*/
}
