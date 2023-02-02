public class Periodico extends Publicacion{
    private String nombre;
    private String date;

    public Periodico(String editorial, int numPags, boolean color, String nombre, String date) {
        super(editorial, numPags, color);
        this.nombre = nombre;
        this.date = date;
    }

}
