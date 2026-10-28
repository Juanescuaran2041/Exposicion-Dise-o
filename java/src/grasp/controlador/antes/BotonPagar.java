package grasp.controlador.antes;

import grasp.controlador.comun.Carrito;
import grasp.controlador.comun.Cliente;
import grasp.controlador.comun.Inventario;
import grasp.controlador.comun.PasarelaPago;
import grasp.controlador.comun.Pedido;
import grasp.controlador.comun.RepositorioPedidos;

public class BotonPagar {
    private Inventario inventario;
    private PasarelaPago pasarela;
    private RepositorioPedidos pedidos;

    public BotonPagar(Inventario inventario, PasarelaPago pasarela,
                      RepositorioPedidos pedidos) {
        this.inventario = inventario;
        this.pasarela = pasarela;
        this.pedidos = pedidos;
    }

    // La interfaz hace todo el caso de uso.
    public void alHacerClic(Carrito carrito, Cliente cliente) {
        if (!inventario.reservar(carrito)) {
            mostrarError("Sin stock");
            return;
        }
        Pedido pedido = new Pedido(cliente, carrito.getTotal());
        if (!pasarela.cobrar(cliente.getTarjeta(), pedido.getTotal())) {
            inventario.liberar(carrito);          // la interfaz corrigiendo
            mostrarError("Pago rechazado");
            return;
        }
        pedidos.guardar(pedido);
        mostrarRecibo(pedido);
    }

    private void mostrarError(String mensaje) {
        System.out.println("    [pantalla] ERROR: " + mensaje);
    }

    private void mostrarRecibo(Pedido pedido) {
        System.out.printf("    [pantalla] OK: compra de %s por $%,.0f%n",
                pedido.getCliente().getNombre(), pedido.getTotal());
    }
}
