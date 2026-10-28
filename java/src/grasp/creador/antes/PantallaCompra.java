package grasp.creador.antes;

import java.util.ArrayList;

public class PantallaCompra {
    public void agregar(Pedido pedido, Producto producto, int cantidad) {
        ArrayList<LineaPedido> lineas = pedido.getLineas();

        for (LineaPedido linea : lineas) {                 // ¿ya estaba?
            if (linea.getProducto().getSku().equals(producto.getSku())) {
                linea.setCantidad(linea.getCantidad() + cantidad);
                return;
            }
        }
        // la pantalla elige el precio que se guarda en la linea
        lineas.add(new LineaPedido(producto, cantidad, producto.getPrecio()));
    }
}
