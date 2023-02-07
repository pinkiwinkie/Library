import listas.GenericLinkedList;

public class Libro extends Publicacion{

    private String autor;
    private String title;
    private int isbn;
    private GenericLinkedList<Ejemplar> ejemplares = new GenericLinkedList<>();

    public Libro(String editorial, int numPags, boolean color, String autor, String title, int isbn) {
        super(editorial, numPags, color);
        this.autor = autor;
        this.title = title;
        this.isbn = isbn;
    }

    public void addEjemplar(Ejemplar ejemplar){
        ejemplares.addHead(ejemplar);
    }
    @Override
    public String toString() {
        return "Libro: " +
                "autor= " + autor +
                ", title= " + title +
                ", isbn=" + isbn +
//                ", numEjemplares=" + numEjemplares +
                ", ejemplares=" + ejemplares
                + super.toString();
    }
}
