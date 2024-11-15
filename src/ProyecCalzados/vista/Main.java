package ProyecCalzados.vista;


import ProyecCalzados.element.Deportivo;
import ProyecCalzados.element.Hombre;
import ProyecCalzados.element.Mujer;
import ProyecCalzados.element.Producto;

public class Main {
    public static void main(String[] args) {
        Producto producto = new Producto("5454ABC",10,10000);
        Deportivo deportivo = new Deportivo(producto,"Fin de semana", 44, "Basquet", "Cuero");
        Producto producto1 = new Producto("626262CBA",2,10000);
        Hombre hombre = new Hombre(producto1,"Semana",39.5F,"verde");
        Producto producto2 = new Producto("8081JDF",0,8000);
        Mujer mujer = new Mujer(producto2,"Fin de semana", 37.5F,"verde",11);



        System.out.println("Su stock inicial es "+ deportivo.getProducto().getStock());
        System.out.println("El valor venta es: " + deportivo.valorVenta());
        System.out.println("El valor impuesto material es: " + deportivo.impuestoMaterial());
        System.out.println("El valor IVA es: " + deportivo.impuestoIva());
        System.out.println("El valor total del producto deportivo es "+ deportivo.valorAPagar());
        System.out.println("Su stock es "+ deportivo.getProducto().getStock());
        System.out.println("-----------------------------------------------------------");
        System.out.println("Su stock inicial es "+ hombre.getProducto().getStock());
        System.out.println("El valor venta es: " + hombre.valorVenta());
        System.out.println("El valor impuesto material es: " + hombre.impuestoEspecifico());
        System.out.println("El valor IVA es: " + hombre.impuestoIva());
        System.out.println("El descuento de producto hombre es " + hombre.descuento());
        System.out.println("El valor total del producto hombre es "+ hombre.valorAPagar());
        System.out.println("Su stock final es "+ hombre.getProducto().getStock());
        System.out.println("-----------------------------------------------------------");
        System.out.println("Su stock inicial es "+ mujer.getProducto().getStock());
        System.out.println("El valor venta es: " + mujer.valorVenta());
        System.out.println("El valor impuesto material es: " + mujer.impuestoEspecifico());
        System.out.println("El valor IVA es: " + mujer.impuestoIva());
        System.out.println("El descuento de producto mujer es " + mujer.descuento());
        System.out.println("El valor total del producto mujer es "+ mujer.valorAPagar());
        System.out.println("Su stock final es "+ mujer.getProducto().getStock());

    }
}