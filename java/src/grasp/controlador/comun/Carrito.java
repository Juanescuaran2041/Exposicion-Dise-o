package grasp.controlador.comun;

import java.util.List;

public record Carrito(String id, List<Item> items) {
    public double total() {
        return items.stream().mapToDouble(Item::subtotal).sum();
    }
}
