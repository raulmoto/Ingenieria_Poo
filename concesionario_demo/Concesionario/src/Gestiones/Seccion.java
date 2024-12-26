package Gestiones;

import Genericos.G_Seccion;
import Interfaces.IGestor;
import java.util.List;

public class Seccion extends G_Seccion<Coche> implements IGestor {

    // Constructor que reutiliza el de G_Seccion
    public Seccion(int id, String nombre, String descripcion) {

        super(id, nombre, descripcion);
    }
    // Lógica para agregar un coche a la lista

    /**
     * pre: Recibe un objeto de tipo coche y el id de la sección
     * Post: Recibe un cche y el identificador de la seccion en la que se desea guardar*/
    @Override
    public void agregar(Object coche) {
        if(coche instanceof Coche){
            super.agregarElemento((Coche)coche);
            System.out.println("Coche agreagdo a la sección "+ this.getNombre());
        }else {
            System.out.println("El objeto no es un coche válido ");
        }
    }

    @Override
    public void elimar(int id) {
        // Lógica para eliminar un coche por ID
        List<Coche> coches = super.getElementos();
        coches.removeIf(coche -> coche.getId() == id);
    }

    @Override
    public void buscar(int id) {
        // Buscar un coche por ID y mostrar detalles
        List<Coche> coches = super.getElementos();
        for (Coche coche : coches) {
            if (coche.getId() == id) {
                System.out.println(coche);
                return;
            }
        }
        System.out.println("Coche no encontrado.");
    }

    @Override
    public void listar() {
        // Listar todos los coches de la sección
        super.listarElementos();
    }
}
