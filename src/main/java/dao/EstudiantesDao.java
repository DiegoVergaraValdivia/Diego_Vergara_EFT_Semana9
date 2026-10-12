package dao;

import conexion.DatabaseCennection;
import modelo.Estudiantes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudiantesDao {

    public void registrarEstudiante(Estudiantes estudiante) throws SQLException {
        String sql = "INSERT INTO estudiantes (nombre, rut, curso, correo) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, estudiante.getNombre());
            stmt.setString(2, estudiante.getRut());
            stmt.setString(3, estudiante.getCurso());
            stmt.setString(4, estudiante.getCorreo());

            stmt.executeUpdate();
        }
    }

    public void editarEstudiante(int id, Estudiantes estudiante) throws SQLException {
        String sql = "UPDATE estudiantes SET nombre=?, rut=?, curso=?, correo=? WHERE id=?";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, estudiante.getNombre());
            stmt.setString(2, estudiante.getRut());
            stmt.setString(3, estudiante.getCurso());
            stmt.setString(4, estudiante.getCorreo());
            stmt.setInt(5, id);

            stmt.executeUpdate();
        }
    }

    public void eliminarEstudiante(int id) throws SQLException {
        String sql = "DELETE FROM estudiantes WHERE id=?";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Estudiantes> listarEstudiantes() throws SQLException {
        List<Estudiantes> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, rut, curso, correo FROM estudiantes";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Estudiantes(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("rut"),
                        rs.getString("curso"),
                        rs.getString("correo")
                ));
            }
        }

        return lista;
    }
}