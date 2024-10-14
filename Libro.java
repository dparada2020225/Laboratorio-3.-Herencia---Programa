/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
 * CC2008
 * AUTOR: Denil José Parada Cabrera 24761
 * FECHA: 14/10/2024 
 * DESCRIPCIÓN: Subclase de Producto que representa un libro en la tienda. Además de los atributos de Producto, 
 * añade el número de páginas y el género literario. 
 */
public class Libro extends Producto {
    private int numPaginas; // Cantidad de páginas del libro
    private String genero;  // Género literario del libro (e.g., ficción, ciencia ficción)

    // Constructor que incluye los atributos específicos del libro
    public Libro(int id, String titulo, String autor, int cantidadDisponible, double precio, boolean estado, double descuento, int numPaginas, String genero) {
        super(id, titulo, autor, cantidadDisponible, precio, estado, descuento); // Llama al constructor de Producto
        this.numPaginas = numPaginas;
        this.genero = genero;
    }

    // Sobrescribe el método toString para añadir los atributos específicos del libro
    @Override
    public String toString() {
        return super.toString() + String.format(
                "Número de páginas: %d\nGénero: %s\n--------------------------------------",
                numPaginas, genero);
    }

}
