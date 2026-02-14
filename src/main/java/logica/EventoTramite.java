package logica;
import java.util.Date;
import datatypes.*;
import jakarta.persistence.*;

@Entity
public class EventoTramite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipo;
    @Column
    private String motivo;
    // private coleccion archivos (? CUANDO ARME LA BD VEO
    @ManyToOne
    private EventoTramite evento;

    public EventoTramite(){}
    public EventoTramite(Date fecha, TipoEvento tipo, String motivo){
        this.fecha = fecha;
        this.tipo = tipo;
        this.motivo = motivo;
    }
    public void setId(int id){this.id = id;}
    public void setFecha(Date fecha){this.fecha = fecha;}
    public void setTipo(TipoEvento tipo){this.tipo = tipo;}
    public void setMotivo(String motivo){this.motivo = motivo;}
    public int getId(){return this.id;}
    public Date getFecha(){return this.fecha;}
    public TipoEvento getTipo(){return this.tipo;}
    public String getMotivo(){return this.motivo;}

}