package presentacion;

import datatypes.Cargo;
import datatypes.DtPerfilFuncionario;
import datatypes.DtTramite;
import datatypes.DtUsuario;
import excepciones.FuncionarioYaAsignado;
import interfaces.IControladorAsignarTramite;
import interfaces.IControladorPerfil;
import interfaces.IControladorTramite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesasignarTramiteInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    private Principal principal;
    private IControladorAsignarTramite iconAsignarTramite;
    private IControladorTramite iconTramite;
    private IControladorPerfil iconPerfil;
    private JComboBox comboboxFuncJefes;
    private JComboBox comboboxFuncInspectores;
    private JComboBox comboboxTramites;

    public DesasignarTramiteInternalFrame(IControladorTramite iconTramite, IControladorPerfil iconPerfil,
                                          IControladorAsignarTramite iconAsignarTramite, Principal principal) {
        this.iconTramite = iconTramite;
        this.iconPerfil = iconPerfil;
        this.iconAsignarTramite = iconAsignarTramite;
        this.principal = principal;

        setTitle("Desasignar Tramite");
        setBounds(100, 100, 450, 250);
        setResizable(false);
        setClosable(true);
        setIconifiable(false);
        setMaximizable(false);
        getContentPane().setLayout(null);

        JLabel lblFuncJefes = new JLabel("Func jefes:");
        lblFuncJefes.setBounds(10, 20, 80, 20);
        getContentPane().add(lblFuncJefes);

        comboboxFuncJefes = new JComboBox<>();
        comboboxFuncJefes.setBounds(100, 20, 250, 20);
        getContentPane().add(comboboxFuncJefes);


        JLabel lblTramites = new JLabel("Tramites:");
        lblTramites.setBounds(10, 55, 80, 20);
        getContentPane().add(lblTramites);

        comboboxTramites = new JComboBox<>();
        comboboxTramites.setBounds(100, 55, 250, 20);
        getContentPane().add(comboboxTramites);
        comboboxTramites.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboboxFuncInspectores.removeAllItems();
                comboboxFuncInspectores.setSelectedItem(-1);
                cargarComboboxFuncionariosAsignados();
            }
        });

        JLabel lblFuncInspectores = new JLabel("Inspectores:");
        lblFuncInspectores.setBounds(10, 80, 80, 20);
        getContentPane().add(lblFuncInspectores);

        comboboxFuncInspectores = new JComboBox<>();
        comboboxFuncInspectores.setBounds(100, 80, 250, 20);
        getContentPane().add(comboboxFuncInspectores);


        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aceptarActionPerformed(e);
            }
        });
        btnAceptar.setBounds(90, 180, 89, 23);
        getContentPane().add(btnAceptar);

        JButton btnRefrescar = new JButton("Refrescar");
        btnRefrescar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refrescarActionPerformed(e);
            }
        });
        btnRefrescar.setBounds(150, 180, 80, 23);
        getContentPane().add(btnRefrescar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelarActionPerformed(e);
            }
        });
        btnCancelar.setBounds(261, 180, 89, 23);
        getContentPane().add(btnCancelar);

        cargarComboboxTramite();
        cargarComboboxesFuncionariosJefes();
    }

    protected void aceptarActionPerformed(ActionEvent e) {

        int idFuncJefe;
        int idFuncAsignado;
        int idTramite;

        if (checkFormulario()) {
            String[] partes = comboboxFuncJefes.getSelectedItem().toString().split(" "); //parsear
            idFuncJefe = Integer.parseInt(partes[0]);

            idTramite = (int) comboboxTramites.getSelectedItem();

            partes = comboboxFuncInspectores.getSelectedItem().toString().split(" "); //parsear
            idFuncAsignado = Integer.parseInt(partes[0]);

            iconAsignarTramite.desasignarTramite(new DtPerfilFuncionario(idFuncJefe, null, null),
                    new DtTramite(idTramite, null, null, null, null, null),
                    new DtPerfilFuncionario(idFuncAsignado, null, null));
            JOptionPane.showMessageDialog(this, "El funcionario fue desasignado correctamente.", "Asignar Tramite", JOptionPane.INFORMATION_MESSAGE);

            limpiarFormulario();
            setVisible(false);
        }
    }
    protected void cancelarActionPerformed(ActionEvent e) {
        limpiarFormulario();
        setVisible(false);
    }
    protected void refrescarActionPerformed(ActionEvent e){
        limpiarFormulario();
        vaciarComboboxes();
        cargarComboboxTramite();
    }
    protected void cargarComboboxFuncionariosAsignados() {

        DtTramite tramiteSeleccionado = new DtTramite();
        tramiteSeleccionado.setId((int) comboboxTramites.getSelectedItem());


        for (Object[] o : iconAsignarTramite.funcionariosAsignadosTramiteInfoUsuario(tramiteSeleccionado)) {
            DtPerfilFuncionario pf = (DtPerfilFuncionario) o[0];
            DtUsuario u = (DtUsuario) o[1];
            String linea = String.valueOf(pf.getId()) + " - " + u.getNombre() + " " + u.getApellido();

            comboboxFuncInspectores.addItem(linea);
        }
    }
    protected void cargarComboboxesFuncionariosJefes() {

        for (Object[] o : iconPerfil.verPerfilesFuncionarioInfoUsuario()) {
            DtPerfilFuncionario pf = (DtPerfilFuncionario) o[0];
            DtUsuario u = (DtUsuario) o[1];
            String linea = String.valueOf(pf.getId()) + " - " + u.getNombre() + " " + u.getApellido();
            if(pf.getCargo() == Cargo.JEFE){
                comboboxFuncJefes.addItem(linea);
            }
        }
    }

    protected void cargarComboboxTramite() {
        for (DtTramite t : iconTramite.verTramites()) {
            comboboxTramites.addItem(t.getId());
        }
    }

    private boolean checkFormulario() {
        if (comboboxTramites.getSelectedIndex() == -1 | comboboxFuncJefes.getSelectedIndex() == -1 |
                comboboxFuncInspectores.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos.", "Alta Bibliotecario", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    protected void vaciarComboboxes(){
        comboboxTramites.removeAllItems();
        comboboxFuncInspectores.removeAllItems();
        comboboxFuncJefes.removeAllItems();
    }

    private void limpiarFormulario() {
        comboboxFuncJefes.setSelectedIndex(-1);
        comboboxTramites.setSelectedIndex(-1);
        comboboxFuncInspectores.setSelectedIndex(-1);
    }
}
