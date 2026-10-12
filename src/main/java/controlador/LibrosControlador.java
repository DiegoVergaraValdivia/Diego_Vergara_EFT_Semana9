package controlador;

import dao.LibrosDao;
import modelo.Libros;

import java.sql.SQLException;
import java.util.List;

public class LibrosControlador {

    private final LibrosDao dao;

    public LibrosControlador() {
        dao = new LibrosDao();
    }

    public void registrarLibro(Libros libro) throws SQLException {
        dao.registrarLibro(libro);
    }

    public void editarLibro(int id, Libros libro) throws SQLException {
        dao.editarLibro(id, libro);
    }

    public void eliminarLibro(int id) throws SQLException {
        dao.eliminarLibro(id);
    }

    public List<Libros> listarLibros() throws SQLException {
        return dao.listarLibros();
    }
}