package model;

import model.Libro;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Prestamo {
    private String fechaInicio, fechaDevolucion;
    private String tittleLibro;
    private int codigoEjemplar;

    public Prestamo(Libro libro) {
        this.fechaInicio = ponerFecha();
        this.fechaDevolucion = sumarDiasAFecha();
        this.tittleLibro = libro.getTitle();
        this.codigoEjemplar = getCodigoEjemplar(libro);
    }

    public String sumarDiasAFecha() {
        LocalDateTime fecha = LocalDateTime.now().plusDays(15);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return fecha.format(formatter);
    }

    public String ponerFecha() {
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return fecha.format(formatter);
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }


    public int getCodigoEjemplar(Libro libro) {
        int codigo;
        for (int i = 1; i < libro.getEjemplares().size(); i++) {
            if (!libro.getEjemplares().get(i).isPrestado()) {
                codigo = libro.getEjemplares().get(i).getCodigo();
                libro.getEjemplares().get(i).setPrestado(true);
                return codigo;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "El prestamo se ha iniciado el " + fechaInicio +
                " y finaliza el " + fechaDevolucion +
                ". El ejemplar tiene el codigo " + codigoEjemplar +
                ". Y el libro es el siguiente: \n" + tittleLibro;
    }
}