public class Libro extends Producto {
    private int numPaginas;
    private String genero;

    public Libro(int id, String titulo, String autor, int cantidadDisponible, double precio, boolean estado, double descuento, int numPaginas, String genero) {
        super(id, titulo, autor, cantidadDisponible, precio, estado, descuento);
        this.numPaginas = numPaginas;
        this.genero = genero;
    }

    // Getters y Setters
    public int getNumPaginas() {
        return numPaginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
                "Número de páginas: %d\nGénero: %s\n--------------------------------------",
                numPaginas, genero);
    }

}
