package grasp.controlador.despues;

import grasp.controlador.comun.Carrito;
import grasp.controlador.comun.Cliente;
import grasp.controlador.comun.Pedido;

/**
 * SOLUCIÓN: el botón hace lo único que le corresponde: capturar el evento,
 * delegarlo y pintar el resultado. Una sola dependencia: el controlador.
 *
 * La misma lógica la puede invocar un endpoint REST, una app móvil
 * o una prueba automatizada, sin duplicar nada.
 */
public class BotonPagar {

    private final ControladorCompra controlador;

    public BotonPagar(ControladorCompra controlador) { this.controlador = controlador; }

    public void alHacerClic(Carrito carrito, Cliente cliente) {
        Resultado resultado = controlador.confirmarCompra(carrito, cliente);

        if (resultado.exito()) mostrarRecibo(resultado.pedido());
        else                   mostrarError(resultado.mensaje());
    }

    private void mostrarError(String mensaje) {
        System.out.println("        [pantalla] ERROR: " + mensaje);
    }
    private void mostrarRecibo(Pedido pedido) {
        System.out.printf("        [pantalla] OK: Recibo %s por $%,.0f%n", pedido.id(), pedido.total());
    }
}
