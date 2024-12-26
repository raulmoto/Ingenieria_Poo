package Gestiones;

import java.util.Date;

public class Coche {
    private int id;
    private String modelo;
    private String anioFabricacion;
    private int preciobase;
    private int stock;
    private String matricula;

    public Coche(int id,String modelo, String anioFabricacion, int preciobase, int stock,String matricula){
        this.id = id;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.preciobase = preciobase;
        this.stock = stock;
        this.matricula = matricula;
    }
    public Coche(){

    }

    public int getId() {
        return id;
    }
    /**
     * Pre: int id del coche
     * Post: actualiza el identificador del coche
     * */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return modelo
     * Pre: ---
     * Post: Retorna el modelo del coche
     * */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo es el modelo del coche
     * Pre: String modelo
     * Post: Actualiza el modelo del coche
     * */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return anioFabricacion
     * Pre: --
     * Post: retorna la fecha de fabricación del coche
     * */
    public String getAnioFabricacion() {
        return anioFabricacion;
    }

    /**
     * @param  anioFabricacion el año de fabricacion del coche
     * Pre: aniofabricacion
     * Post: actualiza la fecha de fabricación del coche
     * */
    public void setAnioFabricacion(String anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    /**
     * @return preciobase
     * Pre: --
     * Post: retorna el precio  del coche
     * */
    public int getPreciobase() {
        return preciobase;
    }

    /**
     * @param  preciobase
     * Pre: preciobase
     * Post: actualiza el precio  del coche
     * */
    public void setPreciobase(int preciobase) {
        this.preciobase = preciobase;
    }

    /**
     * @return stock
     * Pre: --
     * Post: retorna el stock
     * */
    public int getStock() {
        return stock;
    }

    /**
     * @param  stock
     * Pre: int stock
     * Post: actualiza el stock
     * */
    public void setStock(int stock) {

        this.stock = stock;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     *
     * Pre: ---
     * Post: imprime por parnalla todos los coches
     * */
    @Override
    public String toString() {
        return "ID: "+id+"\nModelo: "+modelo+"\nAño fab: "+anioFabricacion+"\nPrecio: "+preciobase+"\nEn Strock: "+stock+" en total.";
    }
}
