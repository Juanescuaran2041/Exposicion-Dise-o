package grasp.controlador.despues;

import grasp.controlador.comun.Inventario;
import grasp.controlador.comun.PasarelaPago;
import grasp.controlador.comun.Pedido;
import grasp.controlador.comun.RepositorioPedidos;

public class ControladorCompra {
    private Inventario inventario;
    private PasarelaPago pasarela;
    private RepositorioPedidos pedidos;

    public ControladorCompra(Inventario inventario, PasarelaPago pasarela,
                             RepositorioPedidos pedidos) {
        this.inventario = inventario;
        this.pasarela = pasarela;
        this.pedidos = pedidos;
    }

    // Devuelve el pedido, o null si la compra no se pudo completar.
    public Pedido confirmarCompra(int unidades, double total, String tarjeta) {
        if (!inventario.reservar(unidades)) {
            return null;
        }
        Pedido pedido = new Pedido(total);
        if (!pasarela.cobrar(tarjeta, pedido.getTotal())) {
            inventario.liberar(unidades);         // la correccion vive aqui
            return null;
        }
        pedidos.guardar(pedido);
        return pedido;
    }
}
