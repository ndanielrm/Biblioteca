package servicios;
/**
 * Clase de servicio que maneja la lógica de la biblioteca.
 * 
 * Esta clase se encarga de:
 * - Almacenar una lista de libros.
 * - Agregar nuevos libros a la lista mediante la entrada del usuario.
 * - Listar todos los libros registrados en la biblioteca.
 * - Prestar libros y gestionar el stock.
 * - Listar los libros que han sido prestados.
 * - Editar la informacion de un libro existente.
 * -  
 */
import modelos.libro;   
import java.util.ArrayList;
import java.util.Scanner;
import exepciones.ElementoNoEncontradoException;

public class BibliotecaService {

    private ArrayList<libro> libros = new ArrayList<>();  //Lista para almacenar libros

    private ArrayList<libro> librosPrestados = new ArrayList<>(); //lista para guardar los libros prestados

    public void agregarLibro(Scanner sc) {
        int codigo;
        libro libroExistente;
        while (true){
            System.out.print("Codigo del libro: ");
            codigo = sc.nextInt();
            sc.nextLine();//Limpiamos el buffer

            //Verificamos que el código no esté repetido
            libroExistente = null;
            for (libro l : libros){
                if (l.getCodigo() == codigo){
                    libroExistente = l;
                    break;
                }
            }
            if (libroExistente != null){
                System.out.println("Ya existe un libro con este codigo: "+libroExistente.getTitulo());
                System.out.print("¿Deseas agregar más stock a este libro? (S/N): ");
                String opcion = sc.nextLine(); 
                if (opcion.equalsIgnoreCase("s")){
                    System.out.print("¿Cuantos libros quieres agregar?: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();
                    libroExistente.setStock(libroExistente.getStock()+cantidad);
                    System.out.println("Stock actualizado correctamente.\n");
                    return; //Salimos del método.
                }else{
                    System.out.println("Ingrese un codigo diferente.");
                    continue; //Volvemos al inicio del bucle y pedimos otro código.
                }
            }
            break; //Salimos del bucle.
        }

        String titulo;
        while (true) {
            System.out.print("Titulo del libro: ");
            titulo = sc.nextLine().trim(); //.trim() es para eliminar los espacios en blanco al inicio y al final.
            if (!titulo.isEmpty()) { //.isEmpty() verifica si la cadena está vacía
                titulo = titulo.toUpperCase(); //Convertimos el titulo a mayusculas
                break; //Salimos del bucle en caso que no esté vacío
            } else {
                System.out.println("El título no puede estar vacío. Prueba de nuevo.");
            }
        }

        String autor;
        while (true){
            System.out.print("Autor del libro: ");
            autor = sc.nextLine().trim();
            if (!autor.isEmpty()){
                autor = autor.toUpperCase(); //Hacemos lo mismo que en titulo
                break;
            }else{
                System.out.println("El autor no puede estar vacio. Trata de nuevo. ");
            }
        }

        int stock;
        while (true){
            System.out.print("Stock: ");
            stock = sc.nextInt();
            sc.nextLine();
            if (stock >= 0){
                break; //Salimos del bucle en caso que sea mayor o igual a 0
            }else{
                System.out.println("El stock no puede ser negativo. Prueba de nuevo.");
            }
        }

        libro libroNuevo = new libro(codigo, stock, titulo, autor); 
        libros.add(libroNuevo);

        System.out.println(" Libro agregado correctamente.\n");
    }

 
    //Metodo Listar Libros
    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println(" No hay libros registrados.\n");
            return;
        }

        System.out.println("\n===== LISTADO DE LIBROS ORDENADOS POR CÓDIGO =====");

        // Ordenamos la lista de libros por código usando lambda
        libros.sort((l1, l2) -> Integer.compare(l1.getCodigo(), l2.getCodigo()));

        // Mostramos los libros usando forEach con lambda
        libros.forEach(l -> System.out.println(l));

        System.out.println();
    }
    
    //MÉTODO PRESTAR LIBRO
    public void prestarLibro(Scanner sc) {

        System.out.print ("Código del libro a prestar: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < libros.size(); i++) {
            libro l = libros.get(i);

            if (l.getCodigo() == codigo) {

                if (l.getStock() > 0) {

                    // Reducimos el stock
                    l.setStock(l.getStock() - 1);

                    // Agregamos a lista de prestados
                    librosPrestados.add(l);

                    System.out.println("Libro prestado: " + l.getTitulo());

                    // Si stock llega a 0, removemos 
                    if (l.getStock() == 0) {
                        System.out.println("El stock llegó a 0, el libro será retirado del inventario.");
                        libros.remove(i); // 
                    }

                    return;
                } else {
                    System.out.println("No hay stock disponible.");
                    return;
                }
            }
        }
        System.out.println("No existe un libro con ese código.\n");
    }

    public void editarInfoLibro(Scanner sc) {
    System.out.print("Ingrese el código del libro a modificar: ");
    int codigo = sc.nextInt();
    sc.nextLine();

    libro libroEncontrado = null;
    for (libro l : libros) {
        if (l.getCodigo() == codigo) {
            libroEncontrado = l;
            break;
        }
    }

    try {
        if (libroEncontrado == null) {
            throw new ElementoNoEncontradoException("No se encontró un libro con el código: " + codigo);
        }

        System.out.println("Libro encontrado: " + libroEncontrado);

        // Pedir nuevos datos
        System.out.print("Nuevo título (dejar vacío para no modificar): ");
        String nuevoTitulo = sc.nextLine().trim();
        if (!nuevoTitulo.isEmpty()) {
            libroEncontrado.setTitulo(nuevoTitulo.toUpperCase());
        }

        System.out.print("Nuevo autor (dejar vacío para no modificar): ");
        String nuevoAutor = sc.nextLine().trim();
        if (!nuevoAutor.isEmpty()) {
            libroEncontrado.setAutor(nuevoAutor.toUpperCase());
        }

        System.out.print("Nuevo stock (-1 para no modificar): ");
        int nuevoStock = sc.nextInt();
        sc.nextLine();
        if (nuevoStock >= 0) {
            libroEncontrado.setStock(nuevoStock);
        }

        System.out.println("Información del libro actualizada correctamente.");

    } catch (ElementoNoEncontradoException e) {
        System.out.println("ERROR: " + e.getMessage());
    }
}


    //MÉTODO LISTAR LIBROS PRESTADOS
    public void listarPrestados() {

        if (librosPrestados.isEmpty()) {
            System.out.println("No hay libros prestados actualmente.\n");
            return;
        }

        System.out.println("\n===== LIBROS PRESTADOS =====");
        for (libro l : librosPrestados) {
            System.out.println(l);
        }
        System.out.println();
    }
}
