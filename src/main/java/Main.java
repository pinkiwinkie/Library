import listas.GenericLinkedList;

public class Main {
    public static void main(String[] args) {
        GenericLinkedList<Publicacion> publicaciones = new GenericLinkedList<>();
        Libro harryPotter = new Libro("anaya",300,true,
                "J.K.Rowling","Harry Potter y la piedra filosofal",
                1234);
        Ejemplar ejemplar1 = new Ejemplar();
        Ejemplar ejemplar2 = new Ejemplar();
        Prestamo prestamo = new Prestamo("hoy","mañana",harryPotter,1);
        GenericLinkedList<Prestamo> prestamos = new GenericLinkedList<>();
        prestamos.addHead(prestamo);
        Abonado abonado = new Abonado("ptt","123C",prestamos);
        ejemplar1.addAbonado(abonado);
        publicaciones.addHead(harryPotter);
        harryPotter.addEjemplar(ejemplar1);
        harryPotter.addEjemplar(ejemplar2);
        System.out.println(publicaciones);
//        System.out.println(harryPotter);
    }
}
