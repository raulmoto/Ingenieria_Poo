package EntradaSalida;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.ArrayList;

/**
 * Clase con utilidades para la entrada de datos desde teclado y fichero
 * @author jvalvarez
 */
public class MyInput {
    // Lee una cadena de caracteres desde el teclado

    /**
     * M�todo que permite leer una cadena de caracteres del teclado
     * @return retorna una cadena de caracteres
     */
    public static String readString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in),1);
        String  string="";
        try {
            string = br.readLine(); }
        catch (IOException ex) {
            System.out.println(ex); }
        return string; }
// Lee un dato tipo int  desde el teclado

    /**
     * M�todo que permite leer un n�mero entero de simple precisi�n por teclado
     * @return retorna un n�mero entero de precisi�n simple
     */
    public static int readInt(){
        int numero = 0;
        boolean valido = false;
        do{
            try{
               numero = Integer.parseInt(readString()); //transforma el numero que l usaurio mete po rstring
               valido = true;
            }catch(NumberFormatException c){
                System.out.println("Debe introducir un número válido.");
            }
        }while (!valido);
        return numero;
    }
// Lee un dato tipo double  desde el teclado

    /**
     * M�todo que permite leer n�mero real por teclado.
     * @return retorna un n�mero de doble precisi�n.
     */
    public static double readDouble() {
        return Double.parseDouble(readString()); }

    /**
     * M�todo que permite leer un n�mero entero por teclado.
     * @return retorna un n�mero entero comprendido entre -128 y 127
     */
    public static byte readByte() {
        return Byte.parseByte(readString()); }
// Lee un dato tipo short  desde el teclado

    /**
     * M�todo que permite leer un n�mero entero por teclado.
     * @return retorna un n�mero entero comprendido entre -32768 y 32767
     */
    public static short readShort() {
        return Short.parseShort(readString()); }
// Lee un dato tipo long desde el teclado

    /**
     * M�todo que permite leer un n�mero entero de doble precisi�n por teclado
     * @return retorna un n�mero entero de doble precisi�n.
     */
    public static long readLong() {
        return Long.parseLong(readString()); }

//Lee un dato tipo float desde el teclado

    /**
     * M�todo que permite leer n�mero real por teclado
     * @return retorna un n�mero de precisi�n simple
     */
    public static float readFloat() {
        return Float.parseFloat(readString()); }

    /**
     *
     * @param nombreFichero Es un String que contiene el path del fichero de texto.
     * si el fichero est� en el raiz del proyecto, este String coincide con el nombre
     * del fichero con su extensi�n.
     * @return Un ArrayList de String con todas las palabras contenidas en el fichero de texto.
     */
    public static ArrayList <String> leeFichero(String nombreFichero){
        ArrayList <String> v= new ArrayList <String>();
        File fichero=null;FileReader fr=null;
        BufferedReader br=null;
        try{
            fichero=new File(nombreFichero);
            fr=new FileReader(fichero);br=new BufferedReader(fr);
            String linea;
            while ((linea=br.readLine())!=null){
                v.add(linea);}
        }catch (Exception e){
            e.printStackTrace();}
        finally {
            try {if (null!= fr){fr.close();
                br.close();}
            }catch (Exception e1){
                e1.printStackTrace();}
        }return v;
    }

    public static <A> void serialize(A a, String nombreFichero) {
        System.out.println("Serializando...");
        try {
            FileOutputStream fos = new FileOutputStream(nombreFichero) ;
            ObjectOutputStream oos = new ObjectOutputStream(fos) ;
            oos.writeObject(a) ;
        } catch (Exception e) {
            System.err.println("Problem: "+e) ;
        }
    }

    public static <A> A deserialize(String nombreFichero) {
        System.out.println("DeSerializing...");
        try {
            FileInputStream fis = new FileInputStream(nombreFichero) ;
            ObjectInputStream iis = new ObjectInputStream(fis) ;
            return (A) iis.readObject() ;
        } catch (Exception e) {
            System.err.println("Problem: "+e) ;
        }
        return null ;
    }

}

