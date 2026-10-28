package grasp.creador.despues;

public class PantallaCompra {
    public void agregar(Pedido pedido, Producto producto, int cantidad) {
        pedido.agregar(producto, cantidad);
    }
}
