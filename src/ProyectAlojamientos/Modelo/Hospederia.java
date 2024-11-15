package ProyectAlojamientos.Modelo;

public abstract class Hospederia extends MedioDeAlojamiento{
    private int capacidad;
    private boolean esFumador;

    public Hospederia(DatosClientes datosClientes, String nombreAlojamiento, int cantidadNoche, float valorBaseNoche, String tipoTemporada, int capacidad, boolean esFumador) {
        super(datosClientes,nombreAlojamiento,cantidadNoche,valorBaseNoche,tipoTemporada);
        this.capacidad = capacidad;
        this.esFumador = esFumador;
    }

    //Getter and setters
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEsFumador() {
        return esFumador;
    }

    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }
    //Getter and setters
}
