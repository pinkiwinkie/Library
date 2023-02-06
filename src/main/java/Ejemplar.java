import java.util.List;

public class Ejemplar {
    private int codigo;
    private String fechaPrestamo;
    private String fechaDevolucion;
//    private List<Abonado> abonados;


    public Ejemplar(int codigo, String fechaPrestamo, String fechaDevolucion) {
        this.codigo = codigo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }
}
