public class Periodico extends Publicacion{
    private String nombre;
    private String date;

    public Periodico(String editorial, int numPags, boolean color, String nombre, String date) {
        super(editorial, numPags, color);
        this.nombre = nombre;
        this.date = date;
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
        return "Periodico{" +
                "nombre='" + nombre + '\'' +
                ", date='" + date + '\'' +
                "} " + super.toString();
    }
}
