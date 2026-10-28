package grasp.controlador.despues;

import grasp.controlador.comun.Carrito;
import grasp.controlador.comun.Cliente;
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
    public Pedido confirmarCompra(Carrito carrito, Cliente cliente) {
        if (!inventario.reservar(carrito)) {
            return null;
        }
        Pedido pedido = new Pedido(cliente, carrito.getTotal());
        if (!pasarela.cobrar(cliente.getTarjeta(), pedido.getTotal())) {
            inventario.liberar(carrito);          // la correccion vive aqui
            return null;
        }
        pedidos.guardar(pedido);
        return pedido;
    }
}
