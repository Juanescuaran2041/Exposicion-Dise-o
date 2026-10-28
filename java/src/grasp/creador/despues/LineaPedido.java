package grasp.creador.despues;

public class LineaPedido {
    private Producto producto;
    private int cantidad;
    private double precioUnitario;

    LineaPedido(Producto producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    void sumar(int extra) {
        this.cantidad = this.cantidad + extra;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad()      { return cantidad; }
    public double subtotal()      { return precioUnitario * cantidad; }

    public String descripcion() {
        return cantidad + " x " + producto.getNombre();
    }
}
