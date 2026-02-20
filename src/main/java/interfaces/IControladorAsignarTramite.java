package interfaces;

import datatypes.DtTramite;
import datatypes.DtPerfilFuncionario;

import java.util.List;

public interface IControladorAsignarTramite {
    public void asignarTramite(DtPerfilFuncionario fAsigna, DtTramite tramite,
                               List<DtPerfilFuncionario> fAsignados);
}
