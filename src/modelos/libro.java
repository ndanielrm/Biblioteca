package modelos;
/**
 * Clase que representa un libro dentro del sistema de biblioteca.
 * Contiene información básica como código, título, autor y stock disponible.
 * 
 * Esta clase proporciona:
 * - Atributos para almacenar los datos del libro.
 * - Un constructor para inicializar dichos valores.
 * - Métodos getters y setters para acceder y modificar la información.
 * - Un método toString() para mostrar el libro en un formato legible.
 * 
 * Su propósito es servir como modelo principal para manejar los libros
 * registrados dentro del sistema.
 */
public class libro {
    
    //Atributos
    private int codigo, stock;
    private String titulo, autor;

    //Constructor
    public libro(int codigo, int stock, String titulo, String autor){
        this.codigo = codigo;
        this.stock = stock;
        this.titulo = titulo;
        this.autor = autor;
    }

    //Getters y Setters
    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    @Override
    public String toString(){//Metodo para mostrar la informacion del libro con todo lo implementado
        return "["+codigo+"]"+titulo+" - "+autor+" (Stock: "+stock+")";
    }
}
