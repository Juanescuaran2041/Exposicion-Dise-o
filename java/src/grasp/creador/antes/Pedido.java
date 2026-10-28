package grasp.creador.antes;

import java.util.ArrayList;
import java.util.List;

/** Pedido expone su lista interna: cualquiera puede llenarla como quiera. */
public class Pedido {
    private final String id;
    private final List<LineaPedido> lineas = new ArrayList<>();

    public Pedido(String id) { this.id = id; }

    public String getId() { return id; }

    /** PROBLEMA: entrega la lista real, no una copia. */
    public List<LineaPedido> getLineas() { return lineas; }

    public double total() {
        return lineas.stream().mapToDouble(LineaPedido::subtotal).sum();
    }
}
