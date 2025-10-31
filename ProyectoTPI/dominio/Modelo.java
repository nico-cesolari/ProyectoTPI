package ProyectoTPI.dominio;
public class Modelo{
    private String nombre;
    private Marca marca;

    public Modelo(String nombre, Marca marca) {
        this.nombre = nombre;
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public Marca getMarca() {
        return marca;
    }
}