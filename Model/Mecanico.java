package Model;

public class Mecanico {
    private int id_Mecanico;
    private String nombre;
    private String especialidad;
    private int aniosExp;

    public Mecanico() {
    }

    public Mecanico(int id_Mecanico, String nombre, String especialidad, int aniosExp) {
        this.id_Mecanico = id_Mecanico;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.aniosExp = aniosExp;
    }

    public int getId_Mecanico() {
        return id_Mecanico;
    }

    public void setId_Mecanico(int id_Mecanico) {
        this.id_Mecanico = id_Mecanico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAniosExp() {
        return aniosExp;
    }

    public void setAniosExp(int aniosExp) {
        this.aniosExp = aniosExp;
    }

    @Override
    public String toString(){
        return
                " ID: " + id_Mecanico + "|" +
                " Nombre: " + nombre + "|" +
                " Especialidad: " + especialidad + "|" +
                " Años de Experiencia: " + aniosExp + "\n";
    }

}
