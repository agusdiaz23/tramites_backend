package logica;

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

    @OneToOne
    @JoinColumn(name = "func_asigna")
    private PerfilFuncionario funcionarioAsigna;

    @ManyToMany
    @JoinColumn(name = "func_asignado")
    private List<PerfilFuncionario> funcionariosAsignados = new ArrayList<>();

    @OneToOne
    private Tramite tramite;

    public PerfilFuncionario getFuncionarioAsigna() {return funcionarioAsigna;}
    public void setFuncionarioAsigna(PerfilFuncionario funcionarioAsigna) {
        System.out.println("ASOCIADO FUNCIONARIO: "+funcionarioAsigna.getId());
        this.funcionarioAsigna = funcionarioAsigna;}
    public Tramite getTramite() {return tramite;}
    public void setTramite(Tramite tramite) {this.tramite = tramite;}
    public List<PerfilFuncionario> getFuncionariosAsignados() {return funcionariosAsignados;}
    public void setFuncionariosAsignados(List<PerfilFuncionario> funcionariosAsignados) {this.funcionariosAsignados = funcionariosAsignados;}
    public AsignaTramite(){}
    public AsignaTramite(LocalDate fecha){
        this.fechaAsignado = fecha;
    }
    public void setId(int id){ this.id= id;}
    public void setFechaAsignado(LocalDate fecha){ this.fechaAsignado = fecha;}
    public int getId(){return this.id;}
    public LocalDate getFechaAsignado(){return this.fechaAsignado;}
}
