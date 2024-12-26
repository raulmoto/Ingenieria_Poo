package Concesionario;

import Gestiones.Cliente;
import Gestiones.Coche;
import Gestiones.Seccion;
import Gestiones.Ventas;
import Interfaces.IPresistencia;
import Taller.Mejoras;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Concesionario implements IPresistencia {
    private String nombre;
    private String direccion;
    private ArrayList<Coche> coches;
    private ArrayList<Cliente> clientes;
    private HashMap<Integer, Seccion> secciones; //Secciones por id
    private ArrayList<Ventas>ventas;
    private List<Mejoras> listaMejoras;

    //constructor principal de la clase
    public Concesionario(){
        this.secciones = new HashMap<>();
        this.coches = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.listaMejoras = new ArrayList<>();
    }
    /**
     * @param s Objeto de tipo sección
     * Pre: Objeto tipo Seccion
     * Post: Utiliza el objeto de seccion para dar de alta una nueva sección
     * */
    public void altaSeccion(Seccion s){
        if(!secciones.containsKey(s.getId())){
            System.out.println("entraaaaaaaaaaamos");
            this.secciones.put(s.getId(),s);
            System.out.println("**Sección "+s.getNombre()+" agregada correctamente** ");
        }else{
            System.out.println("Y existe una seccion con ese ID ");
        }
    }

    /**
     * Pre: ---
     * Post: Agrega mejoas a la lista de mejoras disponibles
     * */
    public void agregarMejoras(){
        Mejoras m = new Mejoras(1,"tapicería de cuero",10.0);
        Mejoras m2 = new Mejoras(2,"GPS",1.0);
        Mejoras m3 = new Mejoras(3,"calefacción en los asientos",50.0);
        Mejoras m4 = new Mejoras(4,"llantas de aleación",50.0);
        listaMejoras.add(m);
        listaMejoras.add(m2);
        listaMejoras.add(m3);
        listaMejoras.add(m4);
    }
    /**
     * Pre: ---
     * Post: Primero comprueba si hay mejoras disponibles y luego las muestra
     * */
    public void mostrarmejorasDisponibles(){
        if(!listaMejoras.isEmpty()){
            for(Mejoras mejora : listaMejoras){
                System.out.println(mejora.getId()+" : "+mejora.getNombre()+" -iva %"+ mejora.getPorcentaje());
            }
        }else{
            System.out.println("No hay mejoras disponibles!!");
        }
    }
    /**
     * @param coches lista de coches
     * Pre: lista de coches
     * Post: recibe lista de coches y lo guarda en el arraylist
     * */
    public void registroCoches(List<Coche> coches){
        this.coches.addAll(coches);
    }


    /**
     * @param id id del coche
     * Pre: id
     * Post: obtiene un coche por su id
     * */
    public Coche obtenerCochePorId(int id) {
        for (Coche coche : coches) {
            if (coche.getId() == id) { // Compara el ID del coche con el proporcionado
                return coche;
            }
        }
        System.out.println("Coche con ID " + id + " no encontrado.");
        return null;
    }

    /**
     * @param idSeccion identificador de la sección
     * @param coche objeto de tipo Coche
     * Pre: Objeto tipo coche e id de sección
     * Post: Conmprueba si la seccion existe, si es el caso guarda el coche en el arry de esa sección.
     * */
    public void agrearCocheASeccion(int idSeccion, Coche coche){
        Seccion seccion = this.secciones.get(idSeccion);
        if(seccion != null){
            seccion.agregar(coche);
        }else{
            System.out.println("No se encontró la sección!! ");
        }
    }
    /**
     * @param id identificador de la seccion
     * Pre: id
     * Post: Este método unicamente da de baja una sección
     * */
    public void bajaSeccion(int id){
        if (secciones.containsKey(id)){
            secciones.remove(id);
        }
    }
    /**
     * Pre: --
     * Post: Este método unicamente muestra todas las secciones que se tiene en el hasmap
     * */
    public void mostrarSecciones(){
        if(!secciones.isEmpty()){
            for (int id : secciones.keySet()) {
                Seccion seccion = secciones.get(id);
                System.out.println("ID: "+id);
                System.out.println("Nombre: "+seccion.getNombre());
                System.out.println("Descripcion: "+seccion.getDescripcion());
                System.out.println("Coches: "+seccion.getElementos());
                System.out.println("-----------------------------------");
            }
        }else{
            System.out.println("No hay secciones disponibles");
        }

    }
    /**
     * @param identificador identificador de una sección
     * Pre: id de una sección
     * Post: Hace una busqueda en el hasmap de seccion filtrando por id
     * */
    public void buscarSeccion(int identificador){
        for (int id: secciones.keySet()){
            Seccion seccion = secciones.get(identificador);
            if(seccion != null){
                System.out.println("ID: "+identificador);
                System.out.println("Nombre: "+seccion.getNombre());
                System.out.println("Nombre: "+seccion.getDescripcion());
                System.out.println("Nombre: "+seccion.getElementos());
                System.out.println("-----------------------------------");
            }
            else {
                System.out.println("Sección no encontrado ");
            }
        }
    }

    /**
     *
     * Pre: id, listaDemejora
     * Post: Se encarga de buscar la mejora segun el id que se le pasa y reornarlo
     * */
    public Mejoras buscarMejoraPorId(int id, List<Mejoras> listaDeMejoras){
        for (Mejoras mejora : listaDeMejoras) {
            if (mejora.getId() == id) {
                return mejora;
            }
        }
        return null;
    }
    /**
     *
     * Pre: --
     * Post: Muestra todos los conches disponibles
     * */
    public void mostrarCoches(){
        if(coches.isEmpty()){
            System.out.println("No hay coches disponibles! ");
            return;
        }
        for (Coche coche: coches){
            System.out.println(coche.toString());
        }
    }
    /**
     * @param dni identificador del cliente
     * @param cocheId identificador del coche
     * @param mejoras arraylist de mejoras realizadas al coche
     * @param matricula matricula del coche
     * @param precioBase precio base del coche
     * Pre: clienteId, cocheId, mejoras, matricula, precioBase
     * Post: Este método se encarga de registrar la venta que se realiza en el momento
     * */
    public void registrarventas(String dni,String nombreCLiente,String apellido, int cocheId, ArrayList<Mejoras> mejoras, String matricula, int precioBase){
        Date fecha = new Date();
        Ventas nuevaVenta = new Ventas(fecha, dni,nombreCLiente,apellido, cocheId, mejoras, matricula, precioBase);
        ventas.add(nuevaVenta);
        nuevaVenta.mostrarDetallesDefactura();
        actualizarStock(cocheId);//actualizamo el stock de ese coche que se ha vendido
    }
    /**
     * @param dni
     * @return null si no se encuentra
     * @return Cliente si se encuentra
     * Pre:dni del cliente
     * Post:Este metodo recupera los datos de un cliente en particular
     * */
    public Cliente buscarClientePorDni(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * @param id identificador de la venta
     * pre: id de venta
     * Post: busca en la lista de ventas registradas la venta qeu coincida con el id y la muestra
     * */
    public void verDatosDeventaPorId(int id){
        boolean encontrado = false;
        for(Ventas venta: ventas){
            if(venta.getId() == id){
                //mostramos las ventas con el metodo que tenemos ya en ventas
                venta.mostrarDetallesDefactura();
                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            System.out.println("No se encontraron registros de venta con el ID: "+id);
        }
    }
    /**
     * @param idCliente identificador de cliente
     * Pre: idCliente
     * Post: Devuelve los datos de ventas de un cliente en particular
     * */
    public void mostrarVentasDeCliente(String idCliente) {
        boolean ventasEncontradas = false;
        for (Ventas venta : ventas) {
            if (venta.getCliente_dni().equals(idCliente)) { // Compara el ID del cliente
                System.out.println("ID Venta: " + venta.getId());
                System.out.println("DNI Cliente: " + venta.getCliente_dni());
                System.out.println("Nom cliente: " + venta.getNombreCLiente());
                System.out.println("Apell Cliente: " + venta.getApellidoCLiente());
                System.out.println("Matricula: " + venta.getMatricula());
                System.out.println("Fecha: " + venta.getFecha());
                System.out.println("Precio Final: $" + venta.getPrecioFinal());
                System.out.println("+------------------------------+\n");
                ventasEncontradas = true;
            }
        }

        if (!ventasEncontradas) {
            System.out.println("No se encontraron ventas para el cliente con ID: " + idCliente);
        }
    }
    /**
     * @param idCoche
     * Pre: id coche
     * Post: actualiza la cantidad que queda de ese tipo de oche
     * */
    public void actualizarStock(int idCoche){
        Coche coche = obtenerCochePorId(idCoche);
        int stock = coche.getStock() -1;
        coche.setStock(stock);
    }
    /**
     *
     * Pre: --
     * Post: Muestra el historico de ventas realizadas
     * */
    public void historicoVentas(){
        for (Ventas ventas : ventas){
            ventas.mostrarDetallesDefactura();
        }
    }
    /**
     * @param cliente
     * pre: Cliente
     * Post: Archiva los datos del cliente en el concesionario
     * */
    public void registrarClienteAlConcesionario(Cliente cliente) {
        if (cliente == null) {
            System.out.println("El cliente no puede ser null.");
            return;
        }
        if (!clientes.contains(cliente)) { // Verifica si ya existe el cliente
            clientes.add(cliente);
            System.out.println("Cliente registrado exitosamente.");
        } else {
            System.out.println("El cliente ya está registrado.");
        }
    }
    /**
     *
     * pre: ---
     * Post: Este método muestra todos los clientes registrados
     * */
    public void mostrarTodosLosClientes(){
        if(clientes.isEmpty()){
            System.out.println("No hay clientes registados.");
            return;
        }
        System.out.println("---Lista de clientes registrados ---");
        for (Cliente cliente : clientes) {
            System.out.println("Nombre: " + cliente.getNombre() + " " + cliente.getApellidos());
            System.out.println("DNI: " + cliente.getDni());
            System.out.println("Teléfono: " + cliente.getTelefono());
            System.out.println("Recibe anuncios: " + (cliente.isRecibirPublicidad()? "Sí" : "No"));
            System.out.println("------------------------------------");
        }
    }
    /**
     * Pre: --
     * Post: Este método muestra todos los clientes que quieren recibir publicidad
     * */
    public void clientesQueQuierenPublicidad(){
        if(clientes.isEmpty()){
            System.out.println("No hay clientes registados.");
            return;
        }
        System.out.println("--- CLIENTES QUE QUIEREN PUBLICIDAD ---");
        for (Cliente cliente : clientes) {
            if(cliente.isRecibirPublicidad()){
                System.out.println("Nombre: " + cliente.getNombre() + " " + cliente.getApellidos());
                System.out.println("DNI: " + cliente.getDni());
                System.out.println("Teléfono: " + cliente.getTelefono());
            }else{
                System.out.println("--- No hay registros ---\n");
            }
            System.out.println("------------------------------------\n");
        }


    }

    /**
     *
     * Pre: --
     * Post: retorna una lista de mejoras
     * */
    public List<Mejoras> obtenerMejorasDisponibles() {
        return listaMejoras;
    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public void cargarDatos() {

    }

}
