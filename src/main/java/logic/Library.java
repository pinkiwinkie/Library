package logic;

import listas.GenericLinkedList;
import model.*;
import tools.Input;

import java.util.SortedMap;

public class Library {
    //  si no lo inicializas sale NUllPointerException
    private GenericLinkedList<Publicacion> publicaciones = new GenericLinkedList<>();
    private GenericLinkedList<Abonado> clientes = new GenericLinkedList<>();
    private GenericLinkedList<Libro> libros = new GenericLinkedList<>();
    private GenericLinkedList<Periodico> periodicos = new GenericLinkedList<>();
    private GenericLinkedList<Revista> revistas = new GenericLinkedList<>();


    public Library() {
        generarPublicaciones();
        this.clientes = generarClientes();
    }

    private void generarPublicaciones() {
        libros.addHead(new Libro("uno", 123, true, "yo", "uno cualquiera", 123123));
        periodicos.addHead(new Periodico("dos", 123, false, "masdos"));
        revistas.addHead(new Revista("tres", 465, true, "tre", "cine", Periodicidad.SEMANAL));
        publicaciones = merge(libros, periodicos, revistas);
    }

    private GenericLinkedList<Abonado> generarClientes() {
        clientes.addTail(new Abonado("helena", "1233456"));
        clientes.addTail(new Abonado("jose", "98798456"));
        return clientes;
    }

    public void primerMenu() {
        boolean salir = false;
        do {
            int option = Input.getInt("Como va a acceder? \n " +
                    "1. Cliente.\n" + " 2. Empleado.\n" + " 3. Salir.");
            if (option == 1) {
                mostrarMenuCliente();
                salir = true;
            } else if (option == 2) {
                mostrarMenuEmpleado();
                salir = true;
            } else if (option == 3) {
                System.out.println("Saliendo.");
                salir = true;
            } else
                System.out.println("Introduce 1 o 2");
        } while (!salir);
    }

    private void mostrarMenuCliente() {
        boolean salir = false;
        do {
            int option = Input.getInt("Que quiere hacer? \n " +
                    "1. Obtener un libro." +
                    "\n 2. Devolver un libro." +
                    "\n 3. Ver mis prestamos." +
                    "\n 4. Volver");
            if (option == 1) {
                mostrarPublicaciones();
                obtenerLibro();
                salir = true;
            } else if (option == 2) {
                devolverLibro();
                salir = true;
            } else if (option == 3) {
//                verPrestamos();
                salir = true;
            } else if (option == 4) {
                primerMenu();
                salir = true;
            } else
                System.out.println("Introduce un numero valido");
        } while (!salir);
    }

//    private void verPrestamos() {
//        mostrarClientes();
//        String option = Input.getString("Que cliente? (Dime dni)");
//        for (int i = 0; i < clientes.size(); i++) {
//            if (option.equals(clientes.get(i).getDni()))
//                System.out.println(clientes.get(i).getLibrosPrestados());
//        }
//    }

    private void devolverLibro() {
    }

    private void obtenerLibro(){
        mostrarLibros();
        int option2 = Input.getInt("Que libro? (Dime isbn)");
        for (int i = 0; i < libros.size(); i++) {
            if (option2 == libros.get(i).getIsbn()){

            }
        }
        mostrarClientes();
        String option = Input.getString("Que cliente? (Dime dni)");
        for (int i = 0; i < clientes.size(); i++) {
            if (option.equals(clientes.get(i).getDni())){
//                clientes.get(i).addPrestamo();
            }
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
                primerMenu();
                salir = true;
            } else if (option == 2) {
                darBajaPublicacion();
                primerMenu();
                salir = true;
            } else if (option == 3) {
                darAltaCliente();
                primerMenu();
                salir = true;
            } else if (option == 4) {
                darBajaCliente();
                primerMenu();
                salir = true;
            } else if (option == 5) {
                actualizarDatosClientes();
                primerMenu();
                salir = true;
            } else if (option == 6) {
                primerMenu();
                salir = true;
            } else
                System.out.println("Introduce un numero valido.");
        } while (!salir);
    }

    private void darBajaCliente() {
        mostrarClientes();
        if (!clientes.isEmpty()) {
            String eleccion = Input.getString("Cual? Introduce dni");
            for (int i = 0; i < clientes.size(); i++) {
                if (eleccion.equals(clientes.get(i).getDni())) {
                    clientes.remove(i);
                }
            }
        }
        mostrarClientes();
    }

    public void darBajaPublicacion() {
        boolean salir = false;
        do {
            int option = Input.getInt("Que tipo de publicacion?\n " +
                    "1. Revistas." +
                    "\n 2. Libros." +
                    "\n 3. Periodicos" +
                    "\n 4. Volver");
            if (option == 1) {
                darBajaRevista();
                salir = true;
            } else if (option == 2) {
                darBajaLibro();
                salir = true;
            } else if (option == 3) {
                darBajaPeriodico();
                salir = true;
            } else if (option == 4) {
                mostrarMenuEmpleado();
                salir = true;
            } else
                System.out.println("Introduce una opcion valida");
        }while (!salir);
    }

    private void darBajaPeriodico() {
        mostrarPeriodicos();
        if (!periodicos.isEmpty()) {
            String eleccion = Input.getString("Cual? Introduce nombre");
            for (int i = 0; i < periodicos.size(); i++) {
                if (eleccion.equals(periodicos.get(i).getNombre())) {
                    periodicos.remove(i);
                }
            }
        }
        publicaciones = merge(libros,periodicos,revistas);
        mostrarPublicaciones();
    }

    private void darBajaLibro() {
        mostrarLibros();
        if (!libros.isEmpty()) {
            int eleccion = Input.getInt("Cual? Introduce isbn");
            for (int i = 0; i <= libros.size(); i++) {
                if (eleccion == libros.get(i).getIsbn()) {
                    libros.remove(i);
                }
            }
        }
        publicaciones = merge(libros,periodicos,revistas);
        mostrarPublicaciones();
    }

    public void darBajaRevista() {
        mostrarRevistas();
        if (!revistas.isEmpty()) {
            String eleccion = Input.getString("Cual? Introduce nombre");
            for (int i = 0; i <= revistas.size(); i++) {
                if (eleccion.equals(revistas.get(i).getNombre())) {
                    revistas.remove(i);
                }
            }
        }
        publicaciones = merge(libros,periodicos,revistas);
        mostrarPublicaciones();
    }

    private void actualizarDatosClientes() {
        boolean salir = false;
        String option = Input.getString("Que cliente quieres modificar? (Escribe dni)");
        do {
            int datoModificar = Input.getInt("Que dato va a modificar? (1. Nombre. 2. Dni. 3. Ambos");
            String datoModificado;
            for (int i = 0; i < clientes.size(); i++) {
                if (option.equals(clientes.get(i).getDni())) {
                    if (datoModificar == 1) {
                        datoModificado = Input.getString("Dime el nuevo nombre");
                        clientes.get(i).setName(datoModificado);
                        salir = true;
                    } else if (datoModificar == 2) {
                        datoModificado = Input.getString("Dime el nuevo dni");
                        clientes.get(i).setDni(datoModificado);
                        salir = true;
                    } else if (datoModificar == 3) {
                        datoModificado = Input.getString("Dime el nuevo nombre");
                        clientes.get(i).setName(datoModificado);
                        datoModificado = Input.getString("Dime el nuevo dni");
                        clientes.get(i).setDni(datoModificado);
                        salir = true;
                    }else
                        System.out.println("Introduce un numero valido");
                }
            }
        } while (!salir);
        mostrarClientes();
    }

    private GenericLinkedList<Publicacion> merge(GenericLinkedList<Libro> libros, GenericLinkedList<Periodico> periodicos, GenericLinkedList<Revista> revistas) {
        Publicacion p;
        publicaciones.clear();
        for (int i = 0; i < libros.size(); i++) {
            p = libros.get(i);
            publicaciones.addHead(p);
        }
        for (int i = 0; i < libros.size(); i++) {
            p = periodicos.get(i);
            publicaciones.addHead(p);
        }

        for (int i = 0; i < libros.size(); i++) {
            p = revistas.get(i);
            publicaciones.addHead(p);
        }
        return publicaciones;
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
        mostrarClientes();
    }

    private void darAltaPublicacion() {
        int option = Input.getInt("Que tipo de publicacion?\n " +
                "1. Revistas." +
                "\n 2. Libros." +
                "\n 3. Periodicos");
        if (option == 1) {
            Revista revista = crearUnaRevista();
            revistas.addTail(revista);
            publicaciones = merge(libros, periodicos, revistas);
        } else if (option == 2) {
            Libro libro = crearUnLibro();
            libro.addEjemplar(3);
            libros.addTail(libro);
            publicaciones = merge(libros, periodicos, revistas);
        } else if (option == 3) {
            Periodico periodico = crearUnPeriodico();
            periodicos.addTail(periodico);
            publicaciones = merge(libros, periodicos, revistas);
        }
        mostrarPublicaciones();
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
//        if (publicaciones.isEmpty())
//            System.out.println("No hay publicaciones.");
//        else {
            for (int i = 0; i < publicaciones.size(); i++) {
                if (publicaciones.get(i) == null) {
//                    System.out.println("no hay publicaciones");
                } else {
                    System.out.print((i + 1) + " " + publicaciones.get(i));
                }
            }
            System.out.println();
//        }
    }

    public void mostrarRevistas() {
        if (revistas.isEmpty())
            System.out.println("No hay revistas.");
        else {
            for (int i = 0; i < revistas.size(); i++) {
                if (revistas.get(i) == null) {
                    System.out.println("no hay revistas");
                }else{
                    System.out.print((i + 1) + " " + revistas.get(i));
                }
            }
            System.out.println();
        }
    }

    public void mostrarPeriodicos() {
        if (periodicos.isEmpty())
            System.out.println("No hay periodicos");
        else {
            for (int i = 0; i < periodicos.size(); i++) {
                if (periodicos.get(i) == null) {
                    System.out.println("no hay periodicos");
                }else {
                    System.out.print((i + 1) + " " + periodicos.get(i));
                }
            }
            System.out.println();
        }
    }

    public void mostrarLibros() {
        if (libros.isEmpty())
            System.out.println("No hay libros");
        else {
            for (int i = 0; i < libros.size(); i++) {
                if (libros.get(i) == null) {
                    System.out.println("no hay libros");
                }else {
                    System.out.print((i + 1) + " " + libros.get(i));
                }
            }
            System.out.println();
        }
    }

    public void mostrarClientes() {
        if (clientes.isEmpty())
            System.out.println("No hay clientes");
        else {
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i) == null)
                    System.out.println("no hay clientes");
                else {
                    System.out.print((i + 1) + " " + clientes.get(i));
                }
            }
            System.out.println();
        }
    }

    public GenericLinkedList<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public GenericLinkedList<Abonado> getClientes() {
        return clientes;
    }

    @Override
    public String toString() {
        return "La biblioteca tiene las siguientes publicaciones: \n" +
                publicaciones
                + " y los siguientes clientes: \n" +
                clientes;
    }
}
