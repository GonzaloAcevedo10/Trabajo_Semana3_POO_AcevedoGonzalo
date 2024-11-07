package Modelo;

public class Cabagna extends Hospederia{
    private boolean chimenea;

    public Cabagna(DatosClientes datosClientes, String nombreAlojamiento, int cantidadNoche, float valorBaseNoche, String tipoTemporada, int capacidad, boolean esFumador, boolean chimenea) {
        super(datosClientes, nombreAlojamiento, cantidadNoche, valorBaseNoche, tipoTemporada, capacidad, esFumador);
        this.chimenea = chimenea;
    }

    //metodos
    public void incrementaValorBase(){
        if(getCapacidad()>5){
            float valorBase = (float) Math.round(getValorBaseNoche()+(getValorBaseNoche()*18/100));
            setValorBaseNoche(valorBase);
        }
    }
    //getter and setters
    public boolean isChimenea() {
        return chimenea;
    }

    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }

    @Override
    public float valorACancelar() {
        return subTotal() - bonoDescuento();
    }
}
