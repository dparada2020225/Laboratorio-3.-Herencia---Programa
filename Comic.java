public class Comic extends Producto {
    private int numPaginas;
    private String ilustrador;
    private String editorial;

    public Comic(int id, String titulo, String autor, int cantidadDisponible, double precio, boolean estado, double descuento, int numPaginas, String ilustrador, String editorial) {
        super(id, titulo, autor, cantidadDisponible, precio, estado, descuento);
        this.numPaginas = numPaginas;
        this.ilustrador = ilustrador;
        this.editorial = editorial;
    }

    // Getters y Setters
    public int getNumPaginas() {
        return numPaginas;
    }

    public String getIlustrador() {
        return ilustrador;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public void setIlustrador(String ilustrador) {
        this.ilustrador = ilustrador;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
                "Número de páginas: %d\nIlustrador: %s\nEditorial: %s\n--------------------------------------",
                numPaginas, ilustrador, editorial);
    }

}
