package grasp.controlador.comun;

import java.util.ArrayList;
import java.util.List;

/** Colaborador: guarda los pedidos (en memoria, para la demo). */
public class RepositorioPedidos {
    private final List<Pedido> guardados = new ArrayList<>();

    public void guardar(Pedido pedido) { guardados.add(pedido); }
    public int cantidad() { return guardados.size(); }
}
