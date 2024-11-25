package juegos;

import Interfaces.Jugable;

public class JuegoAdivinaNuemroImpar extends JuegoAdivinaNumero implements Jugable {
    public JuegoAdivinaNuemroImpar(int vidas_iniciales) {
        super(vidas_iniciales);
    }
    /**
     * Pre: recibe un entero
     * Post: comprueba si el nuemro es impar y retoena true o False en caso contrario
     * */
    @Override
    public boolean validaNumero(int a) {
        boolean flag = super.validaNumero(a); //esto no es la invocacion del super tipo, es llamar a un nemtod del super tipo
        if (flag){
            if(a % 2 != 0){
                System.out.println("El numero es impar");
                return true;
            }else System.out.println("El numero es par");
        }
        return false;
    }
    /**
     * Pre: ---
     * Post: Muestra el nombre del juego en cuestión
     * */
    @Override
    public void muestraNombre() {
        System.out.println("Juego adivina número Impar");
    }
    /**
     * Pre: ---
     * Post: Muestra información del juego en cuestión.
     * */
    @Override
    public void muestraInfo(){
        System.out.println("El número introducido no es válido. Debe ser un número IMPAR entre 0 y 10");
    }
    /**
     * Pre: ---
     * Post: genra numero aleatorio imoar de 0 a 10
     * */
    @Override
    public int numeroAlleatorio(){
        int numero_AleatorioImpar = ((int)(Math.random() * 5) * 2 + 1);
        return numero_AleatorioImpar;
    }
}
