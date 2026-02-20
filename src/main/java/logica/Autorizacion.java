package logica;

import java.time.LocalDate;
import java.util.Date;
import datatypes.*;
import jakarta.persistence.*;

@Entity
public class Autorizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
   // @Temporal(TemporalType.TIMESTAMP)
    private LocalDate fechaExpedida;
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDate fechaVencimiento;
    @Enumerated(EnumType.STRING)
    private TipoAutorizacion tipo;
    @Enumerated(EnumType.STRING)
    private EstadoAutorizacion estado;

    public Autorizacion(){}
    public Autorizacion(LocalDate fechaExpedida, LocalDate fechaVencimiento, TipoAutorizacion tipo, EstadoAutorizacion estado){
        this.fechaExpedida = fechaExpedida;
        this.fechaVencimiento = fechaVencimiento;
        this.tipo = tipo;
        this.estado = estado;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setFechaExpedida(LocalDate fecha){
        this.fechaExpedida = fecha;
    }
    public void setFechaVencimiento(LocalDate fecha){
        this.fechaVencimiento = fecha;
    }
    public void setTipoAutorizacion(TipoAutorizacion tipo){
        this.tipo = tipo;
    }
    public void setEstadoAutorizacion(EstadoAutorizacion estado){
        this.estado = estado;
    }
    public int getId(){ return this.id;}
    public LocalDate getFechaExpedida(){ return this.fechaExpedida;}
    public LocalDate getFechaVencimiento(){ return this.fechaVencimiento;}
    public TipoAutorizacion getTipoAutorizacion(){return this.tipo;};
    public EstadoAutorizacion getEstadoAutorizacion(){return this.estado;}
}
