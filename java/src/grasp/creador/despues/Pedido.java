package grasp.creador.despues;

import java.util.ArrayList;

public class Pedido {
    private String id;
    private ArrayList<LineaPedido> lineas = new ArrayList<LineaPedido>();

    public Pedido(String id) {
        this.id = id;
    }

    public String getId() { return id; }

    public void agregar(Producto producto, int cantidad) {
        LineaPedido existente = buscar(producto);

        if (existente != null) {
            existente.sumar(cantidad);
        } else {
            lineas.add(new LineaPedido(producto, cantidad, producto.getPrecio()));
        }
    }

    private LineaPedido buscar(Producto producto) {
        for (LineaPedido linea : lineas) {
            if (linea.getProducto().getSku().equals(producto.getSku())) {
                return linea;
            }
        }
        return null;
    }

    public double total() {
        double total = 0;
        for (LineaPedido linea : lineas) {
            total = total + linea.subtotal();
        }
        return total;
    }

    public ArrayList<LineaPedido> getLineas() {
        return new ArrayList<LineaPedido>(lineas);
    }
}
