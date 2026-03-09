package logica;

import datatypes.DtPerfilCiudadano;
import datatypes.DtPerfilFuncionario;
import datatypes.DtUsuario;
import datatypes.DtPerfil;
import interfaces.IControladorPerfil;
import jakarta.persistence.EntityManager;
import persistencia.Conexion;

public class ControladorPerfil implements IControladorPerfil {
    private static ManejadorUsuario manejadorUsuario = ManejadorUsuario.getInstancia();

    public void AltaPerfil(DtUsuario usuario, DtPerfil dtPerfil){
        //pre: El usuario existe, sino no llegas hasta aca.
        EntityManager em = Conexion.getInstancia().getEntityManager();
        Usuario objetoUsuario = manejadorUsuario.traerUsuario(usuario.getCi(), em);

        System.out.println("llegue a alta perfil, usuario es: " + objetoUsuario.getCi());


        if(dtPerfil instanceof DtPerfilFuncionario){
            //Hago polimorfismo y creo instancia PerfilFuncionario
            em.getTransaction().begin();
            DtPerfilFuncionario dtPerfilFuncionario = (DtPerfilFuncionario) dtPerfil;
            PerfilFuncionario perfil = new PerfilFuncionario(dtPerfilFuncionario.getCargo());
            perfil.setUsuario(objetoUsuario);
            em.persist(perfil);
            em.getTransaction().commit();
            //objetoUsuario.agregarPerfil(perfil);
        }
        else if(dtPerfil instanceof DtPerfilCiudadano){
            //Hago polimorfismo y creo instancia PerfilCiudadano

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
            //KABUM
        }
        em.close();
    }
}
