package grasp.creador.antes;

public class LineaPedido {
    private Producto producto;
    private int cantidad;
    private double precioUnitario;

    public LineaPedido(Producto producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Producto getProducto()  { return producto; }
    public int getCantidad()       { return cantidad; }
    public void setCantidad(int c) { this.cantidad = c; }   // setter abierto
    public double subtotal()       { return precioUnitario * cantidad; }
}
