package grasp.controlador.comun;

import java.util.ArrayList;

public class RepositorioPedidos {
    private ArrayList<Pedido> guardados = new ArrayList<Pedido>();

    public void guardar(Pedido pedido) {
        guardados.add(pedido);
    }

    public int cantidad() {
        return guardados.size();
    }
}
