package interfaces;

import datatypes.DtTramite;
import datatypes.DtPerfilFuncionario;
import excepciones.FuncionarioYaAsignado;

import java.util.List;

public interface IControladorAsignarTramite {
    public void asignarTramite(DtPerfilFuncionario dtFuncAsigna, DtTramite dtTramite,
                                               DtPerfilFuncionario dtFuncAsignado) throws FuncionarioYaAsignado;
}
