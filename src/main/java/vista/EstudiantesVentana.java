package vista;

import controlador.EstudiantesControlador;
import modelo.Estudiantes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class EstudiantesVentana {

    private JPanel panelPrincipal;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton agregarEstudianteButton;
    private JButton editarEstudianteButton;
    private JButton eliminarEstudianteButton;
    private JTable table1;

    private EstudiantesControlador controlador;
    private DefaultTableModel modelo;

    public EstudiantesVentana() {

        controlador = new EstudiantesControlador();

        modelo = new DefaultTableModel(
                new Object[]{"ID", "Nombre", "RUT", "Curso", "Correo"}, 0
        ) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        table1.setModel(modelo);

        cargarEstudiantes();

        agregarEstudianteButton.addActionListener(e -> agregarEstudiante());
        editarEstudianteButton.addActionListener(e -> editarEstudiante());
        eliminarEstudianteButton.addActionListener(e -> eliminarEstudiante());

        // Al seleccionar un estudiante, cargar sus datos en los campos.
        table1.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int fila = table1.getSelectedRow();

                if (fila != -1) {
                    textField1.setText(modelo.getValueAt(fila, 1).toString());
                    textField2.setText(modelo.getValueAt(fila, 2).toString());
                    textField3.setText(modelo.getValueAt(fila, 3).toString());
                    textField4.setText(modelo.getValueAt(fila, 4).toString());
                }
            }
        });
    }

    private void agregarEstudiante() {

        if (!camposCompletos()) {
            return;
        }

        Estudiantes estudiante = obtenerEstudiante();

        try {
            controlador.registrarEstudiante(estudiante);
            cargarEstudiantes();
            limpiarCampos();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void editarEstudiante() {

        int fila = table1.getSelectedRow();

        if (fila == -1 || !camposCompletos()) {
            return;
        }

        int id = (int) modelo.getValueAt(fila, 0);
        Estudiantes estudiante = obtenerEstudiante();

        try {
            controlador.editarEstudiante(id, estudiante);
            cargarEstudiantes();
            limpiarCampos();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void eliminarEstudiante() {

        int fila = table1.getSelectedRow();

        if (fila == -1) {
            return;
        }

        int id = (int) modelo.getValueAt(fila, 0);

        try {
            controlador.eliminarEstudiante(id);
            cargarEstudiantes();
            limpiarCampos();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarEstudiantes() {

        try {
            List<Estudiantes> estudiantes = controlador.listarEstudiantes();

            modelo.setRowCount(0);

            for (Estudiantes estudiante : estudiantes) {
                modelo.addRow(new Object[]{
                        estudiante.getId(),
                        estudiante.getNombre(),
                        estudiante.getRut(),
                        estudiante.getCurso(),
                        estudiante.getCorreo()
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Estudiantes obtenerEstudiante() {
        return new Estudiantes(
                textField1.getText().trim(),
                textField2.getText().trim(),
                textField3.getText().trim(),
                textField4.getText().trim()
        );
    }

    private boolean camposCompletos() {
        return !textField1.getText().trim().isEmpty() && !textField2.getText().trim().isEmpty() && !textField3.getText().trim().isEmpty() && !textField4.getText().trim().isEmpty();
    }

    private void limpiarCampos() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}