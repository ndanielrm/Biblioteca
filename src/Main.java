import servicios.BibliotecaService;
import java.util.Scanner;
/*Acá solamente tenemos el "Main", si queremos crear nuevas funciones, eliminar otras 
 * o modificar algo, debemos informar sobre los cambios por si otro está trabajando en lo mismo.
 */
public class Main {
 
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BibliotecaService servicio = new BibliotecaService();

        int opcion = 0;
        do {
            System.out.println("===== SISTEMA DE BIBLIOTECA =====");
            System.out.println("1. Agregar libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Prestar libro");
            System.out.println("4. Ver libros prestados");
            System.out.println("5. Editar información de un libro");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine()); // Validación para evitar errores al ingresar texto
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.\n");
                continue;
            }

            switch (opcion) {
                case 1 -> servicio.agregarLibro(sc);
                case 2 -> servicio.listarLibros();
                case 3 -> servicio.prestarLibro(sc); 
                case 4 -> servicio.listarPrestados();
                case 5 -> servicio.editarInfoLibro(sc);
                case 6 -> System.out.println("Saliendo... ");
                default -> System.out.println("Opción inválida\n");
            }

        } while (opcion != 6);
        
        sc.close();

    }
}
