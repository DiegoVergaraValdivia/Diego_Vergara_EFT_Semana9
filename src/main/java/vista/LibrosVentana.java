package vista;

import controlador.LibrosControlador;
import modelo.Libros;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class LibrosVentana {

    private JPanel panelPrincipal;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JTable table1;
    private JButton agregarLibroButton;
    private JButton editarLibroButton;
    private JButton eliminarLibroButton;

    private LibrosControlador controlador;
    private DefaultTableModel modelo;

    public LibrosVentana() {

        controlador = new LibrosControlador();

        modelo = new DefaultTableModel(
                new Object[]{"ID", "Título", "Autor", "ISBN",
                        "Editorial", "Stock", "ID Categoría"}, 0
        ) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        table1.setModel(modelo);

        spinner2.setModel(new SpinnerNumberModel(1, 1, 5, 1));

        cargarLibros();

        agregarLibroButton.addActionListener(e -> agregarLibro());
        editarLibroButton.addActionListener(e -> editarLibro());
        eliminarLibroButton.addActionListener(e -> eliminarLibro());

        table1.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int fila = table1.getSelectedRow();

                if (fila != -1) {
                    textField1.setText(modelo.getValueAt(fila, 1).toString());
                    textField2.setText(modelo.getValueAt(fila, 2).toString());
                    textField3.setText(modelo.getValueAt(fila, 3).toString());
                    textField4.setText(modelo.getValueAt(fila, 4).toString());

                    spinner1.setValue(
                            ((Number) modelo.getValueAt(fila, 5)).intValue()
                    );
                    spinner2.setValue(
                            ((Number) modelo.getValueAt(fila, 6)).intValue()
                    );
                }
            }
        });
    }

    private void agregarLibro() {

        if (!camposCompletos()) {
            return;
        }

        Libros libro = obtenerLibro();

        try {
            controlador.registrarLibro(libro);
            cargarLibros();
            limpiarCampos();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void editarLibro() {

        int fila = table1.getSelectedRow();

        if (fila == -1 || !camposCompletos()) {
            return;
        }

        int id = ((Number) modelo.getValueAt(fila, 0)).intValue();
        Libros libro = obtenerLibro();

        try {
            controlador.editarLibro(id, libro);
            cargarLibros();
            limpiarCampos();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void eliminarLibro() {

        int fila = table1.getSelectedRow();

        if (fila == -1) {
            return;
        }

        int id = ((Number) modelo.getValueAt(fila, 0)).intValue();

        try {
            controlador.eliminarLibro(id);
            cargarLibros();
            limpiarCampos();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarLibros() {

        try {
            List<Libros> libros = controlador.listarLibros();

            modelo.setRowCount(0);

            for (Libros libro : libros) {
                modelo.addRow(new Object[]{
                        libro.getId(),
                        libro.getTitulo(),
                        libro.getAutor(),
                        libro.getIsbn(),
                        libro.getEditorial(),
                        libro.getStock(),
                        libro.getId_categoria()
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Libros obtenerLibro() {

        return new Libros(
                textField1.getText().trim(),
                textField2.getText().trim(),
                textField3.getText().trim(),
                textField4.getText().trim(),
                ((Number) spinner1.getValue()).intValue(),
                ((Number) spinner2.getValue()).intValue()
        );
    }

    private boolean camposCompletos() {

        return !textField1.getText().trim().isEmpty()
                && !textField2.getText().trim().isEmpty()
                && !textField3.getText().trim().isEmpty()
                && !textField4.getText().trim().isEmpty();
    }

    private void limpiarCampos() {

        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");

        spinner1.setValue(0);
        spinner2.setValue(1);
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}