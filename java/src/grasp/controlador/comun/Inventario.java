package grasp.controlador.comun;

import java.util.HashMap;

public class Inventario {
    private HashMap<String, Integer> stock = new HashMap<String, Integer>();

    public void definirStock(String sku, int unidades) {
        stock.put(sku, unidades);
    }

    public boolean hayStock(Carrito carrito) {
        for (Item item : carrito.getItems()) {
            int disponibles = disponible(item.getSku());
            if (disponibles < item.getCantidad()) {
                return false;
            }
        }
        return true;
    }

    public boolean reservar(Carrito carrito) {
        if (!hayStock(carrito)) {
            return false;
        }
        for (Item item : carrito.getItems()) {
            stock.put(item.getSku(), disponible(item.getSku()) - item.getCantidad());
        }
        return true;
    }

    public void liberar(Carrito carrito) {
        for (Item item : carrito.getItems()) {
            stock.put(item.getSku(), disponible(item.getSku()) + item.getCantidad());
        }
    }

    public int disponible(String sku) {
        if (stock.containsKey(sku)) {
            return stock.get(sku);
        }
        return 0;
    }
}
