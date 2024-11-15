package ProyecCalzados.element;

public class Mujer extends Formal{
    private float alturaTaco;

    public Mujer(Producto producto, String diaDeVenta, float medida, String color, float alturaTaco) {
        super(producto, diaDeVenta, medida, color);
        this.alturaTaco = alturaTaco;
    }


    public float getAlturaTaco() {
        return alturaTaco;
    }

    public void setAlturaTaco(float alturaTaco) {
        this.alturaTaco = alturaTaco;
    }

    @Override
    public float descuento() {
        if(this.alturaTaco>10) return (float) Math.round(producto.getValorBase()*20/100);
        return 0;
    }
}
