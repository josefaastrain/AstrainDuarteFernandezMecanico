public class Mecanico {
  private String id_mecanico;
  private String nombre;
  private String especialidad;
  private int anios_experiencia;
  
  public Mecanico(String id_mecanico, String nombre, String especialidad, int anios_experiencia){
    this.id_mecanico=id_mecanico;
    this.nombre=nombre;
    this.especialidad=especialidad;
    this.anios_experiencia=anios_experiencia;
  }
  
  public Mecanico(){
  }
  
  public String getId_mecanico(){
    return id_mecanico;
  }
  public String getNombre(){
    return nombre;
  }
  public String getEspecialidad(){
    return especialidad;
  }
  public int getAnios_experiencia(){
    return anios_experiencia;
  }
  public void setId_mecanico(String id_mecanico) {
        this.id_mecanico = id_mecanico;
  }
  public void setNombre(String nombre) {
        this.nombre = nombre;
  }
  public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
  }
  public void setAnios_experiencia(int anios_experiencia) {
        this.anios_experiencia = anios_experiencia;
  }
}
