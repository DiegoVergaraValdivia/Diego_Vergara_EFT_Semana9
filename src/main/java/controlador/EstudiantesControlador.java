package controlador;

import dao.EstudiantesDao;
import modelo.Estudiantes;

import java.sql.SQLException;
import java.util.List;

public class EstudiantesControlador {

    private final EstudiantesDao dao;

    public EstudiantesControlador() {
        dao = new EstudiantesDao();
    }

    public void registrarEstudiante(Estudiantes estudiante) throws SQLException {
        dao.registrarEstudiante(estudiante);
    }

    public void editarEstudiante(int id, Estudiantes estudiante) throws SQLException {
        dao.editarEstudiante(id, estudiante);
    }

    public void eliminarEstudiante(int id) throws SQLException {
        dao.eliminarEstudiante(id);
    }

    public List<Estudiantes> listarEstudiantes() throws SQLException {
        return dao.listarEstudiantes();
    }
}