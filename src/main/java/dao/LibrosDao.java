
package dao;

import conexion.DatabaseCennection;
import modelo.Libros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibrosDao {

    public void registrarLibro(Libros libro) throws SQLException {

        String sql = "INSERT INTO libros " +
                "(titulo, autor, isbn, editorial, stock, id_categoria) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setString(3, libro.getIsbn());
            stmt.setString(4, libro.getEditorial());
            stmt.setInt(5, libro.getStock());
            stmt.setInt(6, libro.getId_categoria());

            stmt.executeUpdate();
        }
    }

    public void editarLibro(int id, Libros libro) throws SQLException {

        String sql = "UPDATE libros SET titulo=?, autor=?, isbn=?, " +
                "editorial=?, stock=?, id_categoria=? WHERE id=?";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setString(3, libro.getIsbn());
            stmt.setString(4, libro.getEditorial());
            stmt.setInt(5, libro.getStock());
            stmt.setInt(6, libro.getId_categoria());
            stmt.setInt(7, id);

            stmt.executeUpdate();
        }
    }

    public void eliminarLibro(int id) throws SQLException {

        String sql = "DELETE FROM libros WHERE id=?";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Libros> listarLibros() throws SQLException {

        List<Libros> lista = new ArrayList<>();

        String sql = "SELECT id, titulo, autor, isbn, editorial, " +
                "stock, id_categoria FROM libros";

        try (Connection conn = DatabaseCennection.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Libros(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("isbn"),
                        rs.getString("editorial"),
                        rs.getInt("stock"),
                        rs.getInt("id_categoria")
                ));
            }
        }

        return lista;
    }
}