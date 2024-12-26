package Taller;

public class Mejoras{
    private int id = 0;
    private String nombre;
    private double porcentaje;

    public Mejoras(int id,String nombre, double porcentaje){
        this.id = id;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }
    public Mejoras(){

    }
    public double calcularCosto(double precioBase) {
        return precioBase * (porcentaje / 100.0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPrecio(int precio) {
        this.porcentaje = precio;
    }

    @Override
    public String toString() {
        return "ID: "+id+"\nNombre: "+nombre+"\nPorcentaje incremento: "+porcentaje;
    }
}
