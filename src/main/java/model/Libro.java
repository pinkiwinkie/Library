package model;

import listas.GenericLinkedList;

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

    @Override
    public boolean equals(Object obj) {

    }
}
