package interfaces;

import datatypes.DtTramite;
import datatypes.DtPerfilFuncionario;
import excepciones.FuncionarioYaAsignado;
import jakarta.persistence.EntityManager;
import logica.PerfilFuncionario;
import logica.Tramite;

import java.util.List;

public interface IControladorAsignarTramite {
    public void asignarTramite(DtPerfilFuncionario dtFuncAsigna, DtTramite dtTramite,
                                               DtPerfilFuncionario dtFuncAsignado) throws FuncionarioYaAsignado;
    public List<Object[]> funcionariosAsignadosTramiteInfoUsuario(DtTramite tramite);
    public void desasignarTramite(DtPerfilFuncionario dtFuncJefe, DtTramite dtTramite, DtPerfilFuncionario dtFuncInspector);
}
