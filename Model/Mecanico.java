package Model;


public class Mecanico {
  private int id_mecanico;
  private String nombre;
  private String especialidad;
  private int anios_experiencia;
  
  public Mecanico(int id_mecanico, String nombre, String especialidad, int anios_experiencia){
    this.id_mecanico=id_mecanico;
    this.nombre=nombre;
    this.especialidad=especialidad;
    this.anios_experiencia=anios_experiencia;
  }
  
  public Mecanico(){
  }
  
  public int getId_mecanico(){
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
  public void setId_mecanico(int id_mecanico) {
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
  @Override
  public String toString() {
        return String.format("%d | %s | %s | %d", idMecanico, nombre, especialidad, aniosExperiencia);
  }
}
