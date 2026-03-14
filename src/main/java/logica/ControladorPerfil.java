package logica;

import datatypes.DtPerfilCiudadano;
import datatypes.DtPerfilFuncionario;
import datatypes.DtUsuario;
import datatypes.DtPerfil;
import excepciones.YaTienePerfil;
import interfaces.IControladorPerfil;
import jakarta.persistence.EntityManager;
import persistencia.Conexion;

import java.util.ArrayList;
import java.util.List;

public class ControladorPerfil implements IControladorPerfil {
    private static ManejadorUsuario manejadorUsuario = ManejadorUsuario.getInstancia();
    private static ManejadorPerfil manejadorPerfil = ManejadorPerfil.getInstancia();


    public void AltaPerfil(DtUsuario usuario, DtPerfil dtPerfil) throws YaTienePerfil{
        //pre: El usuario existe, sino no llegas hasta aca.
        EntityManager em = Conexion.getInstancia().getEntityManager();
        Usuario objetoUsuario = manejadorUsuario.traerUsuario(usuario.getCi(), em);

        System.out.println("llegue a alta perfil, usuario es: " + objetoUsuario.getCi());

        if(dtPerfil instanceof DtPerfilFuncionario){
            //Hago polimorfismo y creo instancia PerfilFuncionario

            if(!manejadorUsuario.tienePerfilFuncionario(objetoUsuario)) {
                em.getTransaction().begin();

                DtPerfilFuncionario dtPerfilFuncionario = (DtPerfilFuncionario) dtPerfil;
                PerfilFuncionario perfil = new PerfilFuncionario(dtPerfilFuncionario.getCargo());
                perfil.setUsuario(objetoUsuario);
                em.persist(perfil);
                em.getTransaction().commit();
            }else{
                throw new YaTienePerfil("Ya tiene perfil funcionario");
            }
        }
        else if(dtPerfil instanceof DtPerfilCiudadano){
            //Hago polimorfismo y creo instancia PerfilCiudadano

            if(!manejadorUsuario.tienePerfilCiudadano(objetoUsuario)) {
                em.getTransaction().begin();
                DtPerfilCiudadano dtPerfilCiudadano = (DtPerfilCiudadano) dtPerfil;
                PerfilCiudadano perfil = new PerfilCiudadano(dtPerfilCiudadano.getDireccion(),
                        dtPerfilCiudadano.getFechaNacimiento(), dtPerfilCiudadano.getEstadoCivil());
                perfil.setUsuario(objetoUsuario);
                em.persist(perfil);
                //objetoUsuario.agregarPerfil(perfil);
                System.out.println("todo ok");
                em.getTransaction().commit();
            }else{
                throw new YaTienePerfil("Ya tiene perfil ciudadano");
            }
        }

        em.close();
    }

    public List<DtPerfilCiudadano> verPerfilesCiudadano(){
        List<PerfilCiudadano> perfilesCiudadano = manejadorPerfil.traerPerfilesCiudadanos();
        List<DtPerfilCiudadano> dtPerfilesCiudadano = new ArrayList<>();

        for(PerfilCiudadano p : perfilesCiudadano){
            dtPerfilesCiudadano.add(p.obtenerDt());
            System.out.println("A VER QUE ME LLEGÓ: " + p.obtenerDt().getId());
        }

        return dtPerfilesCiudadano;
    }

    public List<DtPerfilFuncionario> verPerfilesFuncionarioJefes(){
        EntityManager em = Conexion.getInstancia().getEntityManager();
        List<DtPerfilFuncionario> retorno = new ArrayList<>();

        for(PerfilFuncionario pf : manejadorPerfil.verPerfilesFuncionarioJefes(em)){
            retorno.add(pf.obtenerDt());
        }
        return retorno;
    }

    public List<DtPerfilFuncionario> verPerfilesFuncionarioInspectores(){
        EntityManager em = Conexion.getInstancia().getEntityManager();
        List<DtPerfilFuncionario> retorno = new ArrayList<>();

        for(PerfilFuncionario pf : manejadorPerfil.verPerfilesFuncionarioInspectores(em)){
            retorno.add(pf.obtenerDt());
        }
        return retorno;
    }
    public List<Object[]> verPerfilesFuncionarioInfoUsuario(){
        EntityManager em = Conexion.getInstancia().getEntityManager();
        List<Object[]> retorno = new ArrayList<>();

        for(Object[] o : manejadorPerfil.verPerfilesFuncionarioInfoUsuario(em)){
            retorno.add( new Object[]{ ((PerfilFuncionario)o[0]).obtenerDt(),
                            ((Usuario)o[1]).obtenerDT()
                            } );
        }
        return retorno;
    }

}
