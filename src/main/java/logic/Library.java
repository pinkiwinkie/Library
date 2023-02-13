package logic;

import listas.GenericLinkedList;
import model.*;
import tools.Input;

public class Library {
    //  si no lo inicializas sale NUllPointerException
    private GenericLinkedList<Publicacion> publicaciones = new GenericLinkedList<>();
    private GenericLinkedList<Abonado> clientes = new GenericLinkedList<>();

    public Library() {
        this.publicaciones = generarPublicaciones();
        this.clientes = generarClientes();
    }

    public GenericLinkedList<Publicacion> generarPublicaciones() {
        publicaciones.addTail(new Libro("uno", 123, true, "yo", "uno cualquiera", 123123));
        publicaciones.addTail(new Periodico("dos", 123, false, "dos masdos"));
        publicaciones.addTail(new Revista("tres", 465, true, "un tre", "cine", Periodicidad.SEMANAL));
        return publicaciones;
    }

    public GenericLinkedList<Abonado> generarClientes() {
        clientes.addTail(new Abonado("helena", "1233456"));
        clientes.addTail(new Abonado("jose", "98798456"));
        return clientes;
    }

    public void primerMenu() {
        int option = Input.getInt("Como va a acceder? \n " +
                "1. Cliente." + "2. Empleado.");
        if (option == 1)
            mostrarMenuCliente();
        else if (option == 2)
            mostrarMenuEmpleado();
    }

    private void mostrarMenuCliente() {
        int option = Input.getInt("Que quiere hacer? " +
                "1. Obtener una publicacion." +
                "2. Devolver publicacion");
        if (option == 1) {
            mostrarPublicaciones();
            int eleccion = Input.getInt("");
        }
    }

    private void mostrarMenuEmpleado(){
        int option = Input.getInt("Que quiere hacer?" +
                "1. Dar de alta una publicacion." +
                "2. Dar de baja una publicacion." +
                "3. Añadir cliente." +
                "4. Eliminar cliente." +
                "5. Actualizar datos del cliente.");
    }

    public void mostrarPublicaciones() {
        for (int i = 0; i < publicaciones.size(); i++) {
            System.out.println(publicaciones.get(i));
        }
    }

    public void mostrarClientes() {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i));
        }
    }

    @Override
    public String toString() {
        return "La biblioteca tiene las siguientes publicaciones: \n" +
                publicaciones + " y los siguientes clientes: \n" +
                clientes;
    }
}
