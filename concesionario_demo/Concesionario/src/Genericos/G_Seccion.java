package Genericos;

import java.util.ArrayList;
import java.util.List;

public class G_Seccion<T> {
    private int id;            // Identificador único
    private String nombre;        // Nombre de la sección
    private String descripcion;   // Descripción de la sección
    private List<T> elementos;    // Lista de elementos (coches)

    // Constructor
    public G_Seccion(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.elementos = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    //los elementos aqui son la lista de coches
    public List<T> getElementos() {
        return elementos;
    }

    // Métodos básicos
    public void agregarElemento(T elemento) {
        this.elementos.add(elemento);
    }

    public boolean eliminarElemento(T elemento) {
        return this.elementos.remove(elemento);
    }

    public void listarElementos() {
        System.out.println("Elementos en la sección " + nombre + ":");
        for (T elemento : elementos) {
            System.out.println(elemento.toString());
        }
    }

    @Override
    public String toString() {
        return "Sección: " + nombre + " (ID: " + id + ")\n" +
                "Descripción: " + descripcion + "\n" +
                "Cantidad de elementos: " + elementos.size();
    }
}
