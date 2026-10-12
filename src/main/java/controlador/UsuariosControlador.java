package controlador;

import dao.UsuariosDao;
import modelo.Usuarios;

import java.sql.SQLException;
import java.util.List;

public class UsuariosControlador {

    private final UsuariosDao dao;

    public UsuariosControlador() {
        dao = new UsuariosDao();
    }

    public void registrarUsuario(Usuarios usuario) throws SQLException {
        dao.registrarUsuario(usuario);
    }

    public void editarUsuario(int id, Usuarios usuario) throws SQLException {
        dao.editarUsuario(id, usuario);
    }

    public void eliminarUsuario(int id) throws SQLException {
        dao.eliminarUsuario(id);
    }

    public List<Usuarios> listarUsuarios() throws SQLException {
        return dao.listarUsuarios();
    }
}