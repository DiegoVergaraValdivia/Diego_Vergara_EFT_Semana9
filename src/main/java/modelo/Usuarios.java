package modelo;

public class Usuarios {

    private int id;
    private String nombre;
    private String rut;
    private String correo;
    private String contrasena;
    private String rol;

    public Usuarios(){

    }

    public Usuarios(String nombre, String rut, String correo, String contrasena, String rol){
        this.nombre = nombre;
        this.rut = rut;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public Usuarios(int id, String nombre, String rut, String correo, String contrasena, String rol){
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }


    // getters y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getRol(){
        return rol;
    }

    public void setRol(String rol){
        this.rol = rol;
    }

}
