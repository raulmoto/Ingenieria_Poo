package principal;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import EntradaSalida.MyInput;
import juegos.*;
import Menu.Menu;
import Menu.JuegosReunidos;
import Menu.MenuExtendido;
import juegos.JuegosReunidosExtendido;
public class Main {
    /**
     * Pre: Recibe como parámetro el nombre de un archivo en formato String.
     * Post: Intenta deserializar un objeto desde el archivo especificado.
     *       Si el archivo existe y contiene un objeto serializado, lo devuelve.
     *       Si ocurre alguna excepción (como que el archivo no exista o no sea válido),
             el método imprime el error y retorna null.
     * @param args
     * @author Raul Desiderio Moto buambo
     * @return El objeto deserializado si tiene éxito, o null si falla.
     */
    public static void main(String[] args) {
        JuegosReunidos jr=MyInput.deserialize("juegos.dat");
        if (jr==null)
            jr= new JuegosReunidosExtendido();
        Menu mp=new MenuExtendido(jr);
        mp.ejecuta();
        MyInput.serialize(jr,"juegos.dat");
    }
}