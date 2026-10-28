package grasp.creador.antes;

public class Producto {
    private final String sku;
    private final String nombre;
    private final double precio;

    public Producto(String sku, String nombre, double precio) {
        this.sku = sku;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getSku()    { return sku; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    @Override public boolean equals(Object o) {
        return o instanceof Producto p && p.sku.equals(sku);
    }
    @Override public int hashCode() { return sku.hashCode(); }
}
