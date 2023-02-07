public class Prestamo {
    private String fechaInicio, fechaDevolucion;
    private Libro libro;//ponerlo en ejemplar
    private int codigoEjemplar;

    public Prestamo(String fechaInicio, String fechaDevolucion, Libro libro, int codigoEjemplar) {
        this.fechaInicio = fechaInicio;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.codigoEjemplar = codigoEjemplar;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public int getCodigoEjemplar() {
        return codigoEjemplar;
    }

    @Override
    public String toString() {
        return "Prestamo: " +
                "fechaInicio= " + fechaInicio +
                ", fechaDevolucion= " + fechaDevolucion +
                ", libro= " + libro +
                ", codigoEjemplar= " + codigoEjemplar;
    }
}
