package ProyecCalzados.controlador;

import ProyecCalzados.element.*;
import ProyecCalzados.vista.Leer;
import ProyecCalzados.element.Mujer;
import ProyecCalzados.element.Hombre;
import ProyecCalzados.element.Deportivo;
import ProyecCalzados.element.Producto;
import java.util.ArrayList;

public class TiendaCalzados {

    //Controladores
    ArrayList<Calzado> calzados = new ArrayList<>();

    public void ingresarCalzado(){
        System.out.println("Ingrese un codigo: ");String codigo = Leer.dato();
        if(validarExistencia(codigo)){
            System.out.println("El calzado es existente. Ingrese un nuevo calzado");
            return;
        }
        System.out.println("Ingrese el stock: ");int stock = Leer.datoInt();
        System.out.println("Ingrese un valor base: ");float valorBase = Leer.datoFloat();
        Producto producto = new Producto(codigo,stock,valorBase);
        System.out.println("Ingrese un dia de venta: ");String diaDeVenta = Leer.dato();
        System.out.println("Ingrese una medida: ");float medida = Leer.datoFloat();
        int dato = 0;
        do {
            System.out.println("El calzado es:\n1) Deportivo\n2) Formal");
            dato = Leer.datoInt();
            if (dato < 1 || dato > 2) System.out.println("Error. Ingrese una ocpion correcta.");
        }while (dato < 1 || dato > 2);
        if (dato == 1){
            System.out.println("Ingrese un deporte: ");String deporte = Leer.dato();
            System.out.println("Ingrese un material: ");String material = Leer.dato();
            Deportivo deportivo = new Deportivo(producto,diaDeVenta,medida,deporte,material);
            ingresarDeportivo(deportivo);
        }
        else {
            do {
                System.out.println("El calzado es: \n1) Hombre\n2) Mujer");dato = Leer.datoInt();
                if (dato < 1 || dato > 2) System.out.println("Error. Ingrese una ocpion correcta.");

            }while (dato < 1 || dato > 2);
            if ( dato == 1){
                System.out.println("Ingrese un color: ");String color = Leer.dato();
                Hombre hombre = new Hombre(producto,diaDeVenta,medida,color);
                ingresarHombre(hombre);
            }
            else {
                System.out.println("Ingrese un color: ");String color = Leer.dato();
                System.out.println("Ingrese una altura de taco: ");float alturaTaco = Leer.datoFloat();
                Mujer mujer = new Mujer(producto,diaDeVenta,medida,color,alturaTaco);
                ingresarMujer(mujer);
            }
        }
    }
    public void ingresarDeportivo(Deportivo deportivo){
        this.calzados.add(deportivo);
        System.out.println("Se ingreso correctamente!");
    }
    public void ingresarHombre(Hombre hombre){
        this.calzados.add(hombre);
        System.out.println("Se ingreso correctamente!");
     }
    public void ingresarMujer(Mujer mujer){
        this.calzados.add(mujer);
        System.out.println("Se ingreso correctamente!");
    }
    public void mostrarCalzadoMujer(){
        for(Calzado calzado : calzados){
            if(calzado instanceof Mujer){
                System.out.println("Codigo: "+calzado.getProducto().getCodigo()+
                        ", Stock: "+calzado.getProducto().getStock()+
                        ", Valor Base: "+calzado.getProducto().getValorBase()+
                        ", Dia de venta: "+calzado.getDiaDeVenta()+
                        ", Medida: "+calzado.getMedida()+
                        ", Color: "+((Mujer) calzado).getColor()+
                        ", Altura: "+((Mujer) calzado).getAlturaTaco()+
                        ", y su descuento es: "+((Mujer) calzado).descuento());
            }
        }
    }
    public boolean validarExistencia(String codigo){
        for(Calzado calzado : calzados){
            if(calzado.getProducto().getCodigo().equalsIgnoreCase(codigo)){
                return true;
            }
        }
        return false;
    }
    public Calzado buscarCalzado(String codigo){
        int i = 0;
        for(Calzado calzado : calzados){
            if(calzado.getProducto().getCodigo().equalsIgnoreCase(codigo)){
                return calzado;
            }
        }
        System.out.println("No se encontro el calzado ingresado");
        return null;
    }
    public void valorVenta(){
        System.out.println("Ingrese un codigo: ");String codigo = Leer.dato();
        if(validarExistencia(codigo)){
            System.out.println("Calzado encontrado!.");
        }
        else {
            System.out.println("El no existe. Ingrese un codigo valido.");
            return;
        }
        Calzado calzado = buscarCalzado(codigo);
        if(codigo.equals(calzado.getProducto().getCodigo())){
            System.out.println("El valor venta es: "+calzado.valorVenta());
            System.out.println("El numero es: "+calzado.getMedida());
        }
        else System.out.println("Error. No se encontro el codigo ingresado.");
    }
    public void calzadosTop(){
        int cont = 0;
        for (Calzado calzado : calzados){
            if(calzado.valorVenta() > 80000)cont++;
        }
        System.out.println("La cantidad de zapatos top: "+cont);
    }
    public void impuestoEspecificoTotal(){
        float especifico = 0;
        for (Calzado calzado : calzados){
            if (calzado instanceof Hombre)especifico += ((Hombre) calzado).impuestoEspecifico();
            if (calzado instanceof Mujer)especifico += ((Mujer) calzado).impuestoEspecifico();
        }
        System.out.println("El impuesto total especifico es: "+especifico);
    }
    public void descuentoTotal(){
        float descuento = 0;
        for (Calzado calzado : calzados){
            if (calzado instanceof Hombre)descuento += ((Hombre) calzado).descuento();
            if (calzado instanceof Mujer)descuento += ((Mujer) calzado).descuento();
        }
        System.out.println("El impuesto total especifico es: "+descuento);
    }
}

