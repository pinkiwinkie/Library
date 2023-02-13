package model;

import listas.GenericLinkedList;

public class Ejemplar {
    private int codigo;
    private GenericLinkedList<Abonado> abonados;
    private boolean prestado;

    public Ejemplar(int codigo) {
        this.abonados = new GenericLinkedList<>();
        this.codigo = codigo;
        this.prestado = false;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public void addAbonado(Abonado abonado) {
        abonados.addHead(abonado);
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        String output = "";
        output += "\nCon codigo " + codigo;
        if (prestado)
            output += " no disponible";
        else
            output += " disponible";
        if (!abonados.isEmpty())
            output += ". La lista de abonados es la siguiente: " + abonados;
        return output;
    }
}
