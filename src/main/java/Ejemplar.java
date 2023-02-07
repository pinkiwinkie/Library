import listas.GenericLinkedList;

public class Ejemplar {
    private int codigo;
    private GenericLinkedList<Abonado> abonados;
    //booleano de si esta prestado o no y el libro


    public Ejemplar() {
        this.abonados = new GenericLinkedList<>();
        this.codigo = incrementCode();
    }
    public void addAbonado(Abonado abonado){
       abonados.addHead(abonado);
    }
    public int incrementCode(){
        if (abonados.isEmpty())
            codigo =1;
        else
            codigo = abonados.size()+1;
        return codigo;
    }

    @Override
    public String toString() {
        return "\nEjemplar: " +
                "codigo= " + codigo +
                ", abonados =" + abonados;
    }
}
