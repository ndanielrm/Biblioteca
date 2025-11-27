package modelos;

/**
 * Clase padre para aplicar herencia.
 * Representa un material general dentro de la biblioteca.
 * Los atributos y métodos comunes estarán aquí,
 * y serán heredados por "libro" u otros materiales futuros.
 */

public abstract class MaterialBiblioteca {

    //Atributos comunes que los hijos van a heredar
    protected int codigo;
    protected String titulo;

    //Constructor usado por las clases hijas
    public MaterialBiblioteca(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    //Métodos comunes
    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }
    //El toString lo dejamos abstracto para que cada hijo lo implemente a su manera
    public abstract String toString();
}

