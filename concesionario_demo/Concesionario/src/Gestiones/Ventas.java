package Gestiones;

import Taller.Mejoras;

import java.util.ArrayList;
import java.util.Date;

public class Ventas {
    private int id = 0;
    private Date fecha;
    private String cliente_dni;
    private int coche;
    private ArrayList<Mejoras> mejoras;
    private double precioFinal;
    private String matricula;
    private String nombreCLiente;
    private String apellidoCLiente;


    public Ventas(Date fehca, String cliente_dni,String nombreCLiente,String apellido, int idCoche,ArrayList mejoras, String matricula, int preciobase){
        this.id = +1;
        this.fecha = fecha;
        this.cliente_dni = cliente_dni;
        this.coche = idCoche;
        this.mejoras = mejoras;
        this.precioFinal = calcularPrecioFinal(idCoche,preciobase,mejoras);
        this.matricula = matricula;
        this.nombreCLiente = nombreCLiente;
        this.apellidoCLiente = apellido;
    }

    /**
     * Pre:  idCoche,preciobase
     * Post: Realiza el calculo del precio final de venta. toma de la lista de mejoras, todo lo agregado para sumarlo tambien
     * */
    public double calcularPrecioFinal(int idCoche,double preciobase,ArrayList<Mejoras> mejoras){
        double totalIncremento = mejoras.stream().mapToDouble(mejora -> mejora.calcularCosto(preciobase)).sum();
        return preciobase + totalIncremento;
    }

    /**
     * Pre:  ---
     * Post: Este método se encarga de mostrar lo datos de la transacción realizada
     * */
    public void mostrarDetallesDefactura(){
        System.out.println("=========================================================================:");
        System.out.println("Factura de la venta:");
        System.out.println("ID de venta: " + id);
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente DNI: " + cliente_dni);
        System.out.println("Cliente Nom: " + nombreCLiente);
        System.out.println("Cliente Apell: " + apellidoCLiente);
        System.out.println("Coche ID: " + coche);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Mejoras:");
        for (Mejoras mejora : mejoras) {
            System.out.println(" - " + mejora.getNombre() + " (Porcentaje incremento: " + mejora.getPorcentaje() + ")");
        }
        System.out.println("Precio final: " +" $"+ precioFinal);
        System.out.println("=========================================================================:");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public String getCliente_dni() {
        return cliente_dni;
    }

    public void setCliente_dni(String cliente_dni) {
        this.cliente_dni = cliente_dni;
    }

    public int getCoche() {
        return coche;
    }

    public void setCoche(int coche) {
        this.coche = coche;
    }

    public ArrayList getMejoras() {
        return mejoras;
    }

    public void setMejoras(ArrayList mejoras) {
        this.mejoras = mejoras;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(int precioFinal) {
        this.precioFinal = precioFinal;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreCLiente() {
        return nombreCLiente;
    }

    public void setNombreCLiente(String nombreCLiente) {
        this.nombreCLiente = nombreCLiente;
    }

    public String getApellidoCLiente() {
        return apellidoCLiente;
    }

    public void setApellidoCLiente(String apellidoCLiente) {
        this.apellidoCLiente = apellidoCLiente;
    }
}
