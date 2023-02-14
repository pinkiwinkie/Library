package model;

import listas.GenericLinkedList;
import tools.Input;

public class Abonado {
    private String name;
    private String dni;
    private GenericLinkedList<Prestamo> librosPrestados;

    public Abonado(String name, String dni) {
        this.name = name;
        this.dni = dni;
        this.librosPrestados = new GenericLinkedList<>();
    }

    public boolean siHayEjemplaresDisponibles(Libro libro){
        boolean disponibilidad = true;
        for (int i = 1; i < libro.getEjemplares().size(); i++)
            if (!libro.getEjemplares().get(i).isPrestado())
                return disponibilidad;
        return disponibilidad;
    }

    public GenericLinkedList<Prestamo> getLibrosPrestados() {
        return librosPrestados;
    }

    public void addPrestamo(Libro libro){
        if (librosPrestados.size() >= 3)
            System.out.println("Solo puedes alquilar un maximo de 3 libros.");
        else {
            if (siHayEjemplaresDisponibles(libro)) {
                librosPrestados.addHead(new Prestamo(libro));
                libro.addPrestamo(this);
            }
        }
    }

    public void removePrestamo(Libro libro){
        if (librosPrestados.size() == 0)
            System.out.println("No tienes ningun libro prestado.");
        for (int i = 0; i < librosPrestados.size(); i++) {
            int codEjemplar = Input.getInt("Dime el codigo del ejemplar");
            if (codEjemplar == getLibrosPrestados().get(i).getCodigoEjemplar(libro))
                removePrestamo(libro);
        }
        mostrarLibrosPrestados();
    }

    public void mostrarLibrosPrestados(){
        if (librosPrestados.isEmpty())
            System.out.println("No hay libros prestados.");
        else{
            for (int i = 0; i < librosPrestados.size(); i++) {
                if (librosPrestados.get(i) == null)
                    System.out.println("No hay libros prestados.");
                else
                    System.out.println((i+1) + " " + librosPrestados.get(i));
            }
        }
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
