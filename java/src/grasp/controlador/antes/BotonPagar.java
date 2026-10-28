package grasp.controlador.antes;

import grasp.controlador.comun.Carrito;
import grasp.controlador.comun.Cliente;
import grasp.controlador.comun.Inventario;
import grasp.controlador.comun.Notificador;
import grasp.controlador.comun.PasarelaPago;
import grasp.controlador.comun.Pedido;
import grasp.controlador.comun.RepositorioPedidos;

public class BotonPagar {
    private Inventario inventario;
    private PasarelaPago pasarela;
    private Notificador notificador;
    private RepositorioPedidos pedidos;

    public BotonPagar(Inventario inventario, PasarelaPago pasarela,
                      Notificador notificador, RepositorioPedidos pedidos) {
        this.inventario = inventario;
        this.pasarela = pasarela;
        this.notificador = notificador;
        this.pedidos = pedidos;
    }

    public void alHacerClic(Carrito carrito, Cliente cliente) {
        if (!inventario.hayStock(carrito)) {
            mostrarError("Sin stock");
            return;
        }
        inventario.reservar(carrito);

        Pedido pedido = Pedido.desde(carrito, cliente);

        if (!pasarela.cobrar(cliente.getTarjeta(), pedido.getTotal())) {
            inventario.liberar(carrito);          // la interfaz corrigiendo
            mostrarError("Pago rechazado");
            return;
        }
        pedidos.guardar(pedido);
        notificador.compraConfirmada(pedido);
        mostrarRecibo(pedido);
    }

    // --- esto si es trabajo de la interfaz ---
    private void mostrarError(String mensaje) {
        System.out.println("    [pantalla] ERROR: " + mensaje);
    }

    private void mostrarRecibo(Pedido pedido) {
        System.out.printf("    [pantalla] OK: Recibo %s por $%,.0f%n",
                pedido.getId(), pedido.getTotal());
    }
}
