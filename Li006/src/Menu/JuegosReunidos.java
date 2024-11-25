package Menu;

import juegos.JuegoAdivinaNumero;
import juegos.JuegoAdivinaNumeroPar;
import Interfaces.Jugable;
import juegos.JuegoAdivinaNuemroImpar;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Esta clase se encarga de guardar todos los distintos juegos en una arraylist de juegos
 * para su posterior uso, proporcionado así, un metodo agregar que da la posibilidad de
 * agregar nuevos juegos al programa.
 * @author Raúl Desideiro Moto Buambo
 */

public class JuegosReunidos implements Serializable {
    private ArrayList<Jugable> juegos = new ArrayList<>();
    public JuegosReunidos(){
        juegos.add(new JuegoAdivinaNumero(5));
        juegos.add(new JuegoAdivinaNumeroPar(5));
        juegos.add(new JuegoAdivinaNuemroImpar(2));
    }
    /**
     * Pre: recibe un objeto de tipo jugable
     * Post: se agrega el nuevo juego a la lista de juegos
     * @param juego es un objeto de tipo jugable
     */
    protected void agregar(Jugable juego){
        juegos.add(juego);
    }
    /**
     * Pre: recibe un entero que es al opción elegida por el usuario.
     * Post: este método recibe el número del juego que se desea jugar desde el menú. en el menú se crea una
     *       variable de tipo Juegoseunidos para poder usar este constuctor
     *@param opcion es la opcion del tipo de juego elegido por el usario
     * */
    public Jugable recuperarJuegos(int opcion){
        return juegos.get(opcion -1);
    }
}