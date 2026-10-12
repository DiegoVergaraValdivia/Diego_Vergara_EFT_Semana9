package dao;

import conexion.DatabaseCennection;
import modelo.Categorias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriasDao {

    // Registrar categoría
    public void registrarCategoria(Categorias categoria) throws SQLException {

        String sql = "INSERT INTO categorias (nombre) VALUES (?)";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNombre());
            stmt.executeUpdate();
        }
    }

    // Editar categoría
    public void editarCategoria(int id, Categorias categoria) throws SQLException {

        String sql = "UPDATE categorias SET nombre=? WHERE id=?";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNombre());
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    // Eliminar categoría
    public void eliminarCategoria(int id) throws SQLException {

        String sql = "DELETE FROM categorias WHERE id=?";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Consultar todas las categorías
    public List<Categorias> listarCategorias() throws SQLException {

        List<Categorias> lista = new ArrayList<>();
        String sql = "SELECT id, nombre FROM categorias";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categorias categoria = new Categorias(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );

                lista.add(categoria);
            }
        }

        return lista;
    }
}