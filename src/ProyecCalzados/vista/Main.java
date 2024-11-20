package ProyecCalzados.vista;


import ProyecCalzados.controlador.TiendaCalzados;


public class Main {
    public static void main(String[] args) {
        TiendaCalzados tiendaCalzados = new TiendaCalzados();
        int opcion = 0;
        do{
            System.out.println("\t\tSistema\n1) Ingresar\n2) Mostrar solo calzado de mujer\n3) Valor venta\n"
                    +"4) Calzados top\n5) Total impuesto especifico\n6) Total descuento\n7) Salir");
            opcion = Leer.datoInt();
            switch (opcion){
                case 1:
                    tiendaCalzados.ingresarCalzado();
                    break;
                case 2:
                    tiendaCalzados.mostrarCalzadoMujer();
                    break;
                case 3:
                    tiendaCalzados.valorVenta();
                    break;
                case 4:
                    tiendaCalzados.calzadosTop();
                    break;
                case 5:
                    tiendaCalzados.impuestoEspecificoTotal();
                    break;
                case 6:
                    tiendaCalzados.descuentoTotal();
                    break;
                case 7:
                    System.out.println("Saliendo . . .");
                    break;
                default:
                    System.out.println("Error. Ingrese una opcion correcta.");
            }

        }while(opcion != 7);
    }
}