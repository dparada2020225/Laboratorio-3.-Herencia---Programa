/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
 * CC2008
 * AUTOR: Denil José Parada Cabrera 24761
 * FECHA: 14/10/2024 
 * DESCRIPCIÓN: Clase que representa un producto genérico en la tienda. Contiene atributos como ID, título, autor, 
 * cantidad disponible, precio, descuento y estado del producto. Es la superclase para otros tipos de productos como 
 * libros, revistas y cómics. También incluye métodos para calcular el precio final (aplicando un descuento) y para 
 * mostrar la información del producto.
 */
public class Producto {
    protected int id;
    protected String titulo;
    protected String autor;
    protected int cantidadDisponible;
    protected int cantidadVendida;
    protected double precio;
    protected boolean estado;
    protected double descuento; // Porcentaje de descuento aplicado al precio del producto

    // Constructor que inicializa todos los atributos del producto, incluyendo el descuento
    public Producto(int id, String titulo, String autor, int cantidadDisponible, double precio, boolean estado, double descuento) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadVendida = 0;
        this.precio = precio;
        this.estado = estado;
        this.descuento = descuento;
    }

    // Métodos getter y setter para acceder y modificar los atributos
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getCantidadDisponible() { return cantidadDisponible; }
    public int getCantidadVendida() { return cantidadVendida; }
    public double getPrecio() { return precio; }
    public boolean getEstado() { return estado; }
    public double getDescuento() { return descuento; }

    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setCantidadDisponible(int cantidad) { this.cantidadDisponible = cantidad; }
    public void setCantidadVendida(int cantidad) { this.cantidadVendida = cantidad; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setEstado(boolean estado) { this.estado = estado; }
    public void setDescuento(double descuento) { this.descuento = descuento; }

    // Método que calcula el precio final del producto aplicando el descuento
    public double calcularPrecioFinal() {
        return precio * (1 - descuento / 100);
    }

    // Sobrescribe el método toString para mostrar la información del producto de manera formateada
    @Override
    public String toString() {
        return String.format(
            "--------------------------------------\n" +
            "ID: %d\nTítulo: %s\nAutor: %s\nCantidad disponible: %d\nCantidad vendida: %d\nPrecio: %.2f\nDescuento: %.2f%%\nEstado: %s\n",
            id, titulo, autor, cantidadDisponible, cantidadVendida, precio, descuento, estado ? "Disponible" : "No disponible"
        );
    }
}
