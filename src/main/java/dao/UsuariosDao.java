package dao;

import conexion.DatabaseCennection;
import modelo.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDao {

    public void registrarUsuario(Usuarios usuario) throws SQLException {
        String sql = "INSERT INTO usuarios " +
                "(nombre, rut, correo, `contraseña`, rol) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getRut());
            stmt.setString(3, usuario.getCorreo());
            stmt.setString(4, usuario.getContrasena());
            stmt.setString(5, usuario.getRol());

            stmt.executeUpdate();
        }
    }

    public void editarUsuario(int id, Usuarios usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nombre=?, rut=?, correo=?, " +
                "`contraseña`=?, rol=? WHERE id=?";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getRut());
            stmt.setString(3, usuario.getCorreo());
            stmt.setString(4, usuario.getContrasena());
            stmt.setString(5, usuario.getRol());
            stmt.setInt(6, id);

            stmt.executeUpdate();
        }
    }

    public void eliminarUsuario(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id=?";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Usuarios> listarUsuarios() throws SQLException {
        List<Usuarios> lista = new ArrayList<>();

        String sql = "SELECT id, nombre, rut, correo, `contraseña`, rol FROM usuarios";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Usuarios(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("rut"),
                        rs.getString("correo"),
                        rs.getString("contraseña"),
                        rs.getString("rol")
                ));
            }
        }

        return lista;
    }
}