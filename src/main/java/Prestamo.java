public class Prestamo {
    private String fechaInicio, fechaDevolucion;
    private Libro libro;
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
        return "El prestamo se ha iniciado el " + fechaInicio +
                " y finaliza el " + fechaDevolucion +
                ". El ejemplar tiene el codigo " + codigoEjemplar +
                ". Y los datos del libro son los siguientes: \n" + libro;

//        return "Prestamo: " +
//                "fechaInicio= " + fechaInicio +
//                ", fechaDevolucion= " + fechaDevolucion +
//                ", libro= " + libro +
//                ", codigoEjemplar= " + codigoEjemplar;
    }
}
