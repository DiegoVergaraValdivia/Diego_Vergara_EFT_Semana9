package controlador;

import dao.CategoriasDao;
import modelo.Categorias;

import java.sql.SQLException;
import java.util.List;

public class CategoriasControlador {

    private final CategoriasDao dao;

    public CategoriasControlador() {
        dao = new CategoriasDao();
    }

    public void registrarCategoria(Categorias categoria) throws SQLException {
        dao.registrarCategoria(categoria);
    }

    public void editarCategoria(int id, Categorias categoria) throws SQLException {
        dao.editarCategoria(id, categoria);
    }

    public void eliminarCategoria(int id) throws SQLException {
        dao.eliminarCategoria(id);
    }

    public List<Categorias> listarCategorias() throws SQLException {
        return dao.listarCategorias();
    }
}