package juegos;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Esta es la clase encargadad de las pruebas unitarias, se encarga de verificar las entradas
 * del usuario y verificar si el caracter introducido se encuentra en el diccionario o no.
 * para ello se definen dos métodos por separado.
 * el metodo noexstecaracter, devuelve Falso al introducirtle un caracter que no existe en el dicionario
 * el método exstecaracter, devuelve True al introducirle un caracter válido que existe ne la plaabra a adivinar
 * @author Raúl Desiderio Moto Buambo
 * */
class JuegoAhorcadoinglesTest {
    /**
     * Pre: --
     * Post: Se le pasa al metodo juege de ahoracado un caracter incorrecto y deberia retornar falso, y ademas
     *       como no tiene las palabras en minuscula tambien dará error
     * @return False, reorna falso ya que el caracter z no se encuentra en la palabra a adivinar
     * */
    @Test
    void noexstecaracter() {
        ArrayList<String>lista = new ArrayList<>();
        lista.add("hello");
        lista.add("apple");
        JuegoAhorcadoingles ahoracdo = new JuegoAhorcadoingles(1,lista);
        ahoracdo.reiniciarPartida();
        Boolean resultado = ahoracdo.juego("z");
        assertFalse(resultado,"el carcter no existe, retorna false");
    }
    /**
     * Pre: --
     * Post: Se le pasa al metodo juege de ahoracado un caracter correcto y deberia retornar falso
     * @return True, retorna verdadero ya que el caracter se enciantra en la palabra a adivinar
     * */
    @Test
    void exstecaracter() {
        ArrayList<String>lista = new ArrayList<>();
        lista.add("apple");
        JuegoAhorcadoingles ahoracdo = new JuegoAhorcadoingles(1,lista);
        ahoracdo.reiniciarPartida();
        Boolean resultado = ahoracdo.juego("a");
        assertTrue(resultado,"el carcter existe, retorna true");
    }
}