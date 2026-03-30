package logica;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
    private Perfil perfil;

    public EventoTramite(){}
    public EventoTramite(LocalDate fecha, TipoEvento tipo, String motivo){
        this.fecha = fecha;
        this.tipo = tipo;
        this.motivo = motivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}