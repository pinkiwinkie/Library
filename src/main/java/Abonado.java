import java.util.List;

public class Abonado {
    private String name;
    private String dni;
    private List<Libro> librosPrestados;

    public Abonado(String name, String dni, List<Libro> librosPrestados) {
        this.name = name;
        this.dni = dni;
        this.librosPrestados = librosPrestados;
    }
}
