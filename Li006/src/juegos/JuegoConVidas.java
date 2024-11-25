package juegos;

import java.io.Serializable;
/**
 * Esta clase es la clase que gestiona las vidas en el juego y el total del record,
 * permitiendo así que las clases hijas puedan eredar sus método y reescribirlos
 * @author Raul Desiderio Moto Buambo
 * */
public abstract class JuegoConVidas implements Serializable {
    private int vidas = 0;
    private int vidasIniciales = 0;
    private int records = 0;

    /**
     * Pre: Recibe el total de vidas de los jugadores.
     * Post:Este método, es el metodo constructor, que inicializa
     *      * el total de vidas
     * @param vidasIniciales es una variable que almacena el total de vidas con el que se inicia en el juego
     * */
    public JuegoConVidas(int vidasIniciales){
        vidas=vidasIniciales;
        this.vidasIniciales = vidasIniciales;
    }
    /**
     * Pre: --
     * Post:Visualiza por pantalla el número de vidas iniciales
     * */
    public  void  muestravidasIniciales(){
        System.out.println(" Número de vidas "+ this.vidasIniciales);
    }
    /**
     * Pre: --
     * Post:Visualiza por pantalla el número de vidas restantes
     * */
    private void muestraVidasRestantes(){
        System.out.println(" Número de vidas "+ this.vidas);
    }
    /**
     * Pre: --
     * Post:Resta menos 1 la vida del jugador y muestra por pantalla (true) si le quedan vidas o (false) si no;
     * */
    public boolean quitaVida(){
        boolean flag;
        if(--vidas > 0){
            System.out.println(" Te quedan "+ this.vidas + " vidas");
            flag =  true;
        }else{
            System.out.println("Juego terminado!! Gracias por participar");
            flag =  false;
        }
        return flag;
    }
    /**
     * Pre: --
     * Post: Utiliza el total de vidas con el que se inicializa el constructor para reasignarlo a las vidas del jugador
     * */
    public void reiniciarPartida(){
        vidas = vidasIniciales;
    }
    /**
     * Pre: --
     * Post:Incrementa el valor del record
     * */
    public void actualizarRecord(){
        if (vidas == records){
            System.out.println("Se ha alcanzado el record!! ");
        }else if(vidas > records){
            records=vidas;
            System.out.println("Se ha batido el record!! ");
        }
    }
    //public abstract boolean juego(String respuesta);
}