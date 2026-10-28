package grasp.experto.antes;

public class Producto {
    private String nombre;
    private double precio;
    private double iva;          // 0.19 = 19%

    public Producto(String nombre, double precio, double iva) {
        this.nombre = nombre;
        this.precio = precio;
        this.iva = iva;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public double getIva()    { return iva; }
}
