package grasp.experto.antes;

public class Linea {
    private Producto producto;
    private int cantidad;

    public Linea(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad()      { return cantidad; }
}
