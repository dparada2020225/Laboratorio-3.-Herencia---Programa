/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
 * CC2008
 * AUTOR: Denil José Parada Cabrera 24761
 * FECHA: 14/10/2024 
 * DESCRIPCIÓN: Clase que representa una venta en la tienda. Registra el producto vendido, la cantidad vendida y 
 * calcula el total de la venta aplicando el descuento del producto.
 */
public class Venta {
    private Producto producto;    // Producto vendido
    private int cantidadVendida;  // Cantidad de productos vendidos
    private double total;         // Total de la venta, aplicando el descuento

    // Constructor que inicializa los atributos de la venta
    public Venta(Producto producto, int cantidadVendida) {
        this.producto = producto;
        this.cantidadVendida = cantidadVendida;
        this.total = producto.calcularPrecioFinal() * cantidadVendida; // Calcula el total con descuento
    }

    // Sobrescribe el método toString para mostrar la información de la venta
    @Override
    public String toString() {
        return String.format(
                "--------------------------------------\nProducto vendido: %s\nCantidad vendida: %d\nTotal de la venta: %.2f\n--------------------------------------",
                producto.getTitulo(), cantidadVendida, total);
    }

}
