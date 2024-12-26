package Interfaces;

public interface IGestor <T> {
    //cada clase podrá modificr este metodo para agreagr cualquier tipo de dato
    void agregar(T coche);
    //cada clase podrá modificr este metodo para eliminar cualquier tipo de dato por su id
    void elimar(int id);
    //cada clase podrá modificr este metodo para recuperar cualquier tipo de dato por su id
    void buscar(int id);
    //cada clase podrá modificr este metodo para listar cualquier
    void listar();
}
