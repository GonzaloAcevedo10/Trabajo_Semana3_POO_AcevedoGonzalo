package Modelo;

public class Carpa extends MedioDeAlojamiento{
    private int cantPersonas;

    public Carpa(DatosClientes datosClientes, String nombreAlojamiento, int cantidadNoche, float valorBaseNoche, String tipoTemporada,int cantPersonas) {
        super(datosClientes,nombreAlojamiento,cantidadNoche,valorBaseNoche,tipoTemporada);
        this.cantPersonas = cantPersonas;
    }

    //Getter and setters
    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    @Override
    public float valorACancelar() {
        return subTotal() - bonoDescuento();
    }
}
