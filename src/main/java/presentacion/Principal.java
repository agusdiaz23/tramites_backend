package presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;

import interfaces.*;

public class Principal {
    private JFrame frame;

    private AltaUsuarioInternalFrame altaUsuarioInternalFrame;
    private AltaPerfilInternalFrame altaPerfilInternalFrame;
    private IniciarTramiteInternalFrame iniciarTramiteInternalFrame;
    private AsignarTramiteInternalFrame asignarTramiteInternalFrame;
    private DesasignarTramiteInternalFrame desasignarTramiteInternalFrame;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Principal window = new Principal();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Principal() {
        initialize();

        /* publicadores.AltaLectorPublish publicadorLector = new publicadores.AltaLectorPublish();
        publicadorLector.publicar("localhost", "18015");

        publicadores.LoginPublish publicadorLogin = new publicadores.LoginPublish();
        publicadorLogin.publicar("localhost", "18016");

        publicadores.ModificarEstadoLectorPublish publicadorModificarEstadoLector = new publicadores.ModificarEstadoLectorPublish();
        publicadorModificarEstadoLector.publicar("localhost", "18017");

        publicadores.ModificarZonaLectorPublish publicadorModificarZonaLector = new publicadores.ModificarZonaLectorPublish();
        publicadorModificarZonaLector.publicar("localhost", "18018");

        publicadores.ControladorDonacionesPublish publicadorDonaciones = new publicadores.ControladorDonacionesPublish();
        publicadorDonaciones.publicar("localhost", "18019");

        publicadores.PrestamoPublish publicadorPrestamo = new publicadores.PrestamoPublish();
        publicadorPrestamo.publicar("localhost", "18020");

        publicadores.AltaDonacionLibroPublish publicadorAltaDonacionLibro = new publicadores.AltaDonacionLibroPublish();
        publicadorAltaDonacionLibro.publicar("localhost", "18021");

        publicadores.AltaDonacionEspecialPublish publicadorAltaDonacionEspecial = new publicadores.AltaDonacionEspecialPublish();
        publicadorAltaDonacionEspecial.publicar("localhost", "18022");

        publicadores.ConsultarDonacionPublish publicadorConsultarDonacion = new publicadores.ConsultarDonacionPublish();
        publicadorConsultarDonacion.publicar("localhost", "18023");

        publicadores.ConsultaDonacionYFechaPublish publicadorConsultaDonacionYFecha = new publicadores.ConsultaDonacionYFechaPublish();
        publicadorConsultaDonacionYFecha.publicar("localhost", "18024");

        publicadores.ListarPrestamosLectorPublish publicadorListarPrestamosLector = new publicadores.ListarPrestamosLectorPublish();
        publicadorListarPrestamosLector.publicar("localhost", "18025");

        publicadores.ModificarEstadoPrestamoPublish publicadorModificarEstadoPrestamo = new publicadores.ModificarEstadoPrestamoPublish();
        publicadorModificarEstadoPrestamo.publicar("localhost", "18026");

        publicadores.ListarPrestamosZonaPublish publicadorListarPrestamosZona = new publicadores.ListarPrestamosZonaPublish();
        publicadorListarPrestamosZona.publicar("localhost", "18027");

        publicadores.ModificarTodoPrestamoPublish publicadorModificarTodoPrestamo = new publicadores.ModificarTodoPrestamoPublish();
        publicadorModificarTodoPrestamo.publicar("localhost", "18028");

        publicadores.AutorizarPrestamoPublish publicadorAutorizarPrestamo = new publicadores.AutorizarPrestamoPublish();
        publicadorAutorizarPrestamo.publicar("localhost", "18029");
         */

        Fabrica fabrica = Fabrica.getInstancia();
        IControladorUsuario controladorUsuario = fabrica.getControladorUsuario();
        IControladorPerfil controladorPerfil = fabrica.getControladorPerfil();
        IControladorTramite controladorTramite = fabrica.getControladorTramite();
        IControladorAsignarTramite controladorasignarTramite = fabrica.getControladorAsignarTramite();

        Dimension desktopSize = frame.getSize();

        // === Alta Usuario ===
        altaUsuarioInternalFrame = new AltaUsuarioInternalFrame(controladorUsuario, this);
        altaUsuarioInternalFrame.setLocation(
                (desktopSize.width - altaUsuarioInternalFrame.getSize().width) / 2,
                (desktopSize.height - altaUsuarioInternalFrame.getSize().height) / 2
        );
        altaUsuarioInternalFrame.setVisible(false);
        frame.getContentPane().add(altaUsuarioInternalFrame);

        altaPerfilInternalFrame = new AltaPerfilInternalFrame(controladorUsuario, controladorPerfil, this);
        altaPerfilInternalFrame.setLocation(
                (desktopSize.width - altaPerfilInternalFrame.getSize().width) / 2,
                (desktopSize.height - altaPerfilInternalFrame.getSize().height) / 2
        );
        altaPerfilInternalFrame.setVisible(false);
        frame.getContentPane().add(altaPerfilInternalFrame);


        iniciarTramiteInternalFrame = new IniciarTramiteInternalFrame(controladorTramite, controladorPerfil, this);
        iniciarTramiteInternalFrame.setLocation(
                (desktopSize.width - iniciarTramiteInternalFrame.getSize().width) / 2,
                (desktopSize.height - iniciarTramiteInternalFrame.getSize().height) / 2
        );
        iniciarTramiteInternalFrame.setVisible(false);
        frame.getContentPane().add(iniciarTramiteInternalFrame);


        asignarTramiteInternalFrame = new AsignarTramiteInternalFrame(controladorTramite, controladorPerfil,
                controladorasignarTramite, this);
        asignarTramiteInternalFrame.setLocation(
                (desktopSize.width - asignarTramiteInternalFrame.getSize().width) / 2,
                (desktopSize.height - asignarTramiteInternalFrame.getSize().height) / 2
        );
        asignarTramiteInternalFrame.setVisible(false);
        frame.getContentPane().add(asignarTramiteInternalFrame);

        desasignarTramiteInternalFrame = new DesasignarTramiteInternalFrame(controladorTramite, controladorPerfil,
                controladorasignarTramite, this);
        desasignarTramiteInternalFrame.setLocation(
                (desktopSize.width - desasignarTramiteInternalFrame.getSize().width) / 2,
                (desktopSize.height - desasignarTramiteInternalFrame.getSize().height) / 2
        );
        desasignarTramiteInternalFrame.setVisible(false);
        frame.getContentPane().add(desasignarTramiteInternalFrame);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Sistema de Tramites");
        frame.setBounds(200, 200, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception e) {
            System.err.println("No se pudo aplicar Look and Feel del sistema: " + e.getMessage());
        }

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnAñadir = new JMenu("Añadir");
        mnAñadir.setMnemonic('A');
        menuBar.add(mnAñadir);

        JMenuItem mntmRegistrarUsuario = new JMenuItem("Registrar Usuario");
        mntmRegistrarUsuario.addActionListener(e -> altaUsuarioInternalFrame.setVisible(true));
        mnAñadir.add(mntmRegistrarUsuario);

        JMenuItem mntmNuevoPerfil = new JMenuItem("Nuevo Perfil");
        mntmNuevoPerfil.addActionListener(e-> altaPerfilInternalFrame.setVisible(true));
        mnAñadir.add(mntmNuevoPerfil);

        JMenuItem mntmIniciarTramite = new JMenuItem("Iniciar Tramite");
        mntmIniciarTramite.addActionListener(e-> iniciarTramiteInternalFrame.setVisible(true));
        mnAñadir.add(mntmIniciarTramite);

        JMenu mnAsignarTramite = new JMenu("Asignar");
        mnAñadir.setMnemonic('A');
        menuBar.add(mnAsignarTramite);

        JMenuItem mntmAsignarTramite = new JMenuItem("Asignar Tramite");
        mntmAsignarTramite.addActionListener(e-> asignarTramiteInternalFrame.setVisible(true));
        mnAsignarTramite.add(mntmAsignarTramite);

        JMenuItem mntmDesasignarTramite = new JMenuItem("Desasignar Tramite");
        mntmDesasignarTramite.addActionListener(e-> desasignarTramiteInternalFrame.setVisible(true));
        mnAsignarTramite.add(mntmDesasignarTramite);

       /* JMenuItem mntmAgregarBibliotecario = new JMenuItem("Agregar bibliotecario");
        mntmAgregarBibliotecario.addActionListener(e -> agregarBibliotecarioInternalFrame.setVisible(true));
        mnAñadir.add(mntmAgregarBibliotecario);

        JMenuItem mntmRegistrarLibro = new JMenuItem("Registrar libro");
        mntmRegistrarLibro.addActionListener(e -> altaDonacionLibroInternalFrame.setVisible(true));
        mnAñadir.add(mntmRegistrarLibro);

        JMenuItem mntmRegistrarArticuloEspecial = new JMenuItem("Registrar artículo especial");
        mntmRegistrarArticuloEspecial.addActionListener(e -> altaDonacionEspecialInternalFrame.setVisible(true));
        mnAñadir.add(mntmRegistrarArticuloEspecial);

        JMenuItem mntmRegistrarPrestamo = new JMenuItem("Registrar préstamo");
        mntmRegistrarPrestamo.addActionListener(e -> altaPrestamoInternalFrame.setVisible(true));
        mnAñadir.add(mntmRegistrarPrestamo);

        JMenu mnEditar = new JMenu("Editar");
        mnEditar.setMnemonic('E');
        menuBar.add(mnEditar);

        JMenuItem mntmCambiarEstadoLector = new JMenuItem("Cambiar estado de lector");
        mntmCambiarEstadoLector.addActionListener(e -> {
            estadoLectorInternalFrame.limpiarFormulario();
            estadoLectorInternalFrame.cargarNombresLectores();
            estadoLectorInternalFrame.setVisible(true);
        });
        mnEditar.add(mntmCambiarEstadoLector);

        JMenuItem mntmCambiarZonaLector = new JMenuItem("Cambiar zona de lector");
        mntmCambiarZonaLector.addActionListener(e -> modificarZonaInternalFrame.setVisible(true));
        mnEditar.add(mntmCambiarZonaLector);

        JMenuItem mntmModificarEstadoPrestamo = new JMenuItem("Modificar estado de préstamo");
        mntmModificarEstadoPrestamo.addActionListener(e -> modificarEstadoPrestamoInternalFrame.setVisible(true));
        mnEditar.add(mntmModificarEstadoPrestamo);

        JMenuItem mntmModificarPrestamo = new JMenuItem("Modificar préstamo");
        mntmModificarPrestamo.addActionListener(e -> modificarTodoPrestamoInternalFrame.setVisible(true));
        mnEditar.add(mntmModificarPrestamo);

        JMenu mnBuscar = new JMenu("Buscar");
        mnBuscar.setMnemonic('B');
        menuBar.add(mnBuscar);

        JMenuItem mntmConsultarDonacion = new JMenuItem("Consultar donaciones");
        mntmConsultarDonacion.addActionListener(e -> consultarDonacionInternalFrame.setVisible(true));
        mnBuscar.add(mntmConsultarDonacion);

        JMenuItem mntmConsultarDonacionYFecha = new JMenuItem("Consultar donaciones por fecha");
        mntmConsultarDonacionYFecha.addActionListener(e -> consultaDonacionYFechaInternalFrame.setVisible(true));
        mnBuscar.add(mntmConsultarDonacionYFecha);

        JMenuItem mntmResumenPorZona = new JMenuItem("Resumen por zona");
        mntmResumenPorZona.addActionListener(e -> consultarZonaLectorInternalFrame.setVisible(true));
        mnBuscar.add(mntmResumenPorZona);

        JMenuItem mntmListarPrestamosPorLector = new JMenuItem("Listar préstamos por lector");
        mntmListarPrestamosPorLector.addActionListener(e -> listarPrestamosInternalFrame.setVisible(true));
        mnBuscar.add(mntmListarPrestamosPorLector);

        JMenuItem mntmListarPrestamosBibliotecario = new JMenuItem("Listar préstamos por bibliotecario");
        mntmListarPrestamosBibliotecario.addActionListener(e -> listarPrestamosBibliotecarioInternalFrame.setVisible(true));
        mnBuscar.add(mntmListarPrestamosBibliotecario);

        JMenuItem mntmListarPrestamosComunes = new JMenuItem("Listar préstamos comunes");
        mntmListarPrestamosComunes.addActionListener(e -> listarPrestamosComunesInternalFrame.setVisible(true));
        mnBuscar.add(mntmListarPrestamosComunes);
*/
    }

}