package logica;

import datatypes.EstadoAsignado;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class AsignaTramite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDate fechaAsignado;

    private LocalDate fechaDesasignado;

    private EstadoAsignado estado;

    @ManyToOne
    @JoinColumn(name = "func_asigna")
    private PerfilFuncionario funcionarioAsigna;

    @ManyToOne
    @JoinColumn(name = "func_asignado")
    private PerfilFuncionario funcionarioAsignado;

    @ManyToOne
    private Tramite tramite;

    public AsignaTramite(){
        this.fechaAsignado = LocalDate.now();
        this.estado = EstadoAsignado.ACTIVO;
    }
    public AsignaTramite(LocalDate fecha){
        this.fechaAsignado = fecha;
        this.estado = EstadoAsignado.ACTIVO;
    }

    public LocalDate getFechaDesasignado() {return fechaDesasignado;}
    public void setFechaDesasignado(LocalDate fechaDesasignado) {this.fechaDesasignado = fechaDesasignado;}
    public EstadoAsignado getEstado() {return estado;}
    public void setEstado(EstadoAsignado estado) {this.estado = estado;}
    public PerfilFuncionario getFuncionarioAsigna() {return funcionarioAsigna;}
    public void setFuncionarioAsigna(PerfilFuncionario funcionarioAsigna) {
        this.funcionarioAsigna = funcionarioAsigna;}
    public Tramite getTramite() {return tramite;}
    public void setTramite(Tramite tramite) {this.tramite = tramite;}
    public void setId(int id){ this.id= id;}
    public void setFechaAsignado(LocalDate fecha){ this.fechaAsignado = fecha;}
    public int getId(){return this.id;}
    public LocalDate getFechaAsignado(){return this.fechaAsignado;}

    public PerfilFuncionario getFuncionarioAsignado() {
        return funcionarioAsignado;
    }

    public void setFuncionarioAsignado(PerfilFuncionario funcionarioAsignado) {
        this.funcionarioAsignado = funcionarioAsignado;
    }
}
