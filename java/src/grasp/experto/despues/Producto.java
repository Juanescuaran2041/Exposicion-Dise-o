package grasp.experto.despues;

public class Producto {
    private String nombre;
    private double precio;
    private double iva;

    public Producto(String nombre, double precio, double iva) {
        this.nombre = nombre;
        this.precio = precio;
        this.iva = iva;
    }

    public String getNombre() { return nombre; }

    public double precioConIva() {
        return precio * (1 + iva);
    }
}
