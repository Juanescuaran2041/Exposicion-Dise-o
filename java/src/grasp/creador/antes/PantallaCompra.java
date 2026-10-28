package grasp.creador.antes;

import java.util.List;

/**
 * PROBLEMA: la pantalla (UI) decide cómo se construye una LineaPedido
 * y además implementa la regla "si el producto ya estaba, suma cantidades".
 *
 * Consecuencias:
 *  - La UI se acopla al constructor de LineaPedido: si cambia la firma,
 *    hay que editar todas las pantallas.
 *  - La regla de agrupar líneas vive en la UI: la API REST, la app móvil
 *    y las pruebas tendrán que copiarla (y alguna la copiará mal).
 *  - Pedido no puede garantizar sus propias invariantes.
 */
public class PantallaCompra {

    public void agregar(Pedido pedido, Producto prod, int cantidad) {
        List<LineaPedido> lineas = pedido.getLineas();

        for (LineaPedido l : lineas) {              // ¿ya estaba el producto?
            if (l.getProducto().equals(prod)) {
                l.setCantidad(l.getCantidad() + cantidad);
                return;
            }
        }
        // la UI elige el precio que se congela en la línea
        lineas.add(new LineaPedido(prod, cantidad, prod.getPrecio()));
    }
}
