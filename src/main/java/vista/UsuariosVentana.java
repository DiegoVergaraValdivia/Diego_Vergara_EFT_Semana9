package vista;

import controlador.UsuariosControlador;
import modelo.Usuarios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class UsuariosVentana {

    private JPanel panelPrincipal;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField4;
    private JPasswordField passwordField1;
    private JTextField textField2;
    private JButton agregarUsuarioButton;
    private JButton editarUsuarioButton;
    private JButton eliminarUsuarioButton;
    private JTable table1;

    private final UsuariosControlador controlador;
    private final DefaultTableModel modeloTabla;

    public UsuariosVentana() {

        controlador = new UsuariosControlador();

        modeloTabla = new DefaultTableModel(
                new Object[]{"ID", "Nombre", "RUT", "Correo", "Contraseña", "Rol"}, 0
        ) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        table1.setModel(modeloTabla);

        cargarUsuarios();

        agregarUsuarioButton.addActionListener(e -> agregarUsuario());
        editarUsuarioButton.addActionListener(e -> editarUsuario());
        eliminarUsuarioButton.addActionListener(e -> eliminarUsuario());

        table1.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                cargarSeleccion();
            }
        });
    }

    private Usuarios obtenerUsuario() {
        String nombre = textField1.getText().trim();
        String rut = textField2.getText().trim();
        String correo = textField3.getText().trim();
        String contrasena = new String(passwordField1.getPassword());
        String rol = textField4.getText().trim();

        return new Usuarios(nombre, rut, correo, contrasena, rol);
    }

    private boolean camposCompletos() {
        return !textField1.getText().trim().isEmpty()
                && !textField2.getText().trim().isEmpty()
                && !textField3.getText().trim().isEmpty()
                && passwordField1.getPassword().length > 0
                && !textField4.getText().trim().isEmpty();
    }

    private void agregarUsuario() {
        if (!camposCompletos()) {
            return;
        }

        try {
            controlador.registrarUsuario(obtenerUsuario());
            cargarUsuarios();
            limpiarCampos();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void editarUsuario() {
        int fila = table1.getSelectedRow();

        if (fila == -1 || !camposCompletos()) {
            return;
        }

        try {
            int filaModelo = table1.convertRowIndexToModel(fila);
            int id = (int) modeloTabla.getValueAt(filaModelo, 0);

            controlador.editarUsuario(id, obtenerUsuario());
            cargarUsuarios();
            limpiarCampos();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void eliminarUsuario() {
        int fila = table1.getSelectedRow();

        if (fila == -1) {
            return;
        }

        try {
            int filaModelo = table1.convertRowIndexToModel(fila);
            int id = (int) modeloTabla.getValueAt(filaModelo, 0);

            controlador.eliminarUsuario(id);
            cargarUsuarios();
            limpiarCampos();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarUsuarios() {
        try {
            modeloTabla.setRowCount(0);

            for (Usuarios usuario : controlador.listarUsuarios()) {
                modeloTabla.addRow(new Object[]{
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getRut(),
                        usuario.getCorreo(),
                        usuario.getContrasena(),
                        usuario.getRol()
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarSeleccion() {
        int fila = table1.getSelectedRow();

        if (fila == -1) {
            return;
        }

        int filaModelo = table1.convertRowIndexToModel(fila);

        textField1.setText(modeloTabla.getValueAt(filaModelo, 1).toString());
        textField2.setText(modeloTabla.getValueAt(filaModelo, 2).toString());
        textField3.setText(modeloTabla.getValueAt(filaModelo, 3).toString());
        passwordField1.setText(modeloTabla.getValueAt(filaModelo, 4).toString());
        textField4.setText(modeloTabla.getValueAt(filaModelo, 5).toString());
    }

    private void limpiarCampos() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        passwordField1.setText("");
        textField4.setText("");
        table1.clearSelection();
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}