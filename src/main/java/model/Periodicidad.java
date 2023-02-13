package model;

public enum Periodicidad {
    SEMANAL("cada semana"),
    MENSUAL("cada mes"),
    TRIMESTRAL("cada trimestre");

    private String cadena;

    Periodicidad(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public String toString() {
        return cadena;
    }
}

