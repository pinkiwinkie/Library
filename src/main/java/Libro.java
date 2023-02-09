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

    public GenericLinkedList<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public GenericLinkedList<Ejemplar> addEjemplar(int num) {
        for (int i = 0; i <num; i++) {
            ejemplares.addTail(new Ejemplar(ejemplares.size()+1));
        }
        return ejemplares;
    }
    @Override
    public String toString() {
        String output  = "";
        output += "El titulo es " + title +
                ", el autor es " + autor +
                ", el isbn = " + isbn;
        if (ejemplares.isEmpty())
            output += ". Y no tiene ejemplares.";
        else
            output += ". Tiene los siguientes ejemplares: " + ejemplares;
        return output;
//        return "Libro: " +
//                "autor= " + autor +
//                ", title= " + title +
//                ", isbn=" + isbn +
//                ", numEjemplares=" + numEjemplares +
//                ", ejemplares=" + ejemplares;
///                + super.toString();
    }
}
