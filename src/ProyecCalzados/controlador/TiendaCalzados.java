package ProyecCalzados.controlador;



import ProyecCalzados.element.Calzado;
import ProyecCalzados.element.Deportivo;
import ProyecCalzados.element.Hombre;
import ProyecCalzados.element.Mujer;
import ProyecCalzados.vista.Leer;

import java.util.ArrayList;

public class TiendaCalzados {

    /*1.	Ingresar
2.	Mostrar sólo los calzado de mujer
3.	Valor Venta
4.	Calzados top
5.	Total Impuesto Especifico
6.	Total descuento
7.	Salir
*/
     ArrayList<Calzado> calzados;
    public TiendaCalzados(ArrayList<Calzado> calzados) {
        this.calzados;
    }

    public void ingresarDeportivo(Deportivo deportivo){
        calzados.add(deportivo);
    }
     public void ingresarHombre(Hombre hombre){
        calzados.add(hombre);
     }

     public void ingresarMujer(Mujer mujer){
        calzados.add(mujer);
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
                        ", Altura: "+((Mujer) calzado).getAlturaTaco());
                }
            }
    }
    public float valorVenta(){
        System.out.println("Ingrese un codigo: ");
        Leer
    }
}

