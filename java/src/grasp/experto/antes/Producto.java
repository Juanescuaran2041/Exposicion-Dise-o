package grasp.experto.antes;

/** Producto anémico: solo guarda datos y los expone con getters. */
public class Producto {
    private final String nombre;
    private final double precio;
    private final double iva;      // 0.19 = 19%

    public Producto(String nombre, double precio, double iva) {
        this.nombre = nombre;
        this.precio = precio;
        this.iva = iva;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public double getIva()    { return iva; }
}
