package logica;

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalizado;
    @Enumerated(EnumType.STRING)
    private TipoTramite tipo;
    @Enumerated(EnumType.STRING)
    private EstadoTramite estado;


    @ManyToOne(cascade = CascadeType.ALL)
    private AsignaTramite asignaTramite;
    @OneToOne(cascade = CascadeType.ALL)
    private Autorizacion autorizacion;
    @OneToMany(cascade = CascadeType.ALL)
    private List<EventoTramite> eventosTramites = new ArrayList<>();

    public Tramite() {
        super();
    }

    public Tramite(Date fechaInicio, Date fechaVencimiento, Date fechaFinalizado, TipoTramite tipo, EstadoTramite estado) {
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaFinalizado = fechaFinalizado;
        this.tipo = tipo;
        this.estado = estado;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public void setFechaFinalizado(Date fechaFinalizado) {
        this.fechaFinalizado = fechaFinalizado;
    }
    public void setTipo(TipoTramite tipo) {
        this.tipo = tipo;
    }
    public void setEstado(EstadoTramite estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Date getFechaFinalizado() {
        return fechaFinalizado;
    }

    public TipoTramite getTipo() {
        return tipo;
    }

    public EstadoTramite getEstado() {
        return estado;
    }
}
