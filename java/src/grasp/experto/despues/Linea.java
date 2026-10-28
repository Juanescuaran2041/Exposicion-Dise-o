package grasp.experto.despues;

public class Linea {
    private Producto producto;
    private int cantidad;
    private double descuento;

    public Linea(Producto producto, int cantidad, double descuento) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public double subtotal() {
        double bruto = producto.precioConIva() * cantidad;
        return bruto - (bruto * descuento);
    }

    public String descripcion() {
        return cantidad + " x " + producto.getNombre();
    }
}
