package presentacion;

import datatypes.*;
import excepciones.YaExisteUsuarioExcepcion;
import interfaces.IControladorPerfil;
import interfaces.IControladorUsuario;
import logica.ControladorUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;

public class AltaPerfilInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    private Principal principal;
    private IControladorPerfil iconPerfil;
   // private IControladorUsuario iconUsuario;

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

    public AltaPerfilInternalFrame(IControladorUsuario iconUsuario, IControladorPerfil iconPerfil, Principal principal) {
        this.iconPerfil = iconPerfil;
        this.principal = principal;

        setTitle("Nuevo Perfil");
        setBounds(100, 100, 450, 250);
        setResizable(false);
        setClosable(true);
        setIconifiable(false);
        setMaximizable(false);
        getContentPane().setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(10, 20, 80, 20);
        getContentPane().add(lblUsuario);

        comboboxUsuarios = new JComboBox<>(iconUsuario.verCiUsuarios().toArray()); //TRAER USUARIOS CON UNA FUNCION
        comboboxUsuarios.setBounds(100, 20, 250, 20);;
        getContentPane().add(comboboxUsuarios);

        JLabel lblTipoPerfil = new JLabel("Tipo Perfil:");
        lblTipoPerfil.setBounds(10, 55, 80, 20);
        getContentPane().add(lblTipoPerfil);

        comboboxTipoPerfil = new JComboBox<>(TiposPerfil.values());
        comboboxTipoPerfil.setBounds(100, 55, 250, 20);
        getContentPane().add(comboboxTipoPerfil);

        comboboxTipoPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Objects.equals(comboboxTipoPerfil.getSelectedItem().toString(), "CIUDADANO")){
                    DesactivarOpcionesFuncionarioActionPerformed();
                    ActivarOpcionesCiudadanoActionPerformed();
                }else {
                    DesactivarOpcionesCiudadanoActionPerformed();
                    ActivarOpcionesFuncionarioActionPerformed();
                }
            }
        });

        lblDireccion = new JLabel("Direccion:");
        lblDireccion.setBounds(10, 90, 80, 20);
        getContentPane().add(lblDireccion);
        lblDireccion.setVisible(false);

        textFieldDireccion = new JTextField();
        textFieldDireccion.setBounds(100, 90, 250, 20);
        getContentPane().add(textFieldDireccion);
        textFieldDireccion.setVisible(false);

        lblFechaNacimiento = new JLabel("Fecha nacimiento:");
        lblFechaNacimiento.setBounds(10, 125, 80, 20);
        getContentPane().add(lblFechaNacimiento);
        lblFechaNacimiento.setVisible(false);

        textFieldFechaNacimiento = new JTextField();
        textFieldFechaNacimiento.setBounds(100, 125, 250, 20);
        getContentPane().add(textFieldFechaNacimiento);
        textFieldFechaNacimiento.setVisible(false);

        lblEstadoCivil = new JLabel("Estado civil:");
        lblEstadoCivil.setBounds(10, 160, 80, 20);
        getContentPane().add(lblEstadoCivil);
        lblEstadoCivil.setVisible(false);

        comboboxEstadoCivil = new JComboBox<>(EstadoCivil.values());
        comboboxEstadoCivil.setBounds(100, 160, 250, 20);
        getContentPane().add(comboboxEstadoCivil);
        comboboxEstadoCivil.setVisible(false);

        lblCargo = new JLabel("Cargo:");
        lblCargo.setBounds(10, 90, 80, 20);
        getContentPane().add(lblCargo);
        lblCargo.setVisible(false);

        comboboxCargoFuncionario = new JComboBox<>(Cargo.values());
        comboboxCargoFuncionario.setBounds(100, 90, 250, 20);
        getContentPane().add(comboboxCargoFuncionario);
        comboboxCargoFuncionario.setVisible(false);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                altaUsuarioAceptarActionPerformed(e);
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

    protected void altaUsuarioRefrescarActionPerformed(ActionEvent e, IControladorUsuario iconUsuario){
        comboboxUsuarios.removeAllItems();
        List<String> usuarios = iconUsuario.verCiUsuarios();

        for(String ci : usuarios){
            comboboxUsuarios.addItem(ci);
        }

    }
    protected void ActivarOpcionesCiudadanoActionPerformed(){
        lblDireccion.setVisible(true);
        textFieldDireccion.setVisible(true);
        lblFechaNacimiento.setVisible(true);
        textFieldFechaNacimiento.setVisible(true);
        lblEstadoCivil.setVisible(true);
        comboboxEstadoCivil.setVisible(true);

        btnAceptar.setBounds(90, 195, 89, 23);
        btnCancelar.setBounds(261, 195, 89, 23);
        btnAceptar.setEnabled(true);

        formularioPerfilActivo = TiposPerfil.CIUDADANO;
    }
    protected void DesactivarOpcionesCiudadanoActionPerformed(){
        lblDireccion.setVisible(false);
        textFieldDireccion.setVisible(false);
        lblFechaNacimiento.setVisible(false);
        textFieldFechaNacimiento.setVisible(false);
        lblEstadoCivil.setVisible(false);
        comboboxEstadoCivil.setVisible(false);
    }
    protected void ActivarOpcionesFuncionarioActionPerformed(){
        lblCargo.setVisible(true);
        comboboxCargoFuncionario.setVisible(true);
        btnAceptar.setBounds(90, 125, 89, 23);
        btnCancelar.setBounds(261, 125, 89, 23);
        btnAceptar.setEnabled(true);
        formularioPerfilActivo = TiposPerfil.FUNCIONARIO;
    }
    protected void DesactivarOpcionesFuncionarioActionPerformed(){
        lblCargo.setVisible(false);
        comboboxCargoFuncionario.setVisible(false);
    }

    protected void altaUsuarioAceptarActionPerformed(ActionEvent e) {

        Boolean salir = true;

        String ciUsuario;
        LocalDate fechaNacimiento;
        String direccion;
        EstadoCivil estadoCivil;

        Cargo cargo;

        if (checkFormulario()) {

            ciUsuario = comboboxUsuarios.getSelectedItem().toString();

            DtUsuario usuarioSelecc = new DtUsuario();
            usuarioSelecc.setCi(ciUsuario);

            if(formularioPerfilActivo == TiposPerfil.CIUDADANO && checkFormularioCiudadano()){
                //ARMAR PERFIL FUNCIONARIO

                DtPerfilCiudadano nuevoPerfilCiudadano = new DtPerfilCiudadano();

                try{
                    fechaNacimiento = LocalDate.parse(textFieldFechaNacimiento.getText());
                    direccion = textFieldDireccion.getText();
                    estadoCivil = (EstadoCivil) comboboxEstadoCivil.getSelectedItem();

                    nuevoPerfilCiudadano.setDireccion(direccion);
                    nuevoPerfilCiudadano.setFechaNacimiento(fechaNacimiento);
                    nuevoPerfilCiudadano.setEstadoCivil(estadoCivil);

                    iconPerfil.AltaPerfil(usuarioSelecc, nuevoPerfilCiudadano);

                }catch(DateTimeParseException dateTimeParseException){
                    JOptionPane.showMessageDialog(this, "No se reconoce el formato de la fecha, debe ser el siguiente: YYYY/MM/DD.", "Error", JOptionPane.ERROR_MESSAGE);
                    salir = false;
                }

            }else if(formularioPerfilActivo == TiposPerfil.FUNCIONARIO && checkFormularioFuncionario()){
                //ARMAR PERFIL CIUDADANO

                DtPerfilFuncionario nuevoPerfilFuncionario = new DtPerfilFuncionario();
                cargo = (Cargo) comboboxCargoFuncionario.getSelectedItem();
                nuevoPerfilFuncionario.setCargo(cargo);

                iconPerfil.AltaPerfil(usuarioSelecc, nuevoPerfilFuncionario);

            }

            JOptionPane.showMessageDialog(this, "Perfil " + comboboxTipoPerfil.getSelectedItem() + "ha sido creado exitosamente.", "AltaPerfil", JOptionPane.INFORMATION_MESSAGE);
            limpiarFormulario();
            setVisible(!salir);
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
        private boolean checkFormularioCiudadano() {
        if (textFieldDireccion.getText().isEmpty() || textFieldFechaNacimiento.getText().isEmpty() || comboboxEstadoCivil.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos.", "Alta Bibliotecario", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
        private boolean checkFormularioFuncionario() {
        if (comboboxCargoFuncionario.getSelectedIndex() == -1) {
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
