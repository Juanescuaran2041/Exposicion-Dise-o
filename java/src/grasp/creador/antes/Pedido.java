package grasp.creador.antes;

import java.util.ArrayList;

public class Pedido {
    private String id;
    private ArrayList<LineaPedido> lineas = new ArrayList<LineaPedido>();

    public Pedido(String id) {
        this.id = id;
    }

    public String getId() { return id; }

    public ArrayList<LineaPedido> getLineas() {
        return lineas;
    }

    public double total() {
        double total = 0;
        for (LineaPedido linea : lineas) {
            total = total + linea.subtotal();
        }
        return total;
    }
}
