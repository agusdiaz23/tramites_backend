package logica;

import datatypes.DtPerfilFuncionario;
import datatypes.EstadoAsignado;
import jakarta.persistence.EntityManager;
import persistencia.Conexion;

import java.util.ArrayList;
import java.util.List;

public class ManejadorAsignaTramite {
    private static ManejadorAsignaTramite instancia = null;

    private ManejadorAsignaTramite(){}

    public static ManejadorAsignaTramite getInstancia() {
        if(instancia == null){
            instancia = new ManejadorAsignaTramite();
        }
        return instancia;
    }

    public List<AsignaTramite> traerAsignaTramite(Tramite tramite, PerfilFuncionario funcJefe,
                                                  PerfilFuncionario funcInspector, EntityManager em){
        List<AsignaTramite> retorno = new ArrayList<>();

        //SI NADA ES NULL, FILTRAS POR FUNC_ASIGNA Y FUNC_ASIGNADO
        if(funcJefe != null && funcInspector != null){
            retorno = em.createQuery("SELECT at FROM AsignaTramite at " +
                    "WHERE at.tramite = tramite " +
                    "AND at.funcionarioAsigna = funcJefe " +
                    "AND at.funcionarioAsignado = funcInspector", AsignaTramite.class).getResultList();
        }else if(funcJefe == null){
            if(funcInspector == null){
                //SI FUNC_ASIGNA Y ASIGNADO SON NULL, DEVUELVE TODOS FUNCIONARIOS ASIGNADOS A UN TRAMITE
                retorno = em.createQuery("SELECT at FROM AsignaTramite at " +
                        "WHERE at.tramite = tramite ", AsignaTramite.class).getResultList();
            }else{
                //SI SOLO FUNC_ASIGNA ES NULL, FILTRO POR FUNCIONARIO ASIGNADO AL TRAMITE
                retorno = em.createQuery("SELECT at FROM AsignaTramite at " +
                        "WHERE at.tramite = tramite " +
                        "AND at.funcionarioAsignado = funcInspector", AsignaTramite.class).getResultList();
            }
        }
        return retorno;
    }

    public List<AsignaTramite> traerAsignadosActivosPorTramite(Tramite tramite, EntityManager em){
        return em.createQuery("SELECT at FROM AsignaTramite at " +
                        "WHERE at.tramite = tramite " +
                        "AND at.estado = :estado", AsignaTramite.class)
                .setParameter("estado", EstadoAsignado.ACTIVO).getResultList();
    }

    public AsignaTramite traerAsignaTramiteActivo (Tramite tramite,
                                                  PerfilFuncionario funcInspector, EntityManager em){
        //Devuelve unico resultado, tupla de asignaTramite donde (idTramite, idFuncAsignado) & estado = ACTIVO.

        return em.createQuery("SELECT at FROM AsignaTramite at " +
                "WHERE at.tramite = tramite " +
                "AND at.funcionarioAsignado = funcInspector " +
                "AND at.estado = :estado", AsignaTramite.class)
                .setParameter("estado", EstadoAsignado.ACTIVO).getSingleResult();
    }

    public boolean funcionarioEstaAsignadoATramite(PerfilFuncionario pf, Tramite tramite){
        EntityManager em = Conexion.getInstancia().getEntityManager();

        long filas = (long) em.createQuery("SELECT COUNT(at) " +
                "FROM AsignaTramite at " +
                "WHERE at.tramite = :tramite " +
                "AND at.funcionarioAsignado = :perfilFuncionario").setParameter("tramite", tramite)
                .setParameter("perfilFuncionario", pf).getSingleResult();

        return filas > 0;
    }
}
