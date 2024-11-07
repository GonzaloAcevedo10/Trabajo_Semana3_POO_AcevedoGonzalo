package Modelo;

public class DatosClientes {
    private String nombre;
    private int rut;

    public DatosClientes(String nombre, int rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    //Getter and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }
}
