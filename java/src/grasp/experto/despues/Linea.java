package grasp.experto.despues;

public class Linea {
    private Producto producto;
    private int cantidad;

    public Linea(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // El subtotal lo sabe la linea: ella tiene la cantidad.
    public double subtotal() {
        return producto.precioConIva() * cantidad;
    }
}
