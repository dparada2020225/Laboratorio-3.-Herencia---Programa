/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
 * CC2008
 * AUTOR: Denil José Parada Cabrera 24761
 * FECHA: 14/10/2024 
 * DESCRIPCIÓN: Clase que representa la interfaz principal del sistema. Permite al usuario interactuar con el sistema 
 * para agregar productos, buscar productos por ID, mostrar inventarios por categoría, realizar ventas y mostrar ventas totales.
 */
import java.util.List;
import java.util.Scanner;

public class Interfaz {
    private static Gestionador gestionador = new Gestionador();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Bucle principal para mostrar el menú y permitir al usuario seleccionar opciones
        do {
            System.out.println("1. Agregar Producto");
            System.out.println("2. Buscar Producto por ID");
            System.out.println("3. Mostrar Inventario por Categoría");
            System.out.println("4. Realizar Venta");
            System.out.println("5. Mostrar Ventas Totales");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarProducto(scanner); // Agregar un producto
                    break;
                case 2:
                    buscarProducto(scanner); // Buscar producto por ID
                    break;
                case 3:
                    mostrarPorCategoria(scanner); // Mostrar productos por categoría
                    break;
                case 4:
                    realizarVenta(scanner); // Registrar una venta
                    break;
                case 5:
                    mostrarVentasTotales(); // Mostrar las ventas totales
                    break;
                case 6:
                    System.out.println("Saliendo..."); // Salir del programa
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 6); // El menú sigue hasta que el usuario selecciona la opción de salir
    }

    // Método para agregar un nuevo producto
    private static void agregarProducto(Scanner scanner) {
        System.out.print("Ingrese el tipo de producto (Libro, Revista, Comic): ");
        String tipo = scanner.nextLine(); // Captura el tipo de producto

        // Captura los detalles comunes de un producto
        System.out.print("Ingrese el ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el título: ");
        String titulo = scanner.nextLine(); // Captura todo el título

        System.out.print("Ingrese el autor: ");
        String autor = scanner.nextLine(); // Captura todo el autor

        System.out.print("Ingrese la cantidad disponible: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el descuento (porcentaje): ");
        double descuento = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        boolean estado = true;

        // Según el tipo de producto, captura los detalles específicos y lo agrega
        if (tipo.equalsIgnoreCase("Libro")) {
            System.out.print("Ingrese el número de páginas: ");
            int numPaginas = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("Ingrese el género: ");
            String genero = scanner.nextLine(); // Captura todo el género
            gestionador.agregarProducto(new Libro(id, titulo, autor, cantidad, precio, estado, descuento, numPaginas, genero));
        } else if (tipo.equalsIgnoreCase("Revista")) {
            System.out.print("Ingrese el número de páginas: ");
            int numPaginas = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("Ingrese el número de edición: ");
            int edicion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("Ingrese la periodicidad: ");
            String periodicidad = scanner.nextLine();
            gestionador.agregarProducto(new Revista(id, titulo, autor, cantidad, precio, estado, descuento, numPaginas, edicion, periodicidad));
        } else if (tipo.equalsIgnoreCase("Comic")) {
            System.out.print("Ingrese el número de páginas: ");
            int numPaginas = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("Ingrese el ilustrador: ");
            String ilustrador = scanner.nextLine(); // Captura todo el ilustrador

            System.out.print("Ingrese la editorial: ");
            String editorial = scanner.nextLine(); // Captura toda la editorial
            gestionador.agregarProducto(new Comic(id, titulo, autor, cantidad, precio, estado, descuento, numPaginas, ilustrador, editorial));
        } else {
            System.out.println("Tipo de producto no válido.");
        }
    }

    // Método para buscar un producto por su ID y mostrarlo
    private static void buscarProducto(Scanner scanner) {
        System.out.print("Ingrese el ID del producto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Producto producto = gestionador.buscarPorID(id);
        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Método para mostrar los productos de una categoría específica
    private static void mostrarPorCategoria(Scanner scanner) {
        System.out.print("Ingrese la categoría (Libro, Revista, Comic): ");
        String categoria = scanner.nextLine(); // Captura toda la categoría
        List<Producto> productosCategoria = gestionador.obtenerPorCategoria(categoria);

        if (productosCategoria.isEmpty()) {
            System.out.println("No hay productos en la categoría " + categoria);
        } else {
            System.out.println("Productos en la categoría " + categoria + ":");
            for (Producto p : productosCategoria) {
                System.out.println(p);
            }
        }
    }

    // Método para registrar una venta
    private static void realizarVenta(Scanner scanner) {
        System.out.print("Ingrese el ID del producto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese la cantidad a vender: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        gestionador.realizarVenta(id, cantidad);
    }

    // Método para mostrar el total de ventas realizadas
    private static void mostrarVentasTotales() {
        System.out.println("Ventas realizadas:");
        for (Venta venta : gestionador.getVentasRealizadas()) {
            System.out.println(venta);
        }
        System.out.println("Total de ventas: " + gestionador.getTotalVentas());
    }
}
