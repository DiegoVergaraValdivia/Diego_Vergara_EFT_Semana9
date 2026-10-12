package vista;

import controlador.CategoriasControlador;
import modelo.Categorias;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class CategoriasVentana {

    private JPanel panelPrincipal;
    private JTextField textField1;
    private JButton agregarCategoriaButton;
    private JButton editarCategoriaButton;
    private JButton eliminarCategoriaButton;
    private JTable tablaCategorias;

    private CategoriasControlador controlador;
    private DefaultTableModel modelo;

    public CategoriasVentana() {

        controlador = new CategoriasControlador();

        modelo = new DefaultTableModel(
                new Object[]{"ID", "Nombre"}, 0
        ) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        tablaCategorias.setModel(modelo);

        cargarCategorias();

        agregarCategoriaButton.addActionListener(e -> agregarCategoria());
        editarCategoriaButton.addActionListener(e -> editarCategoria());
        eliminarCategoriaButton.addActionListener(e -> eliminarCategoria());
    }

    private void agregarCategoria() {

        String nombre = textField1.getText().trim();

        if (nombre.isEmpty()) {
            return;
        }

        try {
            controlador.registrarCategoria(new Categorias(nombre));
            cargarCategorias();
            textField1.setText("");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void editarCategoria() {

        int fila = tablaCategorias.getSelectedRow();

        if (fila == -1) {
            return;
        }

        String nombre = textField1.getText().trim();

        if (nombre.isEmpty()) {
            return;
        }

        int id = (int) modelo.getValueAt(fila, 0);

        try {
            controlador.editarCategoria(id, new Categorias(nombre));
            cargarCategorias();
            textField1.setText("");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void eliminarCategoria() {

        int fila = tablaCategorias.getSelectedRow();

        if (fila == -1) {
            return;
        }

        int id = (int) modelo.getValueAt(fila, 0);

        try {
            controlador.eliminarCategoria(id);
            cargarCategorias();
            textField1.setText("");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarCategorias() {

        try {
            List<Categorias> categorias = controlador.listarCategorias();

            modelo.setRowCount(0);

            for (Categorias categoria : categorias) {
                modelo.addRow(new Object[]{
                        categoria.getId(),
                        categoria.getNombre()
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}