package grasp.creador.antes;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<LineaPedido> lineas = new ArrayList<LineaPedido>();

    // Abre su lista para que otros le metan lineas.
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
