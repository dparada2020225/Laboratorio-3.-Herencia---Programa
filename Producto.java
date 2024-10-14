public class Producto {
    protected int id;
    protected String titulo;
    protected String autor;
    protected int cantidadDisponible;
    protected int cantidadVendida;
    protected double precio;
    protected boolean estado;
    protected double descuento; // Nuevo atributo

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

    // Getters y Setters
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

    // Métodos
    public double calcularPrecioFinal() {
        // Aplica el descuento
        return precio * (1 - descuento / 100);  // Precio final con descuento
    }

    @Override
    public String toString() {
        return String.format(
            "--------------------------------------\n" +
            "ID: %d\nTítulo: %s\nAutor: %s\nCantidad disponible: %d\nCantidad vendida: %d\nPrecio: %.2f\nDescuento: %.2f%%\nEstado: %s\n",
            id, titulo, autor, cantidadDisponible, cantidadVendida, precio, descuento, estado ? "Disponible" : "No disponible"
        );
    }
}
