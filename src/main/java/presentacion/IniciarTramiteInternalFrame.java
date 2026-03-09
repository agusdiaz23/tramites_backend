package presentacion;

import datatypes.DtPerfilCiudadano;
import datatypes.DtTramite;
import datatypes.DtUsuario;
import datatypes.TipoTramite;
import excepciones.YaExisteUsuarioExcepcion;
import interfaces.IControladorPerfil;
import interfaces.IControladorTramite;
import interfaces.IControladorUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IniciarTramiteInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    private Principal principal;
    private IControladorTramite iconTramite;
    private IControladorPerfil iconPerfil;
    private JComboBox comboboxPerfilesC;
    private JComboBox comboboxTipoTramite;

    public IniciarTramiteInternalFrame(IControladorTramite iconTramite, IControladorPerfil iconPerfil,
                                       Principal principal) {
        this.iconTramite = iconTramite;
        this.iconPerfil = iconPerfil;
        this.principal = principal;


        setTitle("Iniciar Tramite");
        setBounds(100, 100, 450, 250);
        setResizable(false);
        setClosable(true);
        setIconifiable(false);
        setMaximizable(false);
        getContentPane().setLayout(null);

        JLabel lblPerfilC = new JLabel("Perfil Ciudadano:");
        lblPerfilC.setBounds(10, 20, 80, 20);
        getContentPane().add(lblPerfilC);

        comboboxPerfilesC = new JComboBox<>();
        comboboxPerfilesC.setBounds(100, 20, 250, 20);
        getContentPane().add(comboboxPerfilesC);

        cargarComboboxPerfiles();

        JLabel lblTipoTramite = new JLabel("Tipo Tramite:");
        lblTipoTramite.setBounds(10, 55, 80, 20);
        getContentPane().add(lblTipoTramite);

        comboboxTipoTramite = new JComboBox<>(Arrays.stream(TipoTramite.values()).toArray());
        comboboxTipoTramite.setBounds(100, 55, 250, 20);
        getContentPane().add(comboboxTipoTramite);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aceptarActionPerformed(e);
            }
        });
        btnAceptar.setBounds(90, 180, 89, 23);
        getContentPane().add(btnAceptar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelarActionPerformed(e);
            }
        });
        btnCancelar.setBounds(261, 180, 89, 23);
        getContentPane().add(btnCancelar);
    }

    protected void aceptarActionPerformed(ActionEvent e) {
        int idPerfil = (int) comboboxPerfilesC.getSelectedItem();
        TipoTramite tipoTramite = (TipoTramite) comboboxTipoTramite.getSelectedItem();

        DtTramite nuevoTramite = new DtTramite(tipoTramite);

        if (checkFormulario()) {
            iconTramite.nuevoTramite(idPerfil, nuevoTramite);

            limpiarFormulario();
            setVisible(false);
        }
    }
    protected void cancelarActionPerformed(ActionEvent e) {
        limpiarFormulario();
        setVisible(false);
    }
    protected void cargarComboboxPerfiles() {
        for (DtPerfilCiudadano c : iconPerfil.verPerfilesCiudadano()) {
            comboboxPerfilesC.addItem(c.getId());
        }
    }

    private boolean checkFormulario() {
        if (comboboxTipoTramite.getSelectedIndex() == -1 | comboboxPerfilesC.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos.", "Alta Bibliotecario", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void limpiarFormulario() {
        comboboxPerfilesC.setSelectedIndex(-1);
        comboboxTipoTramite.setSelectedIndex(-1);
    }
}
