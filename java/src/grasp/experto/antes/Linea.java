package grasp.experto.antes;

/** Línea anémica: tiene los datos pero no sabe calcular su propio subtotal. */
public class Linea {
    private final Producto producto;
    private final int cantidad;
    private final double porcentajeDescuento;   // 0.10 = 10%

    public Linea(Producto producto, int cantidad, double porcentajeDescuento) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Producto getProducto()         { return producto; }
    public int getCantidad()              { return cantidad; }
    public double getPorcentajeDescuento() { return porcentajeDescuento; }
}
