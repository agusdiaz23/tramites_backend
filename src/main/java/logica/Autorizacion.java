package logica;

import java.util.Date;
import datatypes.*;
import jakarta.persistence.*;

@Entity
public class Autorizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaExpedida;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Enumerated(EnumType.STRING)
    private TipoAutorizacion tipo;
    @Enumerated(EnumType.STRING)
    private EstadoAutorizacion estado;

    public Autorizacion(){
        super();
    }
    public Autorizacion(Date fechaExpedida, Date fechaVencimiento, TipoAutorizacion tipo, EstadoAutorizacion estado){
        super();
        this.fechaExpedida = fechaExpedida;
        this.fechaVencimiento = fechaVencimiento;
        this.tipo = tipo;
        this.estado = estado;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setFechaExpedida(Date fecha){
        this.fechaExpedida = fecha;
    }
    public void setFechaVencimiento(Date fecha){
        this.fechaVencimiento = fecha;
    }
    public void setTipoAutorizacion(TipoAutorizacion tipo){
        this.tipo = tipo;
    }
    public void setEstadoAutorizacion(EstadoAutorizacion estado){
        this.estado = estado;
    }
    public int getId(){ return this.id;}
    public Date getFechaExpedida(){ return this.fechaExpedida;}
    public Date getFechaVencimiento(){ return this.fechaVencimiento;}
    public TipoAutorizacion getTipoAutorizacion(){return this.tipo;};
    public EstadoAutorizacion getEstadoAutorizacion(){return this.estado;}
}
