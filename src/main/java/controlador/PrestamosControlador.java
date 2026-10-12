package controlador;

import dao.PrestamosDao;
import modelo.Prestamos;

import java.sql.SQLException;
import java.util.List;

public class PrestamosControlador {

    private final PrestamosDao dao;

    public PrestamosControlador() {
        dao = new PrestamosDao();
    }

    public void registrarPrestamo(Prestamos prestamo) throws SQLException {
        dao.registrarPrestamo(prestamo);
    }

    public void editarPrestamo(int id, Prestamos prestamo) throws SQLException {
        dao.editarPrestamo(id, prestamo);
    }

    public void eliminarPrestamo(int id) throws SQLException {
        dao.eliminarPrestamo(id);
    }

    public List<Prestamos> listarPrestamos() throws SQLException {
        return dao.listarPrestamos();
    }
}