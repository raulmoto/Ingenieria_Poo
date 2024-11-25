package Menu;
/**
 * Esta clase es una extensión de la clase Menú, que al igual que la anterior,
 * gestiona las diferentes opciones que pueda elegir el usaurio. La diferencia con la
 * anterior es que en esta se gestionan mas opciones que en la anterior.
 * @author Raul Desiderio Moto Buambo
 * */
public class MenuExtendido extends Menu{
    /**
     * Pre: Recibe un objeto de tipo JuegosReuinidos
     * Post: Recibe un objeto de tipo JuegosReuinidos y se los pasa al Menú
     * */
    public MenuExtendido(JuegosReunidos juegosReunidos){
        super(juegosReunidos);
    }
    /**
     * Pre: ---
     * Post: imprime por consola todas las nuevas opciones
     * */
    @Override
    public void mostrarOpciones(){
        System.out.print("A que quiers jugar?: \n1.Adivinar número\n2.Adivinar número par\n3.Adivinar número impar\n4.AHorcado: ");
    }
    /**
     * Pre: Recibe la opción del jugador.
     * Post: retorna true o falso si la opcion selecionada se encuentra entre 1 y 4
     * @param opcion es la opcion que elige el usaruo indicando el tipo de juego
     * @return retorna true o false si la opcion selecionada se encuentra entre 1 y 4
     * */
    @Override
    public boolean chequearOpciones(int opcion){
        return (opcion == 1) || (opcion ==2) ||( opcion == 3)||( opcion == 4);
    }
}