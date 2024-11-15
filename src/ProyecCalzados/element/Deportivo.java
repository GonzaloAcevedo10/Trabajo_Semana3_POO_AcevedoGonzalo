package ProyecCalzados.element;

public class Deportivo extends Calzado{
    private String deporte;
    private String material;

    public Deportivo(Producto producto, String diaDeVenta, float medida,String deporte, String material) {
        super(producto, diaDeVenta, medida);
        this.deporte = deporte;
        this.material = material;
    }
    //Metodos
    public float impuestoMaterial(){
        if(this.material.equalsIgnoreCase("Cuero")) return (float) Math.round(this.producto.getValorBase() * 15 / 100);
        else if (this.material.equalsIgnoreCase("Lona")) return (float) Math.round(this.producto.getValorBase() * 6 / 100);
        else return 0;
    }

    @Override
    public float valorAPagar() {
        int stock = producto.getStock();
        if(stock>0){
            stock --;
            producto.setStock(stock);
            float valor = valorVenta() + impuestoIva() + impuestoMaterial();
            return valor;
        }
        else{
            System.out.println("No hay stock disponible");
            return -1;
        }
    }

    //Getter and Setters

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
