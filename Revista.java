public class Revista extends Producto {
    private int numPaginas;
    private int numeroEdicion;
    private String periodicidad;

    public Revista(int id, String titulo, String autor, int cantidadDisponible, double precio, boolean estado, double descuento, int numPaginas, int numeroEdicion, String periodicidad) {
        super(id, titulo, autor, cantidadDisponible, precio, estado, descuento);
        this.numPaginas = numPaginas;
        this.numeroEdicion = numeroEdicion;
        this.periodicidad = periodicidad;
    }

    // Getters y Setters
    public int getNumPaginas() {
        return numPaginas;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
            "Número de páginas: %d\nNúmero de edición: %d\nPeriodicidad: %s\n--------------------------------------",
            numPaginas, numeroEdicion, periodicidad
    );
}

}
