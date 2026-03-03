package presentacion;

import javax.swing.JInternalFrame;

import datatypes.DtUsuario;
import excepciones.YaExisteUsuarioExcepcion;
import interfaces.IControladorUsuario;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaUsuarioInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    private Principal principal;
    private IControladorUsuario iconUsuario;
    private JTextField textFieldCI;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldEmail;
    private JTextField textFieldContrasena;

    public AltaUsuarioInternalFrame(IControladorUsuario iconUsuario, Principal principal) {
        this.iconUsuario = iconUsuario;
        this.principal = principal;

        setTitle("Registrar Usuario");
        setBounds(100, 100, 450, 250);
        setResizable(false);
        setClosable(true);
        setIconifiable(false);
        setMaximizable(false);
        getContentPane().setLayout(null);
        JLabel lblCI = new JLabel("CI:");
        lblCI.setBounds(10, 20, 80, 20);
        getContentPane().add(lblCI);

        textFieldCI = new JTextField();
        textFieldCI.setBounds(100, 20, 250, 20);
        getContentPane().add(textFieldCI);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 55, 80, 20);
        getContentPane().add(lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(100, 55, 250, 20);
        getContentPane().add(textFieldNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(10, 90, 80, 20);
        getContentPane().add(lblApellido);

        textFieldApellido = new JTextField();
        textFieldApellido.setBounds(100, 90, 250, 20);
        getContentPane().add(textFieldApellido);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 125, 80, 20);
        getContentPane().add(lblEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(100, 125, 250, 20);
        getContentPane().add(textFieldEmail);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(10, 160, 80, 20);
        getContentPane().add(lblContrasena);

        textFieldContrasena = new JTextField();
        textFieldContrasena.setBounds(100, 160, 250, 20);
        getContentPane().add(textFieldContrasena);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                altaUsuarioAceptarActionPerformed(e);
            }
        });
        btnAceptar.setBounds(90, 180, 89, 23);
        getContentPane().add(btnAceptar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                altaUsuarioCancelarActionPerformed(e);
            }
        });
        btnCancelar.setBounds(261, 180, 89, 23);
        getContentPane().add(btnCancelar);
    }

    protected void altaUsuarioAceptarActionPerformed(ActionEvent e) {
        String ci = textFieldCI.getText();
        String nombre = textFieldNombre.getText();
        String apellido = textFieldApellido.getText();;
        String email = textFieldEmail.getText();
        String contrasena = textFieldContrasena.getText();

        DtUsuario dtUsuario = new DtUsuario(ci,nombre,apellido,email,contrasena);

        if (checkFormulario()) {
            try {
                iconUsuario.AltaUsuario(dtUsuario);
                JOptionPane.showMessageDialog(this, "Bibliotecario dado de alta exitosamente.", "Alta Bibliotecario", JOptionPane.INFORMATION_MESSAGE);
            }catch(YaExisteUsuarioExcepcion excepcion){
                JOptionPane.showMessageDialog(this, "ya existe con esa cedula mano", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            limpiarFormulario();
            setVisible(false);
        }
    }

    protected void altaUsuarioCancelarActionPerformed(ActionEvent e) {
        limpiarFormulario();
        setVisible(false);
    }

    private boolean checkFormulario() {
        if (textFieldNombre.getText().isEmpty() || textFieldEmail.getText().isEmpty() || textFieldContrasena.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos.", "Alta Bibliotecario", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void limpiarFormulario() {
        textFieldNombre.setText("");
        textFieldEmail.setText("");
        textFieldContrasena.setText("");
    }
}
