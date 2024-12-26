package Seguridad;

public class Login {
    private  String password;
    public Login(){
        this.password = "admin";
    }
    /**
     * Pre: Password es la clave de acceso
     * Post: comprueba si el usario es Administrador, retorna true, en caso contrrio retorna false
     * */
    public boolean controlAcceso(String password){
        if (!password.equals("admin")){
            return false;
        }else {
            return true;
        }
    }

}
