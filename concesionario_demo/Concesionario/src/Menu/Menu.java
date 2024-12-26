package Menu;

import Concesionario.Concesionario;
import Gestiones.Cliente;
import Gestiones.Coche;
import Seguridad.Admin;
import Seguridad.Login;
import Seguridad.Login.*;
import Taller.Mejoras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author Raul-CDH
 * */
public class Menu {
    private Concesionario concesionario;
    Scanner input = new Scanner(System.in);

    public Menu(Concesionario concesionario){

        this.concesionario = concesionario;
    }

    /**
     * Pre:--
     * Post: Este método se encarga de mostrar al usuario las opciones disponibles en el programa
     * */
    public void mostrarOpcionesDisponibles(){
        int opcion;
        do{
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Ver las Secciones");
            System.out.println("2. Ver coches disponibles");
            System.out.println("3. Comprar Coche");
            System.out.println("4. Acceder como admin");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();
            input.nextLine();
            switch (opcion){
                case 1:
                    concesionario.mostrarSecciones();
                    break;
                case 2:
                    concesionario.mostrarCoches();
                    break;
                case 3:
                    datosClienteoche();
                    break;
                case 4:
                    login();
                    break;

            }
        }while (opcion != 5);
    }
    public void login(){
        String passwd;
        boolean tieneAcceso;
        System.out.println("Introduzca la clave: ");
        passwd = input.nextLine();
        Login l = new Login();
        tieneAcceso = l.controlAcceso(passwd);
        if(!tieneAcceso){
            System.out.println("Clave incorrecta");
        }else {
            System.out.println("Clave correcta");
            Admin admin = new Admin(concesionario);
            admin.mostrarOpcionesDisponibles();
        }
    }
    public void operarConClienteExistente(Cliente cliente, int idCocheAComprar, List<Mejoras> listaDeMejoras) {
        ArrayList<Mejoras> mejorasSeleccionadasPoruser = new ArrayList<>();
        String continuar;
        int opcion;
        boolean seguirEligiendo = true;

        System.out.println("Bienvenido de nuevo, " + cliente.getNombre() + " " + cliente.getApellidos());

        // Proceso de selección de mejoras
        do {
            concesionario.mostrarmejorasDisponibles();
            System.out.print("¿Desea alguna mejora? Indique el número o 'x' para continuar: ");
            continuar = input.nextLine();
            if (continuar.equals("x")) {
                seguirEligiendo = false;
            } else {
                try {
                    // Convertimos la opción a entero
                    opcion = Integer.parseInt(continuar);

                    // Buscar la mejora seleccionada por ID
                    Mejoras mejoraseleccionada = concesionario.buscarMejoraPorId(opcion, listaDeMejoras);
                    if (mejoraseleccionada != null) {
                        mejorasSeleccionadasPoruser.add(mejoraseleccionada); // Agregar la mejora seleccionada
                        System.out.println("Mejora '" + mejoraseleccionada.getNombre() + "' añadida al coche.");
                    } else {
                        System.out.println("Opción no válida, por favor intente nuevamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número válido o 'x' para continuar.");
                }
            }
        } while (seguirEligiendo);

        // Obtener el coche seleccionado
        Coche coche = concesionario.obtenerCochePorId(idCocheAComprar);
        // Finalizar la compra con los datos del cliente existente
        finalizarCompra(
                cliente.getDni(),
                cliente.getApellidos(),
                cliente.getNombre(),
                idCocheAComprar,
                mejorasSeleccionadasPoruser,
                coche.getMatricula(),
                coche.getPreciobase()
        );
    }
    /**
     * Pre:--
     * Post: Este método se centra en capturar los datos del usario que va ha hacer la compra
     * */
    public void datosClienteoche(){
        List<Mejoras> listaDeMejoras = concesionario.obtenerMejorasDisponibles();
        String nombre = "";
        String apellido = "";
        String dni;
        String telefono;
        String anuncios;
        int idCocheAComprar = -1;
        Login login = new Login();
        boolean correcto = true;
        Cliente cliente_buscar;
        do{
            try{
                System.out.print("Introduzca el identificador del coche a comprar : ");
                idCocheAComprar = input.nextInt();
                input.nextLine();
                boolean quedaStock = verificarStock(idCocheAComprar);
                if(!quedaStock){
                    correcto = false;
                }else{
                    correcto = true;
                }
            }catch (Exception e){
                correcto = false;
                input.nextLine();
                System.out.print("Error: debe insertar una opción valida [ "+e.getMessage()+" ]\n");
            }
        }while (!correcto);
        System.out.print("Introduzca su DNI : ");
        dni = input.nextLine();
        //verificamos si el cliente ya existe
        cliente_buscar = recuperarClientePorDni(dni);
        if(cliente_buscar == null){
            System.out.print("Introduzca su nombre : ");
            nombre = input.nextLine();
            System.out.print("Introduzca su apellido : ");
            apellido = input.nextLine();
            System.out.print("Introduzca su telefono : ");
            telefono = input.nextLine();
            System.out.print("quiere recibir anuncios? si[s] no [n]: ");
            anuncios = input.nextLine().toLowerCase();
            boolean recibirAnuncios = anuncios.equals("s");
            Cliente cliente = new Cliente(nombre,apellido,telefono,dni,recibirAnuncios);
            concesionario.registrarClienteAlConcesionario(cliente);//registramso el cliente al concesionario
        }else{
            System.out.println("Cliente ya registrado. Procediendo con el cliente existente.\n");
            operarConClienteExistente(cliente_buscar, idCocheAComprar, listaDeMejoras);
        }

        String continuar;
        ArrayList<Mejoras> mejorasSeleccionadasPoruser = new ArrayList<>();
        int opcion;
        boolean seguirEligiendo = true;

        //validar identificador del coche a comprar
        do {
            concesionario.mostrarmejorasDisponibles();
            //m.toString();
            System.out.print("Desea alguna mejora? indique el número o x para continuar : ");
            continuar = input.nextLine();
            if(continuar.equals("x")){
                seguirEligiendo = false;
            }else{
                try {
                    //convertimos la opcion a entero
                    opcion = Integer.parseInt(continuar);
                    // Buscar la mejora seleccionada por ID
                    Mejoras mejoraseleccionada = concesionario.buscarMejoraPorId(opcion, listaDeMejoras);
                    if (mejoraseleccionada != null) {
                        mejorasSeleccionadasPoruser.add(mejoraseleccionada);  // Agregar la mejora seleccionada
                        System.out.println("Mejora '" + mejoraseleccionada.getNombre() + "' añadida al coche.");
                    } else {
                        System.out.println("Opción no válida, por favor intente nuevamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor ingrese un número válido o 'x' para continuar.");
                }
            }
        }while (seguirEligiendo);
        //mandamos los datos obtenidos
        Coche coche = concesionario.obtenerCochePorId(idCocheAComprar);
        finalizarCompra(dni,nombre,apellido, idCocheAComprar, mejorasSeleccionadasPoruser, coche.getMatricula(), coche.getPreciobase());
    }

    /**
     * @param apellido
     * @param dni
     * @param cocheId
     * @param matricula
     * @param mejoras
     * @param nombre
     * @param precioBase
     * Pre: String dni,String apellido,String nombre, int cocheId, ArrayList<Mejoras> mejoras, String matricula, int precioBase
     * Post:Se encarga de llevar a cabo el registro de la venta
     * */
    public void finalizarCompra(String dni,String apellido,String nombre, int cocheId, ArrayList<Mejoras> mejoras, String matricula, int precioBase){
        concesionario.registrarventas(dni,nombre,apellido,cocheId, mejoras,matricula,precioBase);
    }
    /**
     * @param dni identificador de cliente
     * @return  Cliente
     * Pre: dni
     * Post: recupera los datos de un cliente en particular
     * */
    public Cliente recuperarClientePorDni(String dni) {
        return concesionario.buscarClientePorDni(dni);
    }

    /**
     * @param idCohe identificador de coche
     * Pre: idCoche
     * Post: verifica si hya stock de ese coche
     * */
    public boolean verificarStock(int idCohe){
        Coche coche = concesionario.obtenerCochePorId(idCohe);
        if(coche.getStock() > 0){
            return true;
        }else {
            System.out.println("Lo sentimos, no quedan más de ese modelo en stock\n");
            return false;
        }
    }
}
