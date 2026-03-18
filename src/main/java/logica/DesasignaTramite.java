package logica;

import datatypes.EstadoAsignado;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class DesasignaTramite {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

  //  @Temporal(TemporalType.TIMESTAMP)
    private LocalDate fechaDesasignado;

    @ManyToOne
    @JoinColumn(name = "func_desasigna")
    private PerfilFuncionario funcionarioDesasigna;

    @OneToOne
    private AsignaTramite asignaTramite;


    public DesasignaTramite(){}

    public DesasignaTramite(AsignaTramite asignaTramite, LocalDate fechaDesasignado, PerfilFuncionario funcionarioDesasigna) {
        this.asignaTramite = asignaTramite;
        this.fechaDesasignado = fechaDesasignado;
        this.funcionarioDesasigna = funcionarioDesasigna;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaDesasignado() {
        return fechaDesasignado;
    }

    public void setFechaDesasignado(LocalDate fechaDesasignado) {
        this.fechaDesasignado = fechaDesasignado;
    }

    public PerfilFuncionario getFuncionarioDesasigna() {
        return funcionarioDesasigna;
    }

    public void setFuncionarioDesasigna(PerfilFuncionario funcionarioDesasigna) {
        this.funcionarioDesasigna = funcionarioDesasigna;
    }

    public AsignaTramite getAsignaTramite() {
        return asignaTramite;
    }

    public void setAsignaTramite(AsignaTramite asignaTramite) {
        this.asignaTramite = asignaTramite;
    }
}
