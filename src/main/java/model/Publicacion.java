package model;

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
        output += "publicacion con editorial: " + editorial +
                " y con " + numPags + " paginas,";
        if (color)
            output+= " tiene impresion a color.\n";
        else
            output+= " tiene impresion a blanco y negro.\n";
        return output;
    }
}
