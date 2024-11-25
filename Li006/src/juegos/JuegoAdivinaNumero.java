package juegos;

import Interfaces.Jugable;

import static java.lang.Integer.parseInt;
import java.util.Random;

public class JuegoAdivinaNumero extends JuegoConVidas implements Jugable {
    /**
     * Pre: Recibe el total de vidas de los jugadores.
     * Post:Este método, es el metodo constructor, que inicializa
     * * el total de vidas
     *
     * @param vidasIniciales
     */
    private int numeroAdivinar;

    public JuegoAdivinaNumero(int vidas_iniciales) {
        super(vidas_iniciales);
    }
    /**
     * Pre:  recibe un numero entero
     * Post:  valida si el numero recibido se encuentra en el rango de entre 0 a 10
     * */
    public boolean validaNumero(int numero) {
        if ((numero < 0) || (numero > 10)) {
            System.out.println("El número introducido no es válido. Debe ser un número entre 0 y 10");
            return false;
        }
        return true;
    }
    /**
     * Pre:  recibe un numero en formato string
     * Post: Este metodo se encarga de la logica del juego de adivinar número y se  asegura que el numero
     *       elegido por el jugador sea igual al número aleatorio  que  se tiene
     * */

    public Boolean juego(String numeroPensado) {
        int numero = Integer.parseInt(numeroPensado);
        //numero aleatorio
        if (validaNumero(numero)){
            if (numero == numeroAdivinar){
                System.out.println("Acertaste!! ");
                super.actualizarRecord();
                return true;
            }else{
                if (numero > numeroAdivinar){
                    System.out.println("el numero es mas pequeño!! ");
                }else{
                    System.out.println("el numero es mas grande!! ");
                }
                return super.quitaVida();
            }
        }
        return false;
    }
    /**
     * Pre:  --
     * Post: Este metodo muestra el nombre del juego en cuestion
     * */
    @Override
    public void muestraNombre() {
        System.out.println("Adivina número!");
    }
    /**
     * Pre:  --
     * Post: Este metodo muestra la informacion del juego elegido
     * */
    @Override
    public void muestraInfo() {
        System.out.println("Consite en adivinar un numero entero antes que se agoten las vidas!");
        super.muestravidasIniciales();
    }
    /**
     * Pre:  numero introducido por el usuario
     * Post: Este metodo que se define desde la interfaz, se encargar de validar la entrada del usario
     * */
    @Override
    public Boolean validaFormato(String entradaUsuario) {
        try{
            int numero = Integer.parseInt(entradaUsuario);
            if(numero < 0){
                System.out.print("No puede introducir un numero negativo ");
                return false;
            }
            return true;
        }catch(NumberFormatException e){
            System.out.println("La entrada no es un número válido.");
            return false;
        }
    }
    /**
     * Pre:  --
     * Post: Este metodo genera un nuemro aleatorio
     * */
    public int numeroAlleatorio(){
        Random randomNumbers = new Random(System.currentTimeMillis());
        return randomNumbers.nextInt(11);
    }
    /**
     * Pre:  --
     * Post: Llamamos al metodo de mi padre, para ello es preciso poner el @override y el mismo metodo
     *      para especificar que, dado a que voy a sobreescribir el metodo de mi padre, debo llamar al mismo metodo
     *      de mi padre y ya luego, dentro hacer lo que necesite. debo llamar dentro al super para ejecutar primero
     *      la accion que propiamente hace el padre.
     * */
    @Override
    public void reiniciarPartida(){
       super.reiniciarPartida();
        numeroAdivinar = numeroAlleatorio();
    }
}