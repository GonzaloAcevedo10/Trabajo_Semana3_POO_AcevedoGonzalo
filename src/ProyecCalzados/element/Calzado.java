package ProyecCalzados.element;


public abstract class Calzado {
    protected Producto producto;
    protected String diaDeVenta;
    protected float medida;

    public Calzado(Producto producto, String diaDeVenta, float medida) {
        this.producto = producto;
        this.diaDeVenta = diaDeVenta;
        this.medida = medida;
    }
    //Metodos
    public float valorVenta(){
        if(this.diaDeVenta.equalsIgnoreCase("Fin de semana")){
            return (float) Math.round(this.producto.getValorBase() + (this.producto.getValorBase()*24/100));
        }
        else {if(this.diaDeVenta.equalsIgnoreCase("Semana")){
            return (float) Math.round(this.producto.getValorBase() - (this.producto.getValorBase()*15/100));
        }
        else {
            System.out.println("El calzado no fue cargado correctamente. Error.");
            return -1;
        }
        }
    }

    public float  impuestoIva(){
        return (float) Math.round(this.producto.getValorBase()*19/100);
    }

    public abstract  float valorAPagar();


    //Getter and Setters

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getDiaDeVenta() {
        return diaDeVenta;
    }

    public void setDiaDeVenta(String diaDeVenta) {
        this.diaDeVenta = diaDeVenta;
    }

    public float getMedida() {
        return medida;
    }

    public void setMedida(float medida) {
        this.medida = medida;
    }
}
