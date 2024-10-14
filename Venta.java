public class Venta {
    private Producto producto;
    private int cantidadVendida;
    private double total;

    public Venta(Producto producto, int cantidadVendida) {
        this.producto = producto;
        this.cantidadVendida = cantidadVendida;
        this.total = producto.calcularPrecioFinal() * cantidadVendida;
    }

    public double calcularTotal() {
        return total;
    }

    @Override
    public String toString() {
        return String.format(
                "--------------------------------------\nProducto vendido: %s\nCantidad vendida: %d\nTotal de la venta: %.2f\n--------------------------------------",
                producto.getTitulo(), cantidadVendida, total);
    }

}
