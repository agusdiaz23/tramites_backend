package logica;

import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class AsignaTramite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignado;

    @OneToOne(mappedBy = "usuario")
    @JoinColumn(name="func_asigna")         //PUEDE ROMPERSE YA QUE USUARIO ES OTRA RELACION
                                            //BUSCA TRAER LA CI
    private PerfilFuncionario funcionarioAsigna;

    @OneToMany(mappedBy = "usuario")
    @JoinColumn(name = "func_asignado")
    private List<PerfilFuncionario> funcionariosAsignados = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Tramite tramite;

    public AsignaTramite(){
        super();
    }
    public AsignaTramite(Date fecha){
        this.fechaAsignado = fecha;
    }
    public void setId(int id){ this.id= id;}
    public void setFechaAsignado(Date fecha){ this.fechaAsignado = fecha;}
    public int getId(){return this.id;}
    public Date getFechaAsignado(){return this.fechaAsignado;}
}
