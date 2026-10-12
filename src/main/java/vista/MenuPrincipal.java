package vista;

import javax.swing.*;

public class MenuPrincipal {

    private JPanel panelPrincipal;
    private JButton categoriasButton;
    private JButton estudiantesButton;
    private JButton librosButton;
    private JButton prestamosButton;
    private JButton usuariosButton;

    public MenuPrincipal() {

        categoriasButton.addActionListener(e -> {
            abrirVentana(new CategoriasVentana().getPanelPrincipal(),
                    "Gestión de Categorías");
        });

        estudiantesButton.addActionListener(e -> {
            abrirVentana(new EstudiantesVentana().getPanelPrincipal(),
                    "Gestión de Estudiantes");
        });

        librosButton.addActionListener(e -> {
            abrirVentana(new LibrosVentana().getPanelPrincipal(),
                    "Gestión de Libros");
        });

        prestamosButton.addActionListener(e -> {
            abrirVentana(new PrestamosVentana().getPanelPrincipal(),
                    "Gestión de Préstamos");
        });

        usuariosButton.addActionListener(e -> {
            abrirVentana(new UsuariosVentana().getPanelPrincipal(),
                    "Gestión de Usuarios");
        });
    }

    private void abrirVentana(JPanel panel, String titulo) {
        JFrame ventana = new JFrame(titulo);

        ventana.setContentPane(panel);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}