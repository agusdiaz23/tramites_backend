package datatypes;

import jakarta.persistence.*;
import logica.AsignaTramite;
import logica.Autorizacion;
import logica.EventoTramite;

import java.time.LocalDate;

public class DtTramite {

    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaVencimiento;
    private LocalDate fechaFinalizado;
    private TipoTramite tipo;
    private EstadoTramite estado;
    private AsignaTramite asignaTramite;
    private Autorizacion autorizacion;
    //private List<EventoTramite> eventosTramites = new ArrayList<>();

    public DtTramite() {}

    public DtTramite(LocalDate fechaInicio, LocalDate fechaVencimiento, LocalDate fechaFinalizado,
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
}
