/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
 * CC2008
 * AUTOR: Denil José Parada Cabrera 24761
 * FECHA: 14/10/2024 
 * DESCRIPCIÓN: Subclase de Producto que representa una revista en la tienda. Añade el número de páginas, el número 
 * de edición y la periodicidad de la revista.
 */
public class Revista extends Producto {
    private int numPaginas;      // Número de páginas de la revista
    private int numeroEdicion;   // Número de edición de la revista
    private String periodicidad; // Frecuencia con la que se publica (e.g., semanal, mensual)

    // Constructor que incluye los atributos específicos de la revista
    public Revista(int id, String titulo, String autor, int cantidadDisponible, double precio, boolean estado, double descuento, int numPaginas, int numeroEdicion, String periodicidad) {
        super(id, titulo, autor, cantidadDisponible, precio, estado, descuento); // Llama al constructor de Producto
        this.numPaginas = numPaginas;
        this.numeroEdicion = numeroEdicion;
        this.periodicidad = periodicidad;
    }

    // Sobrescribe el método toString para mostrar los atributos de la revista
    @Override
    public String toString() {
        return super.toString() + String.format(
            "Número de páginas: %d\nNúmero de edición: %d\nPeriodicidad: %s\n--------------------------------------",
            numPaginas, numeroEdicion, periodicidad
    );
}

}
