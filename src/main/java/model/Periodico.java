package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Periodico extends Publicacion {
    private String nombre;
    private String date;

    public Periodico(String editorial, int numPags, boolean color, String nombre) {
        super(editorial, numPags, color);
        this.nombre = nombre;
        this.date = ponerFecha();
    }

    public String ponerFecha() {
        LocalDateTime fecha = LocalDateTime.now().plusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return fecha.format(formatter);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Periodico con nombre '" + nombre + "' " +
                "publica en fecha " + date + ". Es una " +
                super.toString();
    }
}
