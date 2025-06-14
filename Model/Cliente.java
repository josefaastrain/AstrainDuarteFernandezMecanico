package Model;


public class Cliente {
  private int id_cliente;
  private String nombre;
  private String rut;
  private String telefono;
  
  public Cliente(int id_cliente, String nombre, String rut, String telefono){
    this.id_cliente=id_cliente;
    this.nombre=nombre;
    this.rut=rut;
    this.telefono=telefono;
  }
  
  public Cliente(){
  }
  
  public int getId_cliente(){
    return id_cliente;
  }
  public String getNombre(){
    return nombre;
  }
  public String getRut(){
    return rut;
  }
  public String getTelefono(){
    return telefono;
  }
  public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
  }
  public void setNombre(String nombre) {
        this.nombre = nombre;
  }
  public void setRut(String rut) {
        this.rut = rut;
  }
  public void setTelefono(String telefono) {
        this.telefono = telefono;
  }  

  @Override
  public String toString() {
        return String.format("%d | %s | %s | %s", idCliente, nombre, rut, telefono);
  }
}
