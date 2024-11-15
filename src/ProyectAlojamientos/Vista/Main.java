package ProyectAlojamientos.Vista;

import ProyectAlojamientos.Controlador.Alojamientos;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Alojamientos alojamientos = new Alojamientos(new ArrayList<>());
        int opcion = 0;
        do {
            Scanner leer = new Scanner(System.in);
            opcion = alojamientos.menu();
            int rut = 0;
            switch (opcion){
                case 1:
                    alojamientos.ingresar();
                    break;
                case 2:
                    alojamientos.mostrarAlojamiento();
                    break;
                case 3:
                    System.out.println("Ingrese un RUT: ");rut = leer.nextInt();
                    System.out.println(alojamientos.datosCliente(rut));
                    break;
                case 4:
                    System.out.println("El total adicional es: "+alojamientos.totalAdicional());
                    break;
                case 5:
                    System.out.println("El total Bono descuento es: "+alojamientos.totalBono());
                    break;
                case 6:
                    alojamientos.cantMedioAlojamiento();
                    break;
                case 7:
                    System.out.println("Ingrese un RUT: ");rut = leer.nextInt();
                    System.out.println("El valor a cancelar es: "+alojamientos.valorCancelar(rut));
                    break;
                case 8:
                    alojamientos.aplicarValorBase();
                    break;
                case 9:
                    System.out.println("Saliendo . . .");
                    opcion = 9;
                    break;
            }
        }while (opcion != 9);
    }
}