package grasp.controlador.despues;

import grasp.controlador.comun.Carrito;
import grasp.controlador.comun.Cliente;
import grasp.controlador.comun.Inventario;
import grasp.controlador.comun.Notificador;
import grasp.controlador.comun.PasarelaPago;
import grasp.controlador.comun.Pedido;
import grasp.controlador.comun.RepositorioPedidos;

public class ControladorCompra {
    private Inventario inventario;
    private PasarelaPago pasarela;
    private Notificador notificador;
    private RepositorioPedidos pedidos;

    public ControladorCompra(Inventario inventario, PasarelaPago pasarela,
                             Notificador notificador, RepositorioPedidos pedidos) {
        this.inventario = inventario;
        this.pasarela = pasarela;
        this.notificador = notificador;
        this.pedidos = pedidos;
    }

    public Resultado confirmarCompra(Carrito carrito, Cliente cliente) {
        if (!inventario.reservar(carrito)) {
            return Resultado.error("Sin stock");
        }
        Pedido pedido = Pedido.desde(carrito, cliente);

        if (!pasarela.cobrar(cliente.getTarjeta(), pedido.getTotal())) {
            inventario.liberar(carrito);          // la correccion vive aqui
            return Resultado.error("Pago rechazado");
        }
        pedidos.guardar(pedido);
        notificador.compraConfirmada(pedido);
        return Resultado.ok(pedido);
    }
}
