package grasp.controlador.comun;

import java.util.List;

public record Pedido(String id, Cliente cliente, List<Item> items) {

    public static Pedido desde(Carrito carrito, Cliente cliente) {
        return new Pedido("PED-" + carrito.id(), cliente, carrito.items());
    }

    public double total() {
        return items.stream().mapToDouble(Item::subtotal).sum();
    }
}
