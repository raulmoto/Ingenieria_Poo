import Concesionario.Concesionario;
import Gestiones.Coche;
import Gestiones.Seccion;
import Menu.Menu;
import Taller.Mejoras;
import Seguridad.Admin;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Concesionario concesionario = new Concesionario();
        Seccion s1 = new Seccion(1,"coche rojo","para el dia");
        Seccion s2 = new Seccion(2,"coche azul","para el dia");
        concesionario.altaSeccion(s1);
        concesionario.altaSeccion(s2);
        Coche c1 = new Coche(1,"Toyota", "12/10/2000", 12223, 5, "abcdef");
        Coche c2 = new Coche(2,"Ferrari", "12/10/2000", 12223, 5, "ghijkl");
        concesionario.registroCoches(List.of(c1,c2));
        concesionario.agregarMejoras();
        Menu menu = new Menu(concesionario);
        menu.mostrarOpcionesDisponibles();
    }
}