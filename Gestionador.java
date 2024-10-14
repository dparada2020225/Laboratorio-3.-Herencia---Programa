/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
 * CC2008
 * AUTOR: Denil José Parada Cabrera 24761
 * FECHA: 14/10/2024 
 * DESCRIPCIÓN: Clase que actúa como gestionador del sistema. Maneja una lista de productos y ventas, y realiza 
 * operaciones como agregar productos, buscar por ID, mostrar productos por categoría y registrar ventas.
 */
import java.util.ArrayList;
import java.util.List;

public class Gestionador {
    private List<Producto> productos;        // Lista de productos en la tienda
    private List<Venta> ventasRealizadas;    // Lista de ventas realizadas
    private double totalVentas;              // Total acumulado de las ventas

    // Constructor que inicializa las listas y el total de ventas
    public Gestionador() {
        productos = new ArrayList<>();
        ventasRealizadas = new ArrayList<>();
        totalVentas = 0;
    }

    // Método para agregar un producto a la lista de productos
    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    // Método para buscar un producto en la lista por su ID
    public Producto buscarPorID(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null; // Si no se encuentra, devuelve null
    }

    // Método para obtener una lista de productos de una categoría específica
    public List<Producto> obtenerPorCategoria(String categoria) {
        List<Producto> productosCategoria = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getClass().getSimpleName().equalsIgnoreCase(categoria)) {
                productosCategoria.add(p);
            }
        }
        return productosCategoria;
    }

    // Método para registrar una venta y actualizar el inventario
    public void realizarVenta(int id, int cantidad) {
        Producto producto = buscarPorID(id);
        if (producto != null && producto.getCantidadDisponible() >= cantidad) {
            producto.setCantidadDisponible(producto.getCantidadDisponible() - cantidad);
            producto.setCantidadVendida(producto.getCantidadVendida() + cantidad);
            double total = producto.calcularPrecioFinal() * cantidad;
            ventasRealizadas.add(new Venta(producto, cantidad));
            totalVentas += total;
        }
    }

    // Obtener la lista de ventas realizadas
    public List<Venta> getVentasRealizadas() {
        return ventasRealizadas;
    }

    // Obtener el total de ventas acumuladas
    public double getTotalVentas() {
        return totalVentas;
    }
}
