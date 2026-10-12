package modelo;

import java.sql.Date;

public class Prestamos {

    private int id;
    private int id_estudiante;
    private int id_libro;
    private Date fecha_prestamo;
    private Date fecha_devolucion;
    private boolean devuelto;

    // Constructor vacio
    public Prestamos() {

    }

    // Constructor sin id
    public Prestamos(int id_estudiante, int id_libro, Date fecha_prestamo, Date fecha_devolucion, boolean devuelto) {
        this.id_estudiante = id_estudiante;
        this.id_libro = id_libro;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.devuelto = devuelto;
    }

    // Constructor con id
    public Prestamos(int id, int id_estudiante, int id_libro, Date fecha_prestamo, Date fecha_devolucion, boolean devuelto) {
        this.id = id;
        this.id_estudiante = id_estudiante;
        this.id_libro = id_libro;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.devuelto = devuelto;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

}