import java.util.List;
import java.util.Scanner;

public class Interfaz {
    private static Gestionador gestionador = new Gestionador();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("--------------------------------------");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Buscar Producto por ID");
            System.out.println("3. Mostrar Inventario por Categoría");
            System.out.println("4. Realizar Venta");
            System.out.println("5. Mostrar Ventas Totales");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            System.out.println("--------------------------------------");

            switch (opcion) {
                case 1:
                    agregarProducto(scanner);
                    break;
                case 2:
                    buscarProducto(scanner);
                    break;
                case 3:
                    mostrarPorCategoria(scanner);
                    break;
                case 4:
                    realizarVenta(scanner);
                    break;
                case 5:
                    mostrarVentasTotales();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 6);
    }

    private static void agregarProducto(Scanner scanner) {
        System.out.print("Ingrese el tipo de producto (Libro, Revista, Comic): ");
        String tipo = scanner.nextLine(); // Captura la línea completa

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
            String periodicidad = scanner.nextLine(); // Captura toda la periodicidad
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

    private static void realizarVenta(Scanner scanner) {
        System.out.print("Ingrese el ID del producto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese la cantidad a vender: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        gestionador.realizarVenta(id, cantidad);
    }

    private static void mostrarVentasTotales() {
        System.out.println("Ventas realizadas:");
        for (Venta venta : gestionador.getVentasRealizadas()) {
            System.out.println(venta);
        }
        System.out.println("Total de ventas: " + gestionador.getTotalVentas());
    }
}
