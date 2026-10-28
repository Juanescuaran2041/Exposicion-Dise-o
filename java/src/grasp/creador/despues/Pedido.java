package grasp.creador.despues;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<LineaPedido> lineas = new ArrayList<LineaPedido>();

    // El pedido contiene las lineas, asi que el pedido las crea.
    public void agregar(Producto producto, int cantidad) {
        lineas.add(new LineaPedido(producto, cantidad));
    }

    public int cantidadDeLineas() {
        return lineas.size();
    }

    public double total() {
        double total = 0;
        for (LineaPedido linea : lineas) {
            total = total + linea.subtotal();
        }
        return total;
    }
}
