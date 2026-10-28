package grasp.creador.despues;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * CREADOR: Pedido AGREGA (contiene) sus LineaPedido, por lo tanto Pedido
 * es el candidato natural para crearlas.
 *
 * Al asumir la creación, Pedido puede además:
 *  - garantizar que no haya dos líneas del mismo producto,
 *  - congelar el precio del momento,
 *  - devolver su lista como copia inmutable.
 */
public class Pedido {
    private final String id;
    private final List<LineaPedido> lineas = new ArrayList<>();

    public Pedido(String id) { this.id = id; }

    public String id() { return id; }

    /** El único camino para agregar algo a un pedido. */
    public void agregar(Producto producto, int cantidad) {
        buscar(producto).ifPresentOrElse(
                linea -> linea.sumar(cantidad),
                () -> lineas.add(new LineaPedido(producto, cantidad, producto.precio())));
    }

    private Optional<LineaPedido> buscar(Producto producto) {
        return lineas.stream()
                .filter(l -> l.producto().sku().equals(producto.sku()))
                .findFirst();
    }

    public double total() {
        return lineas.stream().mapToDouble(LineaPedido::subtotal).sum();
    }

    /** Copia: se puede leer, no romper. */
    public List<LineaPedido> lineas() { return List.copyOf(lineas); }
}
