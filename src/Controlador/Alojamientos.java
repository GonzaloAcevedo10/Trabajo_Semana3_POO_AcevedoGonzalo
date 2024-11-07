package Controlador;

import Modelo.Cabagna;
import Modelo.Carpa;
import Modelo.DatosClientes;
import Modelo.Hotel;
import Modelo.MedioDeAlojamiento;

import java.util.ArrayList;
import java.util.Scanner;

public class Alojamientos {
    //Atributos
    ArrayList<MedioDeAlojamiento> alojamientos;
    public Alojamientos(ArrayList<MedioDeAlojamiento> alojamientos) {
        this.alojamientos = alojamientos;
    }
    //Getter and Setters
    public ArrayList<MedioDeAlojamiento> getAlojamientos() {
        return alojamientos;
    }

    public void setAlojamientos(ArrayList<MedioDeAlojamiento> alojamientos) {
        this.alojamientos = alojamientos;
    }

    //Metodos

    //menu permite la entrada por consola de opciones junto con el ingreso por teclado y retorna la opcion
    public int menu(){
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("--------------------Sistema de alojamientos----------------------\n" +
                    "1.\tIngresar Medio de Alojamiento (almacena un objeto de tipo Carpa/Cabaña/Hotel en la coleccion.)\n" +
                    "2.\tMostrar medios de alojamiento (muestra datos de todos los objetos almacenados)\t\n" +
                    "3.\tDatos de un cliente X (si existe, muestra donde está alojado y todos los datos asociados)\n" +
                    "4.\tTotal adicional\n" +
                    "5.\tTotal bono descuento\n" +
                    "6.\tCantidad medios de alojamiento X\n" +
                    "7.\tValor a cancelar por un cliente X (el cliente debe existir)\n" +
                    "8.\tAplicar incremento del valor base (donde corresponda)\n" +
                    "9.\tSalir. \n");
            System.out.println("Ingrese una opcion:");opcion = leer.nextInt();
            if (opcion < 1 || opcion > 9) System.out.println("Error: Ingrese una opcion valida.");
        }while(opcion < 1 || opcion > 9);
        return opcion;
    }

    //Ingresar permite el ingreso de un nuevo objeto del tipo Hotel, Cabagna o Carpa
    public void ingresar() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = leer.next();
        System.out.println("Ingrese su DNI: ");
        int rut = leer.nextInt();
        System.out.println("Ingrese cantidad de noches: ");
        int cantidadNoche = leer.nextInt();
        System.out.println("Ingrese valor base por noche: ");
        int valorBaseNoche = leer.nextInt();
        System.out.println("Ingrese un tipo de temporada (Baja, Media o Alta): ");
        String tipoTemporada = leer.next();
        int opcion = 0;
        do {
            System.out.println("Ingrese un alojamiento:\n1)\tHotel\n2)\tCabagna\n3)\tCarpa");
            opcion = leer.nextInt();
            if (opcion < 1 || opcion > 3) System.out.println("Error: Ingrese un numero valido.");
        } while (opcion < 1 || opcion > 3);
        switch (opcion) {
            case 1: {
                System.out.println("Ingrese nombre del hotel: ");
                String nombreAlojamiento = leer.next();
                System.out.println("Ingrese capacidad de personas:");
                int capacidad = leer.nextInt();
                opcion = 0;
                do {
                    System.out.println("La persona es fumador/a? \n1)\tSi\n2)\tNo");
                    opcion = leer.nextInt();
                    if (opcion < 1 || opcion > 2) System.out.println("Error: Ingrese un numero valido.");
                } while (opcion < 1 || opcion > 2);
                boolean esFumador = opcion == 1;
                opcion = 0;
                do {
                    System.out.println("Cuenta con desayuno? \n1)\tSi\n2)\tNo");
                    opcion = leer.nextInt();
                    if (opcion < 1 || opcion > 2) System.out.println("Error: Ingrese un valor valido.");
                } while (opcion < 1 || opcion > 2);
                boolean conDesayuno = opcion == 1;
                DatosClientes cliente = new DatosClientes(nombre, rut);
                Hotel hotel = new Hotel(cliente, nombreAlojamiento, cantidadNoche, valorBaseNoche, tipoTemporada, capacidad, esFumador, conDesayuno);
                ingresarAlojamientoHotel(hotel);
                break;
            }
            case 2: {
                System.out.println("Ingrese nombre de la Cabagna: ");
                String nombreAlojamiento = leer.next();
                System.out.println("Ingrese capacidad de personas:");
                int capacidad = leer.nextInt();
                opcion = 0;
                do {
                    System.out.println("La persona es fumador/a? \n1)\tSi\n2)\tNo");
                    opcion = leer.nextInt();
                    if (opcion < 1 || opcion > 2) System.out.println("Error: Ingrese un numero valido.");
                } while (opcion < 1 || opcion > 2);
                boolean esFumador = opcion == 1;
                opcion = 0;
                do {
                    System.out.println("Cuenta con Chimenea? \n1)\tSi\n2)\tNo");
                    opcion = leer.nextInt();
                    if (opcion < 1 || opcion > 2) System.out.println("Error: Ingrese un valor valido.");
                } while (opcion < 1 || opcion > 2);
                boolean chimenea = opcion == 1;
                DatosClientes cliente = new DatosClientes(nombre, rut);
                Cabagna cabagna = new Cabagna(cliente, nombreAlojamiento, cantidadNoche, valorBaseNoche, tipoTemporada, capacidad, esFumador, chimenea);
                ingresarAlojamientoCabagna(cabagna);
                break;
            }
            case 3: {
                System.out.println("Ingrese nombre de la Carpa:");
                String nombreAlojamiento = leer.next();
                System.out.println("Ingrese la cantidad de personas:");
                int cantidadPersonas = leer.nextInt();
                DatosClientes cliente = new DatosClientes(nombre, rut);
                Carpa carpa = new Carpa(cliente, nombreAlojamiento, cantidadNoche, valorBaseNoche, tipoTemporada, cantidadPersonas);
                ingresarAlojamientoCarpa(carpa);
                break;
            }
        }
    }

    //Metodo para buscar una persona en alojamientos por rut
    public int buscarRut(int rut) {
        System.out.println("Buscando RUT . . .");
        for (int i = 0; i < alojamientos.size(); i++) {
            if (alojamientos.get(i).getDatosClientes().getRut() == rut) {
                return i;
            }
        }
        return -1;
    }

    //Ingresar alojamientos Hotel permite la verificacion de existencia y posterior carga del objeto Hotel
    public void ingresarAlojamientoHotel(Hotel hotel) {
        if (buscarRut(hotel.getDatosClientes().getRut()) == -1) {
            //No se encuentra el calzado ingresado
            alojamientos.add(hotel);
        }
    }

    //Ingresar alojamientos Cabagna permite la verificacion de existencia y posterior carga del objeto Cabagna
    public void ingresarAlojamientoCabagna(Cabagna cabagna) {
        if (buscarRut(cabagna.getDatosClientes().getRut()) == -1) {
            //No se encuentra el calzado ingresado
            alojamientos.add(cabagna);
        }
    }

    //Ingresar alojamientos Carpa permite la verificacion de existencia y posterior carga del objeto Carpa
    public void ingresarAlojamientoCarpa(Carpa carpa) {
        if (buscarRut(carpa.getDatosClientes().getRut()) == -1) {
            //No se encuentra el calzado ingresado
            alojamientos.add(carpa);
        }
    }

    //Mostrar alojamientos permite la vista por consola de los alojamientos separados por el tipo de objeto
    public void mostrarAlojamiento() {
        System.out.println("\nIniciando Mostrar alojamientos . . .");
        String text;
        System.out.println("--------------------Hoteles--------------------------");
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Hotel) {
                System.out.println("Alojamiento: " + alojamiento.getNombre() + "// " +
                        "Cliente datos: Nombre " + alojamiento.getDatosClientes().getNombre() + ", DNI " + alojamiento.getDatosClientes().getRut() +
                        ", Cantidad de noches " + alojamiento.getCantidadNoche() + ", Valor por noche $" + alojamiento.getValorBaseNoche() +
                        ", Temporada " + alojamiento.getTipoTemporada() +
                        ", Capacidad " + ((Hotel) alojamiento).getCapacidad() + ", Fumador " + ((Hotel) alojamiento).isEsFumador() +
                        ", es con Desayuno " + ((Hotel) alojamiento).isConDesayuno());
            }
        }
        System.out.println("--------------------Cabagnas-------------------------");
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Cabagna) {
                System.out.println("Alojamiento: " + alojamiento.getNombre() + "// " +
                        "Cliente datos: Nombre " + alojamiento.getDatosClientes().getNombre() + ", DNI " + alojamiento.getDatosClientes().getRut() +
                        ", Cantidad de noches " + alojamiento.getCantidadNoche() + ", Valor por noche $" + alojamiento.getValorBaseNoche() +
                        ", Temporada " + alojamiento.getTipoTemporada() +
                        ", Capacidad " + ((Cabagna) alojamiento).getCapacidad() + ", Fumador " + ((Cabagna) alojamiento).isEsFumador() +
                        ", es con Chimenea " + ((Cabagna) alojamiento).isChimenea());
            }
        }
        System.out.println("--------------------Carpas---------------------------");
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Carpa) {
                System.out.println("Alojamiento: " + alojamiento.getNombre() + "// " +
                        "Cliente datos: Nombre " + alojamiento.getDatosClientes().getNombre() + ", DNI " + alojamiento.getDatosClientes().getRut() +
                        ", Cantidad de noches " + alojamiento.getCantidadNoche() + ", Valor por noche $" + alojamiento.getValorBaseNoche() +
                        ", Temporada " + alojamiento.getTipoTemporada() +
                        ", Cantidad de personas " + ((Carpa) alojamiento).getCantPersonas());
            }
        }
    }

    //Datos cliente recibe un Rut por parametro para su posterior busqueda e imprimir los datos correspondientes
    public String datosCliente(int rut) {
        System.out.println("\nIniciando Datos Cliente . . .");
        String text = "";
        for (MedioDeAlojamiento alojamiento : alojamientos)
            if (alojamiento.getDatosClientes().getRut() == rut) {
                text = "Alojamiento: " + alojamiento.getNombre() + "// " +
                        "Cliente datos: Nombre " + alojamiento.getDatosClientes().getNombre() + ", DNI " + alojamiento.getDatosClientes().getRut() +
                        ", Cantidad de noches " + alojamiento.getCantidadNoche() + ", Valor por noche $" + alojamiento.getValorBaseNoche() +
                        ", Temporada " + alojamiento.getTipoTemporada();
            }
        return text.isEmpty() ? (text = "No hay resultados para el RUT ingresado") : text;
    }

    //El total adicional acumula los totales adicionales de los objetos de la coleccion
    public float totalAdicional() {
        System.out.println("\nIniciando Total Adicional . . .");
        float total = 0;
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Hotel) {
                total += ((Hotel) alojamiento).adicional();
            }
        }
        return total;
    }

    //Total bono muestra por consola el total de todos los bonos de los objetos de la coleccion
    public float totalBono() {
        System.out.println("\nIniciando Total Bono Descuento . . .");
        float total = 0;
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            total += alojamiento.bonoDescuento();
        }
        return total;
    }

    //Cantidad de medios de alojamientos muestra por consola la cantidad de aljamientos separadas por objeto de cada tipo almacenados en la coleccion
    public void cantMedioAlojamiento() {
        System.out.println("\nIniciando Cantidad de Alojamientos . . .");
        int cantHotel = 0, cantCabagna = 0, cantCarpa = 0;
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Hotel) cantHotel++;
        }
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Cabagna) cantCabagna++;
        }
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Carpa) cantCarpa++;
        }
        System.out.println("Las cantidades se alojamientos ingresados son: ");
        System.out.println("Hoteles: " + cantHotel);
        System.out.println("Cabagnas: " + cantCabagna);
        System.out.println("Carpas: " + cantCarpa);
    }

    //Valor a cancelar que recibe por parametro el rut de un cliente y devuelve el total a pagar
    public float valorCancelar(int rut) {
        System.out.println("\nIniciando Valor a Cancelar . . .");
        int i = buscarRut(rut);
        if (i != -1) {
            return alojamientos.get(i).valorACancelar();
        } else {
            System.out.println("No hay resultados para el RUT ingresado");
            return -1;
        }
    }

    //Aplicar valor base es un metodo que aplica los adicionales al valor base
    public void aplicarValorBase() {
        System.out.println("\nIniciando Aplicar Valor Base . . .");
        int valor = 0;
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Cabagna) {
                ((Cabagna) alojamiento).incrementaValorBase();
                valor++;
            }
        }
        if (valor == 0) {
            System.out.println("No hay elementos a aplicar su valor base.");
        } else {
            System.out.println("Se aplico el valor base correctamente.");
        }
    }
}


