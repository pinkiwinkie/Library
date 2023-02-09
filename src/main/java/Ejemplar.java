import listas.GenericLinkedList;

public class Ejemplar {
    private int codigo;
    private GenericLinkedList<Abonado> abonados;
    private boolean prestado;
    private Libro libro;


    public Ejemplar(int codigo) {
        this.abonados = new GenericLinkedList<>();
        this.codigo = codigo;
    }
    public void addAbonado(Abonado abonado){
       abonados.addHead(abonado);
    }
//    public int incrementCode(){
//        if (abonados.isEmpty())
//            codigo =1;
//        else
//            codigo = abonados.size()+1;
//        return codigo;
//    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        String output = "";
        output += "\nCon codigo " + codigo;
        if (abonados.isEmpty())
            output += ". Este ejemplar no se ha prestado aún.";
        else
            output += ". La lista de abonados es la siguiente: " + abonados;
        return output;
//        return "\nEjemplar: " +
//                "codigo= " + codigo +
//                ", abonados =" + abonados;
    }
}
