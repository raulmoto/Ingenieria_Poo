package Menu;

import EntradaSalida.MyInput;
import juegos.JuegoAhorcadoingles;
import Interfaces.Jugable;

/**
 * Esta clase, se encarga de gestionar las entradas del usuario, devolviedoles así
 * los juegos correspondientes según sea la opción selecionada.
 * @author Raúl Desiderio Moto Buambo
 */
public class Menu {
    private JuegosReunidos juegos;

    public Menu(JuegosReunidos jr){
        juegos = jr;
    }
    /**
     * Pre--
     * post: mostramos las opciones*/
    public void mostrarOpciones(){
        System.out.print("A que quiers jugar?: \n1.Adivinar número\n2.Adivinar número par\n3.Adivinar número impar\n: ");
    }
    public boolean chequearOpciones(int opcion){
        return (opcion == 1) || (opcion ==2) ||( opcion == 3);
    }

    /**
     * Pre: recibe un juego y muestra el nombre del juego y alguna informacion de el juego
     * Post: --
     * @param j es un objeto de yipo jugable
     * */
    public void jugar(Jugable j){ //recibe un juego y de ese juego solo se ppdrá acceder a ciertos metodos
        String numeroPensado = "";
        j.muestraNombre();
        j.muestraInfo();
        j.reiniciarPartida(); // reiniciamos el número aleatorio
        do{
            //mostrarOpciones();
            if (j instanceof JuegoAhorcadoingles) {
                System.out.println("\n¡Estás jugando al ahorcado! Intenta adivinar la palabra: ");
                ((JuegoAhorcadoingles) j).mostrarArrayGuiones();
            } else {
                System.out.println("\nIntenta adivinar el número: ");
            }
            System.out.println("\nIntentalo!! : ");
            //se valida el dato que introduce el usario
            do{
                numeroPensado = MyInput.readString();
            }while (!j.validaFormato(numeroPensado));
        }while (j.juego(numeroPensado));
    }
    /**
     * Pre:--
     * Post: Este método muestra las opciones a elegir al usuario o jugador. Cuando se elige una opción
     *      se manda a checar y ese metodo nos devueve un true o false.
     *      retornamos la opcion.
     * @return devuelve la opcion selecionada
     * */
    public int  eligeOpcion(){
        int opcion;
        boolean flag = false;
        do{
            mostrarOpciones();
            opcion = MyInput.readInt();
            if (chequearOpciones(opcion)){
                flag = false;
            }else{
                System.out.print("El número introduccido se sale de rango ");
                flag = true;
            }
        }while (flag);
        return opcion;
    }
    /**
     * Pre:--
     * Post: Se llama a el metodo juega y se le pasa el juego elegido por el usuario, gracias a la opcion obtenidda de
     *      eligeopcion
     *      .llama al constructor de JuegosReunidos y utilizando su constuctor, se le pasa una la opcion del jugador
     * */
    public void ejecuta(){
        String car;
        do{
            jugar(juegos.recuperarJuegos(eligeOpcion())); //recupera el juego de la lista de juegos y lo pasa a jugar
            System.out.print("Quieres seguir jugando?. EN caso afirmativo introduce ok o cualquier otro cacarcter en caso contrario :");
            car = MyInput.readString().toLowerCase();
        }while (car.equals("ok"));
        System.out.print("Gracias por jugar con nosotros !! ");
    }
}