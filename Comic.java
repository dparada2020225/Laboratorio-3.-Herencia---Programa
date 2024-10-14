/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
 * CC2008
 * AUTOR: Denil José Parada Cabrera 24761
 * FECHA: 14/10/2024 
 * DESCRIPCIÓN: Subclase de Producto que representa un cómic en la tienda. Añade el número de páginas, el nombre 
 * del ilustrador y la editorial del cómic.
 */
public class Comic extends Producto {
    private int numPaginas;    // Cantidad de páginas del cómic
    private String ilustrador; // Nombre del ilustrador del cómic
    private String editorial;  // Editorial que publica el cómic

    // Constructor que incluye los atributos específicos del cómic
    public Comic(int id, String titulo, String autor, int cantidadDisponible, double precio, boolean estado, double descuento, int numPaginas, String ilustrador, String editorial) {
        super(id, titulo, autor, cantidadDisponible, precio, estado, descuento); // Llama al constructor de Producto
        this.numPaginas = numPaginas;
        this.ilustrador = ilustrador;
        this.editorial = editorial;
    }

    // Sobrescribe el método toString para mostrar los atributos del cómic
    @Override
    public String toString() {
        return super.toString() + String.format(
                "Número de páginas: %d\nIlustrador: %s\nEditorial: %s\n--------------------------------------",
                numPaginas, ilustrador, editorial);
    }

}
