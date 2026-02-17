package logica;

import datatypes.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class PerfilFuncionario extends Perfil{
    @Column
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    // private archivos legajo;  seria un tipo coleccion archivos para cv

    @OneToMany
    private List<EventoTramite> eventos;

    public PerfilFuncionario(){super();}
    public PerfilFuncionario(Cargo cargo){
        super();
        this.cargo = cargo;
    }
    public Cargo getCargo(){return this.cargo;}
    public void setCargo(Cargo cargo){this.cargo = cargo;}
}
