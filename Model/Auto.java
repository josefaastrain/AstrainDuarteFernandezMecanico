package Model;

public class Auto {
    private int id_Auto;
    private String marca;
    private String modelo;
    private int anio;
    private String patente;

    public Auto() {
    }

    public Auto(int id_Auto, String marca, String modelo, int anio, String patente) {
        this.marca = marca;
        this.id_Auto = id_Auto;
        this.modelo = modelo;
        this.anio = anio;
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getId_Auto() {
        return id_Auto;
    }

    public void setId_Auto(int id_Auto) {
        this.id_Auto = id_Auto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString(){
        return
                " ID: " + id_Auto + "|" +
                " Marca: " + marca + "|" +
                " Modelo: " + modelo + "|" +
                " Año: " + anio + "|" +
                " Patente: " + patente + "\n" ;
    }

}
