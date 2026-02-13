package logica;

import datatypes.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class PerfilFuncionario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    // private archivos legajo;  seria un tipo coleccion archivos para cv

    @OneToMany
    private List<EventoTramite> eventos;

    @OneToMany
    private List<AsignaTramite> tramitesAsigno;

    public PerfilFuncionario(){
        super();
    }
    public PerfilFuncionario(Cargo cargo){
        super();
        this.cargo = cargo;
    }
    public int getId(){return this.id;}
    public Cargo getCargo(){return this.cargo;}
    public void setId(int id){this.id=id;}
    public void setCargo(Cargo cargo){this.cargo = cargo;}
}
