package exepciones;

/**
 * Excepción personalizada que indica que un elemento no fue encontrado en la colección.
 */
public class ElementoNoEncontradoException extends Exception {

    public ElementoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}

