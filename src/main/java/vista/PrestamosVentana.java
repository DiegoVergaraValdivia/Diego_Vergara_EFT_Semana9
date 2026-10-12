package vista;

import controlador.PrestamosControlador;
import modelo.Prestamos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.sql.SQLException;

public class PrestamosVentana {

    private JPanel panelPrincipal;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JTextField textField1;
    private JCheckBox devueltoCheckBox;
    private JTextField textField2;
    private JButton agregarPrestamoButton;
    private JButton editarPrestamoButton;
    private JButton eliminarPrestamoButton;
    private JTable table1;

    private final PrestamosControlador controlador;
    private final DefaultTableModel modeloTabla;

    public PrestamosVentana() {

        controlador = new PrestamosControlador();

        spinner1.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
        spinner2.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));

        modeloTabla = new DefaultTableModel(
                new Object[]{
                        "ID", "ID Estudiante", "ID Libro",
                        "Fecha Préstamo", "Fecha Devolución", "Devuelto"
                }, 0
        ) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        table1.setModel(modeloTabla);

        cargarPrestamos();

        agregarPrestamoButton.addActionListener(e -> agregarPrestamo());
        editarPrestamoButton.addActionListener(e -> editarPrestamo());
        eliminarPrestamoButton.addActionListener(e -> eliminarPrestamo());

        table1.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                cargarSeleccion();
            }
        });
    }

    private Prestamos obtenerPrestamo() {
        int idEstudiante = (int) spinner1.getValue();
        int idLibro = (int) spinner2.getValue();

        Date fechaPrestamo = Date.valueOf(textField1.getText().trim());
        Date fechaDevolucion = Date.valueOf(textField2.getText().trim());

        boolean devuelto = devueltoCheckBox.isSelected();

        return new Prestamos(
                idEstudiante,
                idLibro,
                fechaPrestamo,
                fechaDevolucion,
                devuelto
        );
    }

    private void agregarPrestamo() {
        try {
            Prestamos prestamo = obtenerPrestamo();

            controlador.registrarPrestamo(prestamo);
            cargarPrestamos();
            limpiarCampos();

        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void editarPrestamo() {
        int fila = table1.getSelectedRow();

        if (fila == -1) {
            return;
        }

        try {
            int filaModelo = table1.convertRowIndexToModel(fila);
            int id = (int) modeloTabla.getValueAt(filaModelo, 0);

            Prestamos prestamo = obtenerPrestamo();

            controlador.editarPrestamo(id, prestamo);
            cargarPrestamos();
            limpiarCampos();

        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void eliminarPrestamo() {
        int fila = table1.getSelectedRow();

        if (fila == -1) {
            return;
        }

        try {
            int filaModelo = table1.convertRowIndexToModel(fila);
            int id = (int) modeloTabla.getValueAt(filaModelo, 0);

            controlador.eliminarPrestamo(id);
            cargarPrestamos();
            limpiarCampos();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarPrestamos() {
        try {
            modeloTabla.setRowCount(0);

            for (Prestamos p : controlador.listarPrestamos()) {
                modeloTabla.addRow(new Object[]{
                        p.getId(),
                        p.getId_estudiante(),
                        p.getId_libro(),
                        p.getFecha_prestamo(),
                        p.getFecha_devolucion(),
                        p.isDevuelto()
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

        spinner1.setValue(modeloTabla.getValueAt(filaModelo, 1));
        spinner2.setValue(modeloTabla.getValueAt(filaModelo, 2));
        textField1.setText(modeloTabla.getValueAt(filaModelo, 3).toString());
        textField2.setText(modeloTabla.getValueAt(filaModelo, 4).toString());
        devueltoCheckBox.setSelected(
                (boolean) modeloTabla.getValueAt(filaModelo, 5)
        );
    }

    private void limpiarCampos() {
        spinner1.setValue(1);
        spinner2.setValue(1);
        textField1.setText("");
        textField2.setText("");
        devueltoCheckBox.setSelected(false);
        table1.clearSelection();
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}