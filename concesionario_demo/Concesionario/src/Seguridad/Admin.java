package Seguridad;

import Concesionario.Concesionario;
import Gestiones.Coche;
import Gestiones.Seccion;
import Menu.Menu;
import Taller.Mejoras;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Admin extends Menu {
    private String clave; // Credenciales del administrador
    private Concesionario con;
    Scanner input = new Scanner(System.in);

    public Admin(Concesionario concesionario) {
        super(concesionario);
        this.clave = "admin";
        this.con = concesionario;
    }

    // Método para registrar coches en el concesionario
    public void registrarCochesEnConcesionario(Concesionario concesionario, List<Coche> coches) {
        concesionario.registroCoches(coches);
        System.out.println("Coches registrados exitosamente por el administrador: ");
    }
    /**
     * Pre:--
     * Post: Este método es el memú del administrador que le permite llevar a cabo acciones que no se le
     *      permiten al cliente.
     * */
    @Override
    public void mostrarOpcionesDisponibles(){
        int opcion;
        do{
            System.out.println("\n--- Menú Admin ---");
            System.out.println("1. listar ventas por id");
            System.out.println("2. Agreagr secciones");
            System.out.println("3. Agregar Coche");
            System.out.println("4. todos los clientes");
            System.out.println("5. Quieren publicidad!");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();
            input.nextLine();
            switch (opcion){
                case 1:
                    String dni;
                    System.out.print("Introduce el dni: ");
                    dni = input.nextLine();
                    con.mostrarVentasDeCliente(dni);
                    break;
                case 2:
                    darDealtaSeccion();
                    break;
                case 3:
                    agregarCoche();
                    break;
                case 4:
                    mostrarTodosLosClientes();
                case 5:
                    clientesQuequierenPublicidad();
                case 6:
                    return;
            }
        }while (opcion != 4);
    }
    /**
     * Pre:--
     * Post: Este método permite agregar nuevos coches a secciones ya exixtentes
     * */
    public void agregarCoche(){
        boolean seguir = false;
        int id;
        String nombre;
        String matricula;
        String fecha_fabricación;
        String modelo;
        int preciobase;
        int stok;
        int seccion;
        String respuesta;
        do{
            System.out.print("indique su ID: ");
            id = input.nextInt();
            input.nextLine();
            System.out.print("Nombre: ");
            nombre = input.nextLine();
            System.out.print("Modelo: ");
            modelo = input.nextLine();
            System.out.print("Matrícula: ");
            matricula = input.nextLine();
            System.out.print("Precio base: ");
            preciobase = input.nextInt();
            input.nextLine();
            System.out.print("año de fabricación: ");
            fecha_fabricación = input.nextLine();
            System.out.print("Stok: ");
            stok = input.nextInt();
            input.nextLine();
            Coche coche = new Coche(1,modelo,fecha_fabricación,preciobase,stok,matricula);
            System.out.print("En qué sección quieres agrearlo?: ");
            seccion = input.nextInt();
            con.agrearCocheASeccion(seccion,coche);
            System.out.print("Seguir agrenado? [n] [s]: ");
            respuesta = input.nextLine();
            if(respuesta.equals("s")){
                seguir = true;
            }else {
                seguir = false;
            }
        }while (seguir);

    }
    /**
     * Pre:--
     * Post: Este método pertenece al administrador y le permite dar de alta un concesionario
     * */
    public void darDealtaSeccion(){
        boolean seguir = false;
        String respuesta;
        int id;
        String descripcion;
        String nombre;
        do{
            System.out.print("indique su ID: ");
            id = input.nextInt();
            input.nextLine();
            System.out.print("Nombre: ");
            nombre = input.nextLine();
            System.out.print("Descripción: ");
            descripcion = input.nextLine();
            Seccion seccion = new Seccion(id,nombre,descripcion);
            con.altaSeccion(seccion);
            System.out.print("Seguir agrenado? [n] [s]: ");
            respuesta = input.nextLine();
            if(respuesta.equals("s")){
                seguir = true;
            }else {
                seguir = false;
            }
        }while (seguir);
    }
    /**
     * Pre: ---
     * Post: Este método llama a un metodo del concesionario qe¡ue muestra todos los clientes registrados
     * */
    public void mostrarTodosLosClientes(){
        con.mostrarTodosLosClientes();
    }
    /**
     * Pre: ---
     * Post: Este método llama a un metodo del concesionario que muestra a los clientes que eligieron
     *      recibir publicidad
     * */
    public void clientesQuequierenPublicidad(){
        con.clientesQueQuierenPublicidad();
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
