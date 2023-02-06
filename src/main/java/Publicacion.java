public abstract class Publicacion {
    private String editorial;
    private int numPags;
    private boolean color;

    public Publicacion(String editorial, int numPags, boolean color) {
        this.editorial = editorial;
        this.numPags = numPags;
        this.color = color;
    }

    @Override
    public String toString() {
        String output = "";
        output += "Publicacion: " +
                "editorial= " + editorial +
                ", numPags= " + numPags;
        if (color)
            output+= " publicacion a color.";
        else
            output+= " publicacion en blanco y negro.";
        return output;
    }
}
