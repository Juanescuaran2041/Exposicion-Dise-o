package grasp.creador.antes;

public class LineaPedido {
    private final Producto producto;
    private int cantidad;
    private final double precioUnitarioCongelado;

    public LineaPedido(Producto producto, int cantidad, double precioUnitarioCongelado) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitarioCongelado = precioUnitarioCongelado;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad()      { return cantidad; }
    public void setCantidad(int c) { this.cantidad = c; }   // setter abierto
    public double subtotal()      { return precioUnitarioCongelado * cantidad; }
}
