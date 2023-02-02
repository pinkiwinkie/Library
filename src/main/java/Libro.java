import java.util.List;

public class Libro extends Publicacion{

    private String autor;
    private String title;
    private int isbn;
    private int numEjemplares;
//    private List<Ejemplar> ejemplares;
    private LinkedList ejemplar = new LinkedList();

    public Libro(String editorial, int numPags, boolean color, String autor, String title, int isbn, int numEjemplares) {
        super(editorial, numPags, color);
        this.autor = autor;
        this.title = title;
        this.isbn = isbn;
        this.numEjemplares = numEjemplares;

    }
    @Override
    public String toString() {
        return "Libro{" +
                "autor='" + autor + '\'' +
                ", title='" + title + '\'' +
                ", isbn=" + isbn +
                ", numEjemplares=" + numEjemplares +
//                ", ejemplares=" + ejemplares +
                "} " + super.toString();
    }
}
