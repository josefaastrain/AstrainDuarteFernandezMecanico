public class Herramienta {
  private String id_herramienta;
  private String nombre;
  private String tipo;
  private String estado;
  
  public Herramienta(String id_herramienta, String nombre, String tipo, String estado){
    this.id_herramienta=id_herramienta;
    this.nombre=nombre;
    this.tipo=tipo;
    this.estado=estado;
  }
  
  public Herramienta(){
  }
  
  public String getId_herramienta(){
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
  public void setId_herramienta(String id_herramienta) {
        this.id_herramienta = id_herramienta;
  }
  public void setNombre(String nombre) {
        this.nombre = nombre;
  }
  public void setTipo(String tipo) {
        this.tipo = tipo;
  }
  public void setEsrado(String estado) {
        this.estado = estado;
  }
}
