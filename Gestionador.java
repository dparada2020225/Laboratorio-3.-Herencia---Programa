import java.util.ArrayList;
import java.util.List;

public class Gestionador {
    private List<Producto> productos;
    private List<Venta> ventasRealizadas;
    private double totalVentas;

    public Gestionador() {
        productos = new ArrayList<>();
        ventasRealizadas = new ArrayList<>();
        totalVentas = 0;
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public Producto buscarPorID(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public List<Producto> obtenerPorCategoria(String categoria) {
        List<Producto> productosCategoria = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getClass().getSimpleName().equalsIgnoreCase(categoria)) {
                productosCategoria.add(p);
            }
        }
        return productosCategoria;
    }

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

    public List<Venta> getVentasRealizadas() {
        return ventasRealizadas;
    }

    public double getTotalVentas() {
        return totalVentas;
    }
}
