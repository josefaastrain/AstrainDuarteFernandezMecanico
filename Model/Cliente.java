package Model;

public class Cliente {
    private int id_Cliente;
    private String nombre;
    private String rut;
    private String telefono;

    public Cliente() {
    }

    public Cliente(int id_Cliente, String nombre, String rut, String telefono) {
        this.id_Cliente = id_Cliente;
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString(){
        return "Cliente " + "\n" +
                " ID: " + id_Cliente + "\n" +
                " Nombre: " + nombre + "\n" +
                " Rut: " + rut + "\n" +
                " Telefono: " + telefono + "\n";


    }


}
