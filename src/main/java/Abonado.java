import listas.GenericLinkedList;

public class Abonado {
    private String name;
    private String dni;
//    private List<Libro> librosPrestados;
    private GenericLinkedList<Prestamo> librosPrestados;

    public Abonado(String name, String dni, GenericLinkedList<Prestamo> librosPrestados) {
        this.name = name;
        this.dni = dni;
        this.librosPrestados = librosPrestados;
    }

    @Override
    public String toString() {
        return "Abonado: " +
                "name= " + name +
                ", dni= " + dni ;
//                ", librosPrestados=" + librosPrestados;
    }
}
