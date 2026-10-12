package modelo;

public class Categorias {

    private int id;
    private String nombre;

    public Categorias(){
    }

    // constructor sin id
    public Categorias(String nombre){
        this.nombre = nombre;
    }

    // constructor con id
    public Categorias(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    // Gets y sets
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
