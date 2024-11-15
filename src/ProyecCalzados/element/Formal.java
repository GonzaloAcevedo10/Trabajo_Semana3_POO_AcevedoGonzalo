package ProyecCalzados.element;

public abstract class Formal extends Calzado{
    protected String color;

    public Formal(Producto producto, String diaDeVenta, float medida, String color) {
        super(producto, diaDeVenta, medida);
        this.color = color;
    }
    //metodos

    public float impuestoEspecifico(){
        return (float) Math.round(this.producto.getValorBase()*7.4/100);
    }

    public abstract float descuento();

    @Override
    public float valorAPagar() {
        int stock = producto.getStock();
        if(stock>0){
            stock --;
            producto.setStock(stock);
            float valor = valorVenta() + impuestoIva() + impuestoEspecifico() - descuento();
            return valor;
        }
        else{
            System.out.println("No hay stock disponible");
            return -1;
        }
    }

    //Getter and Setters

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
