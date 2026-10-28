package grasp.controlador.despues;

import grasp.controlador.comun.Pedido;

public class BotonPagar {
    private ControladorCompra controlador;

    public BotonPagar(ControladorCompra controlador) {
        this.controlador = controlador;
    }

    // La interfaz delega y pinta.
    public void alHacerClic(int unidades, double total, String tarjeta) {
        Pedido pedido = controlador.confirmarCompra(unidades, total, tarjeta);
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
        System.out.printf("    [pantalla] OK: compra por $%,.0f%n", pedido.getTotal());
    }
}
