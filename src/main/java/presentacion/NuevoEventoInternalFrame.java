package presentacion;

import datatypes.*;
import excepciones.YaTienePerfil;
import interfaces.IControladorEventoTramite;
import interfaces.IControladorPerfil;
import interfaces.IControladorTramite;
import interfaces.IControladorUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;

public class NuevoEventoInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    private Principal principal;
    private IControladorPerfil iconPerfil;
    private IControladorTramite iconTramite;
    private IControladorEventoTramite iconEventoTramite;

    private JComboBox comboboxUsuarios;
    private JComboBox comboboxTipoPerfil;
    private JComboBox comboboxEstadoCivil;
    private JComboBox comboboxCargoFuncionario;
    private JTextField textFieldFechaNacimiento;
    private JTextField textFieldDireccion;
    private JLabel lblDireccion;
    private JLabel lblFechaNacimiento;
    private JLabel lblEstadoCivil;
    private JLabel lblCargo;
    private JButton btnAceptar;
    private JButton btnCancelar;

    private TiposPerfil formularioPerfilActivo;

    public NuevoEventoInternalFrame(IControladorTramite iconTramite,
                                    IControladorPerfil iconPerfil,
                                    IControladorEventoTramite iconEventoTramite,
                                    Principal principal) {
        this.iconTramite = iconTramite;
        this.iconPerfil = iconPerfil;
        this.iconEventoTramite = iconEventoTramite;
        this.principal = principal;

        setTitle("Nuevo evento");
        setBounds(100, 100, 450, 250);
        setResizable(false);
        setClosable(true);
        setIconifiable(false);
        setMaximizable(false);
        getContentPane().setLayout(null);

        JLabel lblUsuario = new JLabel("ID Tramite:");
        lblUsuario.setBounds(10, 20, 80, 20);
        getContentPane().add(lblUsuario);

        textFieldTramite = new JTextField(); //TRAER USUARIOS CON UNA FUNCION
        textFieldTramite.setBounds(100, 20, 250, 20);
        getContentPane().add(textFieldTramite);

        JLabel lblPerfil = new JLabel("Perfil:");
        lblPerfil.setBounds(10, 55, 80, 20);
        getContentPane().add(lblPerfil);

        comboboxTipoPerfil = new JComboBox<>(TiposPerfil.values());
        comboboxTipoPerfil.setBounds(100, 55, 250, 20);
        getContentPane().add(comboboxTipoPerfil);

        comboboxTipoPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        lblEvento = new JLabel("Eventos Disponibles:");
        lblEvento.setBounds(10, 90, 80, 20);
        getContentPane().add(lblEvento);
        lblEvento.setVisible(false);

        comboboxEvento = new JComboBox<>();
        comboboxEvento.setBounds(100, 90, 250, 20);
        getContentPane().add(comboboxEvento);
        comboboxEvento.setVisible(false);


        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aceptarActionPerformed(e);
            }
        });
        btnAceptar.setBounds(90, 180, 89, 23);
        getContentPane().add(btnAceptar);
        btnAceptar.setEnabled(false);

        JButton btnRefrescar = new JButton("Refrescar");
        btnRefrescar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                altaUsuarioRefrescarActionPerformed(e, iconUsuario);
            }
        });
        btnRefrescar.setBounds(115, 180, 89, 23);
        getContentPane().add(btnRefrescar);
        btnRefrescar.setEnabled(true);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                altaUsuarioCancelarActionPerformed(e);
            }
        });
        btnCancelar.setBounds(261, 180, 89, 23);
        getContentPane().add(btnCancelar);
    }

    protected void altaUsuarioRefrescarActionPerformed(ActionEvent e, IControladorUsuario iconUsuario) {
        comboboxUsuarios.removeAllItems();
        List<String> usuarios = iconUsuario.verCiUsuarios();

        for (String ci : usuarios) {
            comboboxUsuarios.addItem(ci);
        }

    }
    protected void aceptarActionPerformed(ActionEvent e) {

        if (checkFormulario()) {

            JOptionPane.showMessageDialog(this, "Perfil " + comboboxTipoPerfil.getSelectedItem() + "ha sido creado exitosamente.", "AltaPerfil", JOptionPane.INFORMATION_MESSAGE);
            limpiarFormulario();
        }
    }

    protected void altaUsuarioCancelarActionPerformed(ActionEvent e) {
        limpiarFormulario();
        setVisible(false);
    }

    //CAMBIARLO A BOOLEAN
    private boolean checkFormulario() {
        if (comboboxUsuarios.getSelectedIndex() == -1 || comboboxTipoPerfil.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos.", "Alta Bibliotecario", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }


    private void limpiarFormulario() {
        /*textFieldNombre.setText("");
        textFieldEmail.setText("");
        textFieldContrasena.setText("");*/
    }
}
