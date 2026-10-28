package grasp.controlador.despues;

import grasp.controlador.comun.*;

/**
 * CONTROLADOR: objeto que NO es de la interfaz y que recibe la operación
 * del sistema ("confirmarCompra"). Su trabajo es coordinar: no calcula
 * totales, no cobra, no envía correos; les pide a los expertos que lo hagan.
 *
 * Es un controlador de caso de uso (uno por caso de uso o por grupo
 * de casos de uso relacionados), no un "controlador de todo".
 */
public class ControladorCompra {

    private final Inventario inventario;
    private final PasarelaPago pasarela;
    private final Notificador notificador;
    private final RepositorioPedidos pedidos;

    public ControladorCompra(Inventario inventario, PasarelaPago pasarela,
                             Notificador notificador, RepositorioPedidos pedidos) {
        this.inventario = inventario;
        this.pasarela = pasarela;
        this.notificador = notificador;
        this.pedidos = pedidos;
    }

    /** Operación del sistema: un solo punto de entrada para cualquier UI. */
    public Resultado confirmarCompra(Carrito carrito, Cliente cliente) {
        if (!inventario.reservar(carrito)) {
            return Resultado.error("Sin stock");
        }
        Pedido pedido = Pedido.desde(carrito, cliente);

        if (!pasarela.cobrar(cliente.tarjeta(), pedido.total())) {
            inventario.liberar(carrito);          // la compensación vive aquí
            return Resultado.error("Pago rechazado");
        }
        pedidos.guardar(pedido);
        notificador.compraConfirmada(pedido);
        return Resultado.ok(pedido);
    }
}
