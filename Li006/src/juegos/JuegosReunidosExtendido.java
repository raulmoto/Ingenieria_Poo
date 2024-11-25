package juegos;

import EntradaSalida.MyInput;
import Menu.JuegosReunidos;

import java.util.ArrayList;
/**
 * Esta clase, es una apliacion de la clase Juegos reunidos y se encarga de obtener las palbras
 * de una archivo de texto.txt. Tras optener las palabras, crea un objeto de tipo JuegoAhorcad
 * y le pasa un arraylist con esas palabras.
 * El objeto es finalmente usado tras llamar al metodo de la clase padre (agregar) que nos permite
 * agregar el juego Ahorcado.
 * @author Raul Desiderio Moto Buambo
 s*/
public class JuegosReunidosExtendido extends JuegosReunidos {
    /**
     * Pre:--
     * Post: Declara un arraylista llamado palabras. Aciendo uso del metodo llerfichero de la clase MyImput
     *       lee los nombres que hay en el fichero de texto y los guarda en el arraylist, y es ese arraylist
     *       el que se envia a juegoAhorcado
     */
    public JuegosReunidosExtendido(){
        super();
        ArrayList<String> palabrass = new ArrayList<>();
        palabrass = MyInput.leeFichero("palabras.txt");
        JuegoAhorcadoingles juegoAhorcado = new JuegoAhorcadoingles(5, palabrass);
        super.agregar(juegoAhorcado);
    }
}