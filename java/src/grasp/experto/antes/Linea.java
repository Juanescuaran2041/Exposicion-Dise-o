package grasp.experto.antes;

public class Linea {
    private Producto producto;
    private int cantidad;
    private double descuento;    // 0.10 = 10%

    public Linea(Producto producto, int cantidad, double descuento) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad()      { return cantidad; }
    public double getDescuento()  { return descuento; }
}
