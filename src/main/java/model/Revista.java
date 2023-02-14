package model;

public class Revista extends Publicacion {
    private String nombre;
    private String tematica;
    private Periodicidad periodicidad;

    public Revista(String editorial, int numPags, boolean color, String nombre, String tematica, Periodicidad periodicidad) {
        super(editorial, numPags, color);
        this.nombre = nombre;
        this.tematica = tematica;
        this.periodicidad = periodicidad;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Revista con nombre '" + nombre + "' " +
                "y tematica " + tematica +
                ". Saca nuevo numero " + periodicidad +
                ". Es una " + super.toString();
    }
}
