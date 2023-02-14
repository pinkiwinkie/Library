package model;

import listas.GenericLinkedList;
import tools.Input;

public class Libro extends Publicacion {
    private String autor, title;
    private int isbn;
    private GenericLinkedList<Ejemplar> ejemplares = new GenericLinkedList<>();

    public Libro(String editorial, int numPags, boolean color, String autor, String title, int isbn) {
        super(editorial, numPags, color);
        this.autor = autor;
        this.title = title;
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public GenericLinkedList<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public GenericLinkedList<Ejemplar> addEjemplar(int num) {
        for (int i = 0; i < num; i++) {
            ejemplares.addTail(new Ejemplar(ejemplares.size() + 1));
        }
        return ejemplares;
    }

    public void addPrestamo(Abonado a){
        if (ejemplares.isEmpty())
            System.out.println("El libro no tiene ejemplares disponibles");
        else
            a.addPrestamo(this);
    }

    public void removePrestamo(Abonado a){
        if (a.getLibrosPrestados().isEmpty())
            System.out.println("No tienes ningun libro para devolver.");
        else {
            int codEjemplar = Input.getInt("Dime el codigo del ejemplar");
            for (int i = 0; i < a.getLibrosPrestados().size(); i++) {
                if (codEjemplar == a.getLibrosPrestados().get(i).getCodigoEjemplar(this))
                    removePrestamo(a);
            }
        }
    }
    @Override
    public String toString() {
        String output = "";
        output += "Libro con nombre '" + title + "' " +
                ", lo escribio " + autor +
                ". el isbn es " + isbn;
        if (ejemplares.isEmpty())
            output += ". Y no tiene ejemplares.";
        else
            output += ". Tiene los siguientes ejemplares: " + ejemplares;
        return output + " Es una " + super.toString();
    }
}
