package grasp.creador.antes;

public class PantallaCompra {

    public void agregar(Pedido pedido, Producto producto, int cantidad) {
        // La pantalla crea la linea y la mete en la lista del pedido.
        LineaPedido linea = new LineaPedido(producto, cantidad);
        pedido.getLineas().add(linea);
    }
}
