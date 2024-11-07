package Modelo;

import static java.lang.Math.*;

public abstract class MedioDeAlojamiento {
    private String nombreAlojamiento;
    private int cantidadNoche;
    private float valorBaseNoche;
    private String tipoTemporada;
    private DatosClientes datosClientes;

    public MedioDeAlojamiento(DatosClientes datosClientes, String nombreAlojamiento, int cantidadNoche, float valorBaseNoche, String tipoTemporada) {
        this.nombreAlojamiento = nombreAlojamiento;
        this.datosClientes = datosClientes;
        this.cantidadNoche = cantidadNoche;
        this.valorBaseNoche = valorBaseNoche;
        this.tipoTemporada = tipoTemporada;
    }

    //Metodos
    public float subTotal(){
        return valorBaseNoche*cantidadNoche;
    }
    public float bonoDescuento(){
        float bono = 0;
        if(this.tipoTemporada.equalsIgnoreCase("Baja")){
            return bono = (float) round(subTotal()*25/100);
        }else{
            if (this.tipoTemporada.equalsIgnoreCase("Media")) {
                return bono = (float) round(subTotal() * 12.5 / 100);
            }
            return 0;
        }
    }
    public abstract float valorACancelar();

    //Getter and setters

    public String getNombre() {
        return nombreAlojamiento;
    }

    public void setNombre(String nombre) {
        this.nombreAlojamiento = nombre;
    }

    public int getCantidadNoche() {
        return cantidadNoche;
    }

    public void setCantidadNoche(int cantidadNoche) {
        this.cantidadNoche = cantidadNoche;
    }

    public float getValorBaseNoche() {
        return valorBaseNoche;
    }

    public void setValorBaseNoche(float valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }

    public String getTipoTemporada() {
        return tipoTemporada;
    }

    public void setTipoTemporada(String tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
    }

    public DatosClientes getDatosClientes() {
        return datosClientes;
    }

    public void setDatosClientes(DatosClientes datosClientes) {
        this.datosClientes = datosClientes;
    }
}
