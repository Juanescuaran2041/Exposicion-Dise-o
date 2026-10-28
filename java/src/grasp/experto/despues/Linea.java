package grasp.experto.despues;

/**
 * EXPERTO de su subtotal: Linea tiene cantidad y descuento,
 * así que es ella quien sabe cuánto vale.
 * Le pregunta a Producto por el precio en vez de hurgar en sus campos.
 */
public class Linea {
    private final Producto producto;
    private final int cantidad;
    private final double porcentajeDescuento;

    public Linea(Producto producto, int cantidad, double porcentajeDescuento) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String descripcion() {
        return cantidad + " x " + producto.nombre();
    }

    /** Tiene cantidad y descuento -> ella calcula el subtotal. */
    public double subtotal() {
        double bruto = producto.precioConIva() * cantidad;
        return bruto * (1 - porcentajeDescuento);
    }
}
