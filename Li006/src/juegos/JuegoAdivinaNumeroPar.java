package juegos;

import Interfaces.Jugable;

public class JuegoAdivinaNumeroPar extends JuegoAdivinaNumero implements Jugable {
    public JuegoAdivinaNumeroPar(int vidas_iniciales) {
        super(vidas_iniciales);
    }
    /**
     * Pre: --
     * Post:Sobreescribimos el metodo validanumero que tenemos en JuegoAdivinaNumero
     * */
    @Override
    public boolean validaNumero(int numero){
        boolean flag = super.validaNumero(numero); //esto no es la invocacion del super tipo, es llamar a un nemtod del super tipo
        if (flag){
            if(numero % 2 == 0){
                System.out.println("El numero es par");
                return true;
            }else System.out.println("El numero no es par");
        }
        return false;
    }
    /**
     * Pre: ---
     * Post: Muestra el nombre del juego en cuestión
     * */
    @Override
    public void muestraNombre() {
        System.out.println("Juego adivina número par");
    }
    /**
     * Pre: ---
     * Post: Muestra información del juego en cuestión.
     * */
    @Override
    public void muestraInfo(){
        System.out.println("El número introducido no es válido. Debe ser un número PAR entre 0 y 10");
    }
    /**
     * Pre: ---
     * Post: retoena un número aleatorio entre 0 y 10
     * */
    @Override
    public int numeroAlleatorio(){
        //genera un numero aleatorio de 0 a 6, de tal forma que al multiplicar por 2 siempre será par
        int numero_AleatorioPar = ((int)(Math.random() * 6) * 2);
        return numero_AleatorioPar;
    }
}