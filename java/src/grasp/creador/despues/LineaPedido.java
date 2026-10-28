package grasp.creador.despues;

/**
 * La línea ya no tiene setters públicos: solo Pedido (su creador y dueño)
 * la construye, y ella misma sabe sumar cantidades.
 */
public class LineaPedido {
    private final Producto producto;
    private int cantidad;
    private final double precioUnitarioCongelado;

    /** Package-private: nadie fuera del paquete puede crear líneas sueltas. */
    LineaPedido(Producto producto, int cantidad, double precioUnitarioCongelado) {
        if (cantidad <= 0) throw new IllegalArgumentException("cantidad > 0");
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitarioCongelado = precioUnitarioCongelado;
    }

    void sumar(int extra) { this.cantidad += extra; }

    public Producto producto() { return producto; }
    public int cantidad()      { return cantidad; }
    public double subtotal()   { return precioUnitarioCongelado * cantidad; }

    public String descripcion() {
        return cantidad + " x " + producto.nombre();
    }
}
