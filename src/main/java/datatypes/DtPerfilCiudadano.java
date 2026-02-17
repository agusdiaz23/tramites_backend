package datatypes;

import jakarta.persistence.*;

import java.util.Date;

public class DtPerfilCiudadano extends DtPerfil{

    private String direccion;
    private Date fechaNacimiento;
    private EstadoCivil estadoCivil;

    public DtPerfilCiudadano(){super();}
    public DtPerfilCiudadano(int id, String ciUsuario,String direccion, Date fechaNacimiento, EstadoCivil estadoCivil){
        super(id,ciUsuario);
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
