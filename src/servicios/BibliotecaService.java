package servicios;
/**
 * Clase de servicio que maneja la lógica de la biblioteca.
 * 
 * Esta clase se encarga de:
 * - Almacenar una lista de libros.
 * - Agregar nuevos libros a la lista mediante la entrada del usuario.
 * - Listar todos los libros registrados en la biblioteca.
 * 
 * MEJORAS REALIZADAS:
 * - Ahora se verifica el codigo del libro para evitar que haya duplicados
 * - Si agregamos un codigo repetido, nos ofrece cambiar el codigo o aumentar el stock.
 * 
 * MEJORAS PENDIENTES:
 * - Implementar la funcion de eliminar libros o disminuir el stock.
 * 
 * COMENTARIOS:
 * - No se si entraria en lo de eliminar libros, pero me gustaria que si ponemos la opción de vender
 *  o prestar un libro, que disminuya el stock y si es 0, que lo elimine de la lista.
 */
import modelos.libro;   
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaService {

    private ArrayList<libro> libros = new ArrayList<>();  //Lista para almacenar libros

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

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println(" No hay libros registrados.\n");
            return;
        }

        System.out.println("\n===== LISTADO DE LIBROS =====");
        libros.forEach(System.out::println);
        System.out.println();
    }
}