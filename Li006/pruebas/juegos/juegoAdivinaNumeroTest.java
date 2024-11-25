package juegos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class juegoAdivinaNumeroTest {
    /**
     * Pre: --
     * Post: Se le pasa al metodo juege de Adivina numero un numero fuera del rango y deberia retornar falso
     * */
    @Test
    void testNumeroMayor() {
        JuegoAdivinaNumero juego = new JuegoAdivinaNumero(5);
        String numeroPensado = "21";
        //llamar al metodo juego
        Boolean resultado = juego.juego(numeroPensado);
        assertFalse(resultado,"El método deberia retornarl falso");
    }
    /**
     * Pre: --
     * Post: Se le pasa al metodo juege de Adivina numero un numero dentro de  rango y deberia retornar falso
     * */
    @Test
    void testNumeroCorrecto() {
        JuegoAdivinaNumero juego = new JuegoAdivinaNumero(5);
        String numeroPensado = "2";
        //llamar al metodo juego
        Boolean resultado = juego.juego(numeroPensado);
        assertTrue(resultado,"El método deberia retornarl true");
    }
}