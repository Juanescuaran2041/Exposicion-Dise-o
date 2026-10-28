package grasp.controlador.comun;

import java.util.HashMap;
import java.util.Map;

/** Colaborador: lleva el stock y las reservas. */
public class Inventario {
    private final Map<String, Integer> stock = new HashMap<>();

    public Inventario conStock(String sku, int unidades) {
        stock.put(sku, unidades);
        return this;
    }

    public boolean hayStock(Carrito carrito) {
        return carrito.items().stream()
                .allMatch(i -> stock.getOrDefault(i.sku(), 0) >= i.cantidad());
    }

    public boolean reservar(Carrito carrito) {
        if (!hayStock(carrito)) return false;
        carrito.items().forEach(i -> stock.merge(i.sku(), -i.cantidad(), Integer::sum));
        return true;
    }

    public void liberar(Carrito carrito) {
        carrito.items().forEach(i -> stock.merge(i.sku(), i.cantidad(), Integer::sum));
    }

    public int disponible(String sku) { return stock.getOrDefault(sku, 0); }
}
