package dao;

import conexion.DatabaseCennection;
import modelo.Prestamos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrestamosDao {

    public void registrarPrestamo(Prestamos prestamo) throws SQLException {
        String sql = "INSERT INTO prestamos " +
                "(id_estudiante, id_libro, fecha_prestamo, fecha_devolucion, devuelto) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, prestamo.getId_estudiante());
            stmt.setInt(2, prestamo.getId_libro());
            stmt.setDate(3, prestamo.getFecha_prestamo());
            stmt.setDate(4, prestamo.getFecha_devolucion());
            stmt.setBoolean(5, prestamo.isDevuelto());

            stmt.executeUpdate();
        }
    }

    public void editarPrestamo(int id, Prestamos prestamo) throws SQLException {
        String sql = "UPDATE prestamos SET id_estudiante=?, id_libro=?, " +
                "fecha_prestamo=?, fecha_devolucion=?, devuelto=? WHERE id=?";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, prestamo.getId_estudiante());
            stmt.setInt(2, prestamo.getId_libro());
            stmt.setDate(3, prestamo.getFecha_prestamo());
            stmt.setDate(4, prestamo.getFecha_devolucion());
            stmt.setBoolean(5, prestamo.isDevuelto());
            stmt.setInt(6, id);

            stmt.executeUpdate();
        }
    }

    public void eliminarPrestamo(int id) throws SQLException {
        String sql = "DELETE FROM prestamos WHERE id=?";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Prestamos> listarPrestamos() throws SQLException {
        List<Prestamos> lista = new ArrayList<>();

        String sql = "SELECT id, id_estudiante, id_libro, " +
                "fecha_prestamo, fecha_devolucion, devuelto FROM prestamos";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Prestamos(
                        rs.getInt("id"),
                        rs.getInt("id_estudiante"),
                        rs.getInt("id_libro"),
                        rs.getDate("fecha_prestamo"),
                        rs.getDate("fecha_devolucion"),
                        rs.getBoolean("devuelto")
                ));
            }
        }

        return lista;
    }
}