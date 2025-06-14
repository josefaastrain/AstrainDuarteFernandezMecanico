package Model;


public class Herramienta {
  private int id_herramienta;
  private String nombre;
  private String tipo;
  private String estado;
  
  public Herramienta(int id_herramienta, String nombre, String tipo, String estado){
    this.id_herramienta=id_herramienta;
    this.nombre=nombre;
    this.tipo=tipo;
    this.estado=estado;
  }
  
  public Herramienta(){
  }
  
  public int getId_herramienta(){
    return id_herramienta;
  }
  public String getNombre(){
    return nombre;
  }
  public String getTipo(){
    return tipo;
  }
  public String getEstado(){
    return estado;
  }
  public void setId_herramienta(int id_herramienta) {
        this.id_herramienta = id_herramienta;
  }
  public void setNombre(String nombre) {
        this.nombre = nombre;
  }
  public void setTipo(String tipo) {
        this.tipo = tipo;
  }
  public void setEstado(String estado) {
        this.estado = estado;
  }
  
  @Override
  public String toString() {
        return String.format("%d | %s | %s | %s", id_herramienta, nombre, tipo, estado);
  }
}
