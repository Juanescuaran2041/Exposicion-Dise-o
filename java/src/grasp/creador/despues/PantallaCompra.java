package grasp.creador.despues;

/**
 * SOLUCIÓN: la pantalla solo traduce la intención del usuario.
 * No conoce LineaPedido, ni su constructor, ni la regla de agrupamiento.
 */
public class PantallaCompra {

    public void agregar(Pedido pedido, Producto producto, int cantidad) {
        pedido.agregar(producto, cantidad);
    }
}
