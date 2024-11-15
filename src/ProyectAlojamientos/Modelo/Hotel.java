package ProyectAlojamientos.Modelo;

public class Hotel extends Hospederia{
    private boolean conDesayuno;

    public Hotel(DatosClientes datosClientes, String nombreAlojamiento, int cantidadNoche, float valorBaseNoche, String tipoTemporada, int capacidad, boolean esFumador, boolean conDesayuno) {
        super(datosClientes,nombreAlojamiento, cantidadNoche, valorBaseNoche, tipoTemporada, capacidad, esFumador);
        this.conDesayuno = conDesayuno;
    }

    //Metodos
    public float adicional(){
        float valor = 0;
        if(this.conDesayuno && this.isEsFumador()){
            return valor = (float) Math.round(subTotal()*30/100);
        }
        else return 0;
    }
    //getter and setters
    public boolean isConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

    @Override
    public float valorACancelar() {
        return subTotal()-bonoDescuento()+adicional();
    }
}
