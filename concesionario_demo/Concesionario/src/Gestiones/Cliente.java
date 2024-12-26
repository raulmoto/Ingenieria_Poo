package Gestiones;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellidos;
    private String telefono;
    private boolean recibirPublicidad;

    public Cliente(String nombre,String apellidos,String telefono,String dni,boolean recibirPublicidad){
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.recibirPublicidad = recibirPublicidad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isRecibirPublicidad() {
        return recibirPublicidad;
    }

    public void setRecibirPublicidad(boolean recibirPublicidad) {
        this.recibirPublicidad = recibirPublicidad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
