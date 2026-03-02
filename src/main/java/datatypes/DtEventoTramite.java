package datatypes;

import jakarta.persistence.*;
import logica.EventoTramite;
import logica.Tramite;

import java.time.LocalDate;

public class DtEventoTramite {

    private int id;
    private LocalDate fecha;
    private TipoEvento tipo;
    private String motivo;

    public DtEventoTramite(){}
    public DtEventoTramite(int id, LocalDate fecha, TipoEvento tipo, String motivo){
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.motivo = motivo;
    }
    public void setId(int id){this.id = id;}
    public void setFecha(LocalDate fecha){this.fecha = fecha;}
    public void setTipo(TipoEvento tipo){this.tipo = tipo;}
    public void setMotivo(String motivo){this.motivo = motivo;}
    public int getId(){return this.id;}
    public LocalDate getFecha(){return this.fecha;}
    public TipoEvento getTipo(){return this.tipo;}
    public String getMotivo(){return this.motivo;}
}
