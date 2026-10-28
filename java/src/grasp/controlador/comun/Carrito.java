package grasp.controlador.comun;

import java.util.ArrayList;

public class Carrito {
    private String id;
    private ArrayList<Item> items = new ArrayList<Item>();

    public Carrito(String id) {
        this.id = id;
    }

    public void agregar(Item item) {
        items.add(item);
    }

    public String getId()            { return id; }
    public ArrayList<Item> getItems() { return items; }

    public double total() {
        double total = 0;
        for (Item item : items) {
            total = total + item.subtotal();
        }
        return total;
    }
}
