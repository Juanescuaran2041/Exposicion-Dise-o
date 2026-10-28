package grasp.controlador.despues;

import grasp.controlador.comun.Carrito;
import grasp.controlador.comun.Cliente;
import grasp.controlador.comun.Pedido;

public class BotonPagar {
    private ControladorCompra controlador;

    public BotonPagar(ControladorCompra controlador) {
        this.controlador = controlador;
    }

    public void alHacerClic(Carrito carrito, Cliente cliente) {
        Resultado resultado = controlador.confirmarCompra(carrito, cliente);

        if (resultado.isExito()) {
            mostrarRecibo(resultado.getPedido());
        } else {
            mostrarError(resultado.getMensaje());
        }
    }

    private void mostrarError(String mensaje) {
        System.out.println("    [pantalla] ERROR: " + mensaje);
    }

    private void mostrarRecibo(Pedido pedido) {
        System.out.printf("    [pantalla] OK: Recibo %s por $%,.0f%n",
                pedido.getId(), pedido.getTotal());
    }
}
