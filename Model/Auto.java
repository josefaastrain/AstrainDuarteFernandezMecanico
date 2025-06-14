package Model;

public class Auto {
  private int id_auto;
		  private String marca;
		  private String modelo;
		  private int anio;
  private String patente;

  public Auto(int id_Auto, String marca, String modelo, int anio, String patente) {
    this.marca = marca;
    this.id_auto = id_Auto;
    this.modelo = modelo;
    this.anio = anio;
    this.patente = patente;
  }
  
  public Auto(){
  }
  
  public int getId_auto(){
    return id_auto;
  }
  public String getMarca(){
    return marca;
  }
  public String getModelo(){
    return modelo;
  }
  public int getAnio(){
    return anio;
  }
  public String getPatente(){
    return patente;
  }
  public void setId_auto(int id_auto) {
        this.id_auto = id_auto;
  }
  public void setMarca(String marca) {
        this.marca = marca;
  }
  public void setModelo(String modelo) {
        this.modelo = modelo;
  }
  public void setAnio(int anio){
    this.anio=anio;
  }
  public void setPatente(String patente) {
        this.patente = patente;
  }
}

  @Override
  public String toString() {
        return String.format("%d | %s | %s | %d | %s", idAuto, marca, modelo, anio, patente);
  }
}
