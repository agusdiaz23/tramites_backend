package datatypes;

import jakarta.persistence.*;
import logica.AsignaTramite;
import logica.Autorizacion;
import logica.EventoTramite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtTramite {

    private int id;
    private Date fechaInicio;
    private Date fechaVencimiento;
    private Date fechaFinalizado;
    private TipoTramite tipo;
    private EstadoTramite estado;
    private AsignaTramite asignaTramite;
    private Autorizacion autorizacion;
    //private List<EventoTramite> eventosTramites = new ArrayList<>();

    public DtTramite() {}

    public DtTramite(Date fechaInicio, Date fechaVencimiento, Date fechaFinalizado,
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
