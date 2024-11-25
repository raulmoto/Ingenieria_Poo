package juegos;

import Interfaces.Jugable;
import exepciones.JuegoAhorcadoInglesExcepcion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class JuegoAhorcadoingles extends JuegoConVidas implements Jugable {
    /**
     * Pre: Recibe el total de vidas de los jugadores.
     * Post:Este método, es el metodo constructor, que inicializa
     * * el total de vidas
     *
     * @param vidasIniciales
     */

    private ArrayList<Character> palabrasAdivinar = new ArrayList<>(); //palabra a adivinar
    private ArrayList<Character> guiones = new ArrayList<>(); //guarda los caracteres acertados
    ArrayList<String> diccionario = new ArrayList<>(); //diccionario de palabras a adivinar
    /**
     * Pre: Recibe el total de vidas y un arrylist que se utiliza para inicializar el diccionario de palabras
     * Post: Actualiza el diccionario de palabras con la nueva lista que le llega.
     * */
    public JuegoAhorcadoingles(int numeroVidas, ArrayList<String> lista){
        super(numeroVidas);
        this.diccionario = lista;
    }

    /**
     * Pre: Recibe un caracter
     * Post: verifica si el caracter se encuentra en la palabra a adivinar. Si se encuentra, remplaza la posicion de guiones con la letra
     */
    int contador = 0;
    public boolean existeCaracter(char caracter){
        contador = 0;
        for (int i = 0; i< palabrasAdivinar.size(); i++){
            if (palabrasAdivinar.get(i).equals(caracter)){
                //si lo encontramo remplazamos esa posicion en los guiones
                guiones.set(i,caracter);
                contador ++;
            }
        }
        return contador > 0;
    }
    /**
     * Pre: ---
     * Post: muestra por pantalla el contenido del arraylist de guiones
     */
    public void mostrarArrayGuiones(){

        System.out.println(guiones);
    }
    /**
     * Pre:  --
     * Post: se reinicia el juego del ahorcado
     * */

    @Override
    public void reiniciarPartida(){
        super.reiniciarPartida();
        this.palabrasAdivinar.clear();//vaciamos la lista de palabras a adivinas
        this.guiones.clear();
        boolean palabravalida = false;
        do{
            try{
                String palabra_Aleatoria = diccionario.get((int)(Math.random() * diccionario.size()));
                chequeaPalabra(palabra_Aleatoria);
                palabravalida= true;
                palabra_Aleatoria.chars().forEach(letra -> palabrasAdivinar.add((char) letra)); //agregamos la palabra a adivinar caracter a caracter
                palabra_Aleatoria.chars().forEach(guion -> guiones.add('-'));
            }catch(JuegoAhorcadoInglesExcepcion e){
                System.out.println("Palabra no válida: " + e.getMessage());
            }
        }while (!palabravalida); //repetir hasta enontrar una palabra valida en minuscula

    }
    /**
     * Pre:  recibe por parámetro la palabra seleccionada
     *      (String) y comprueba si contiene algún carácter que no sea una letra
     *      minúscula
     * Post: retorna una excepcion
     * */
    private void chequeaPalabra(String palabraSeleccionada) throws JuegoAhorcadoInglesExcepcion{
        if (!palabraSeleccionada.matches("[a-z]+")){
            throw new JuegoAhorcadoInglesExcepcion("La palabra debe contener solo letras minúsculas.");
        }
    }
    /**
     * Pre:  --
     * Post: captura los caracteres que el usuario inserta por terminal.
     *       Desde leer fichero ya pasamos todo a mayuscula, y aqui otra vez cogemos
     *       el parametro y lo convertimos en mayuscula.
     * */
    @Override
    public Boolean juego(String letra) {
        char caracter = letra.charAt(0);
        boolean existe = existeCaracter(caracter);
        boolean puedeSeguir;
        boolean flag = true;
        if(!existe){
            puedeSeguir = super.quitaVida(); //si el caracter no está debo quitarle vida
            if (!puedeSeguir){
                System.out.println("No te quedan vidas !! ");
                flag = false;
            }else{
                flag = true;
            }
        }
        mostrarArrayGuiones();
        if(this.palabrasAdivinar.equals(guiones)){
            System.out.println("Felicidades, lo conseguiste!! ");
            super.actualizarRecord();
            flag = false;
        }
        //comprobar si la palabra ha sido adivinada
        return flag;
    }
    @Override
    public void muestraNombre() {
        System.out.print("Bienvenido al juego del ahorcado ");
    }

    @Override
    public void muestraInfo() {
        System.out.print("Este juego consiste en adivinar la palabra letra a letra!! ");
    }
    /**
     * Pre:  recibe la entrada de usuario
     * Post: Retorna true si la cadena(string) representa una única letra mayuscula y flase lo contrario
     * */
    @Override
    public Boolean validaFormato(String entradaUsuario) {
        int longitud = entradaUsuario.length();
        //verificar si es mayuscula
        boolean esminuscula = entradaUsuario.equals(entradaUsuario.toLowerCase());
        if(longitud == 1 && esminuscula && entradaUsuario.matches("[a-z]+")){
            return true;
        }
        System.out.print("Debe insertar una unica letra y en minúscula!");
        return false;
    }
}