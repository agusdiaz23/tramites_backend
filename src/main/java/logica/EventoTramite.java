package logica;
import java.time.LocalDate;
import java.util.Date;
import datatypes.*;
import jakarta.persistence.*;

@Entity
public class EventoTramite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
   // @Temporal(TemporalType.TIMESTAMP)
    private LocalDate fecha;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipo;
    @Column
    private String motivo;
    // private coleccion archivos (? CUANDO ARME LA BD VEO
    @ManyToOne
    private Tramite tramite;
    @ManyToOne
    private EventoTramite evento;

    public EventoTramite(){}
    public EventoTramite(LocalDate fecha, TipoEvento tipo, String motivo){
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

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }
}