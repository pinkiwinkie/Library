package model;

import listas.GenericLinkedList;
import model.Libro;

public class Abonado {
    private String name;
    private String dni;
    private GenericLinkedList<Prestamo> librosPrestados;

    public Abonado(String name, String dni) {
        this.name = name;
        this.dni = dni;
        this.librosPrestados = new GenericLinkedList<>();
    }

    public boolean hayStock(Libro libro){
        boolean disponibilidad = true;
        for (int i = 1; i < libro.getEjemplares().size(); i++)
            if (!libro.getEjemplares().get(i).isPrestado())
                return disponibilidad;
        return disponibilidad;
    }

    public GenericLinkedList<Prestamo> getLibrosPrestados() {
        return librosPrestados;
    }

    public GenericLinkedList<Prestamo> addPrestamo(Libro libro){
        if (librosPrestados.size() >= 3)
            System.out.println("Solo puedes alquilar un maximo de 3 libros.");
        else
            if (hayStock(libro))
                librosPrestados.addHead(new Prestamo(libro));
        return librosPrestados;
    }

    public GenericLinkedList<Prestamo> removePrestamo(String title){
        if (librosPrestados.size() == 0)
            System.out.println("No tienes ningun libro prestado.");
        for (int i = 0; i < librosPrestados.size(); i++) {

        }
        return librosPrestados;
    }
    public String getName() {
        return name;
    }

    public String getDni() {
        return dni;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Nombre: " + name +
                " dni: " + dni + "\n";
    }
}
