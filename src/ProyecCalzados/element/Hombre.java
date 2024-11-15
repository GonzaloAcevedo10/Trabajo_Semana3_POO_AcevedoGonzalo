package ProyecCalzados.element;

public class Hombre extends Formal{
    public Hombre(Producto producto, String diaDeVenta, float medida, String color) {
        super(producto, diaDeVenta, medida, color);
    }

    @Override
    public float descuento() {
        if(this.color.equalsIgnoreCase("Rojo") || this.color.equalsIgnoreCase("Verde"))
            return (float) Math.round(this.valorVenta()*25/100);
        return 0;
    }
}
