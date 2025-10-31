package ProyectoTPI.dominio;

public class Vehiculo {
    private Modelo modelo;
    private Marca marca;
    private String patente;
    private String color;

    public Vehiculo (Modelo modelo, Marca marca, String patente, String color){
        this.modelo = modelo;
        this.marca = marca;
        this.patente = patente;
        this.color = color;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Modelo getModelo() {
        return modelo;
    }
    
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }
    
    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}