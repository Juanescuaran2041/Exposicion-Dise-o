package grasp.controlador.despues;

import grasp.controlador.comun.Carrito;
import grasp.controlador.comun.Cliente;
import grasp.controlador.comun.Pedido;

public class BotonPagar {
    private ControladorCompra controlador;

    public BotonPagar(ControladorCompra controlador) {
        this.controlador = controlador;
    }

    // La interfaz delega y pinta.
    public void alHacerClic(Carrito carrito, Cliente cliente) {
        Pedido pedido = controlador.confirmarCompra(carrito, cliente);
        if (pedido != null) {
            mostrarRecibo(pedido);
        } else {
            mostrarError("No se pudo completar la compra");
        }
    }

    private void mostrarError(String mensaje) {
        System.out.println("    [pantalla] ERROR: " + mensaje);
    }

    private void mostrarRecibo(Pedido pedido) {
        System.out.printf("    [pantalla] OK: compra de %s por $%,.0f%n",
                pedido.getCliente().getNombre(), pedido.getTotal());
    }
}
