package grasp.creador.despues;

public class LineaPedido {
    private Producto producto;
    private int cantidad;

    LineaPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public double subtotal() {
        return producto.getPrecio() * cantidad;
    }
}
