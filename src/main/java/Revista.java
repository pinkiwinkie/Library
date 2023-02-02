public class Revista extends Publicacion{
    private String nombre;
    private String tematica;
    private Periodicidad periodicidad;

    public Revista(String editorial, int numPags, boolean color, String nombre, String tematica, Periodicidad periodicidad) {
        super(editorial, numPags, color);
        this.nombre = nombre;
        this.tematica = tematica;
        this.periodicidad = periodicidad;
    }

    public enum Periodicidad{
        SEMANAL("semanalmente"),
        MENSUAL("mensualmente"),
        TRIMESTRAL("trimestralmente");

        private String cadena;
        Periodicidad(String cadena){
            this.cadena = cadena;
        }

        @Override
        public String toString() {
            return "Periodicidad: " + cadena;
        }
    }

    @Override
    public String toString() {
        return "Revista{" +
                "nombre= " + nombre +
                ", tematica= " + tematica +
                ", periodicidad= " + periodicidad +
                "} " + super.toString();
    }
}
