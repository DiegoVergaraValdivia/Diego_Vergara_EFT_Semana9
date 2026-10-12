package modelo;

public class Libros {

    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private String editorial;
    private int stock;
    private int id_categoria;

    // Cosntructor vacio
    public Libros(){
    }

    // Constructor sin Id
    public Libros(String titulo, String autor, String isbn, String editorial,int stock, int id_categoria){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn =isbn;
        this.editorial = editorial;
        this.stock = stock;
        this.id_categoria = id_categoria;
    }

    // Constructor con Id
    public Libros(int id, String titulo, String autor, String isbn, String editorial,int stock, int id_categoria){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn =isbn;
        this.editorial = editorial;
        this.stock = stock;
        this.id_categoria = id_categoria;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
}
