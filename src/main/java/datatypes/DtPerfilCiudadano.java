package datatypes;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

public class DtPerfilCiudadano extends DtPerfil{

    private int id;
    private String direccion;
    private LocalDate fechaNacimiento;
    private EstadoCivil estadoCivil;

    public DtPerfilCiudadano(){super();}
    public DtPerfilCiudadano(int id, String ciUsuario,String direccion, LocalDate fechaNacimiento, EstadoCivil estadoCivil){
        super(id,ciUsuario);
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
    }
    public void setId(int id){this.id = id;}
    public int getId(){return this.id;}
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
