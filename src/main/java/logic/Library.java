package logic;

import listas.GenericLinkedList;
import model.*;
import tools.Input;

public class Library {
    //  si no lo inicializas sale NUllPointerException
    private GenericLinkedList<Publicacion> publicaciones = new GenericLinkedList<>();
    private GenericLinkedList<Abonado> clientes = new GenericLinkedList<>();
    private GenericLinkedList<Libro> libros = new GenericLinkedList<>();
    private GenericLinkedList<Periodico> periodicos = new GenericLinkedList<>();
    private GenericLinkedList<Revista> revistas = new GenericLinkedList<>();

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
        boolean salir = false;
        do {
            int option = Input.getInt("Como va a acceder? \n " +
                    "1. Cliente.\n" + " 2. Empleado.");
            if (option == 1) {
                mostrarMenuCliente();
                salir = true;
            } else if (option == 2) {
                mostrarMenuEmpleado();
                salir = true;
            } else
                System.out.println("Introduce 1 o 2");
        } while (!salir);
    }

    private void mostrarMenuCliente() {
        int option = Input.getInt("Que quiere hacer? \n" +
                "1. Obtener una publicacion." +
                "\n2. Devolver publicacion" +
                "\n3. Volver");
        if (option == 1) {
            mostrarPublicaciones();
        }
    }

    private void mostrarMenuEmpleado() {
        boolean salir = false;
        do {
            int option = Input.getInt("Que quiere hacer?\n " +
                    "1. Dar de alta una publicacion." +
                    "\n 2. Dar de baja una publicacion." +
                    "\n 3. Añadir cliente." +
                    "\n 4. Eliminar cliente." +
                    "\n 5. Actualizar datos del cliente." +
                    "\n 6. Volver");
            if (option == 1) {
                darAltaPublicacion();
                salir = true;
            } else if (option == 2) {
                darBajaPublicacion();
                salir = true;
            } else if (option == 3) {
                darAltaCliente();
                salir = true;
            } else if (option == 4) {
//                darBajaCliente();
                salir = true;
            } else if (option == 5) {
                salir = true;
            } else if (option == 6) {
                primerMenu();
                salir = true;
            } else
                System.out.println("Introduce un numero valido.");
        } while(!salir);
    }

    private void darBajaPublicacion(){

        String option = Input.getString("Que publicacion quiere borrar? (Introduce nombre):");

    }
    private Abonado generarCliente() {
        String name, dni;

        name = Input.getString("Introduce el nombre: ");
        dni = Input.getString("Introduce el dni: ");

        return new Abonado(name, dni);
    }

    private void darAltaCliente() {
        Abonado abonado = generarCliente();
        clientes.addTail(abonado);
    }

    private void darAltaPublicacion() {
        menuPublicaciones();
        mostrarPublicaciones();
    }

    private void menuPublicaciones() {
        int option = Input.getInt("Que tipo de publicacion?\n " +
                "1. Revistas." +
                "\n 2. Libros." +
                "\n 3. Periodicos");
        if (option == 1) {
            Revista revista = crearUnaRevista();
            publicaciones.addTail(revista);
        } else if (option == 2) {
            Libro libro = crearUnLibro();
            publicaciones.addTail(libro);
        } else if (option == 3) {
            Periodico periodico = crearUnPeriodico();
            publicaciones.addTail(periodico);
        }
    }

    private Periodico crearUnPeriodico() {
        String editorial, name;
        int numPag, color;
        boolean colorFinal = false, salir = false;

        editorial = Input.getString("Introduce la editorial: ");
        numPag = Input.getInt("Introduce numero de paginas: ");

        do {
            color = Input.getInt("Introduce tipo de impresion (1. Con color. 2. En blanco y negro):");
            if (color == 1) {
                colorFinal = true;
                salir = true;
            } else if (color == 2) {
                colorFinal = false;
                salir = true;
            } else
                System.out.println("Introduce un numero valido.");
        } while (!salir);

        name = Input.getString("Introduce el nombre: ");

        return new Periodico(editorial, numPag, colorFinal, name);
    }

    private Libro crearUnLibro() {
        String editorial, autor, titulo;
        int numPag, color, isbn;
        boolean colorFinal = false, salir = false;

        editorial = Input.getString("Introduce la editorial: ");
        numPag = Input.getInt("Introduce numero de paginas: ");

        do {
            color = Input.getInt("Introduce tipo de impresion (1. Con color. 2. En blanco y negro):");
            if (color == 1) {
                colorFinal = true;
                salir = true;
            } else if (color == 2) {
                colorFinal = false;
                salir = true;
            } else
                System.out.println("Introduce un numero valido.");
        } while (!salir);

        autor = Input.getString("Introduce el autor: ");
        titulo = Input.getString("Introduce el titulo: ");
        isbn = Input.getInt("Introduce el isbn");

        return new Libro(editorial, numPag, colorFinal, autor, titulo, isbn);
    }

    private Revista crearUnaRevista() {
        String editorial, name, tematica;
        int numPag, color, periodicidad;
        boolean colorFinal = false, salir = false;
        Periodicidad periodicidadFinal = null;

        editorial = Input.getString("Introduce la editorial: ");
        numPag = Input.getInt("Introduce numero de paginas: ");
        name = Input.getString("Introduce el nombre: ");

        do {
            color = Input.getInt("Introduce tipo de impresion (1. Con color. 2. En blanco y negro):");
            if (color == 1) {
                colorFinal = true;
                salir = true;
            } else if (color == 2) {
                colorFinal = false;
                salir = true;
            } else
                System.out.println("Introduce un numero valido.");
        } while (!salir);

        tematica = Input.getString("Introduce la tematica");

        salir = false;
        do {
            periodicidad = Input.getInt("Introduce la periodicidad (1. Semanal. 2. Mensual. 3. Trimestral.): ");
            if (periodicidad == 1) {
                periodicidadFinal = Periodicidad.SEMANAL;
                salir = true;
            } else if (periodicidad == 2) {
                periodicidadFinal = Periodicidad.MENSUAL;
                salir = true;
            } else if (periodicidad == 3) {
                periodicidadFinal = Periodicidad.TRIMESTRAL;
                salir = true;
            } else
                System.out.println("Introduce un numero valido.");
        } while (!salir);

        return new Revista(editorial, numPag, colorFinal, name, tematica, periodicidadFinal);
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
