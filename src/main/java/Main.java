
/*
public class Main {
    public static void main(String[] args){



    }
}*/
/*
import vista.CategoriasVentana;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Categorías");

            CategoriasVentana categoriasVentana = new CategoriasVentana();

            ventana.setContentPane(categoriasVentana.getPanelPrincipal());
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}
*/




/*
import vista.EstudiantesVentana;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame ventana = new JFrame("Gestión de Estudiantes");

            EstudiantesVentana estudiantesVentana = new EstudiantesVentana();

            ventana.setContentPane(estudiantesVentana.getPanelPrincipal());

            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);

        });
    }
}
*/




/*
import vista.LibrosVentana;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame ventana = new JFrame("Gestión de Libros");

            LibrosVentana librosVentana = new LibrosVentana();

            ventana.setContentPane(librosVentana.getPanelPrincipal());
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}
*/



/*
import vista.PrestamosVentana;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Gestión de Préstamos");

            PrestamosVentana prestamosVentana = new PrestamosVentana();

            ventana.setContentPane(prestamosVentana.getPanelPrincipal());
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}
*/




/*
import vista.UsuariosVentana;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Gestión de Usuarios");

            UsuariosVentana usuariosVentana = new UsuariosVentana();

            ventana.setContentPane(usuariosVentana.getPanelPrincipal());
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}

*/


import vista.MenuPrincipal;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Sistema de Biblioteca");

            MenuPrincipal menu = new MenuPrincipal();

            ventana.setContentPane(menu.getPanelPrincipal());
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}


/*
public class Main {
    public static void main(String[] args){

        try (Connection conn = DatabaseCennection.obtenerConexion()) {
            System.out.println("\u2705 Conexion exitosa.");
        } catch (SQLException e) {
            System.err.println("\u274c Error al conectar con la bases de datos: ");
            e.printStackTrace();
        }
    }
}
*/
