package grasp.controlador.antes;

import grasp.controlador.comun.*;

/**
 * PROBLEMA: el componente de interfaz es el que ejecuta el caso de uso
 * "confirmar compra". Dentro de un manejador de clic hay reglas de negocio,
 * orquestación y compensación de errores.
 *
 * Consecuencias:
 *  - La UI depende de 5 colaboradores (inventario, pedidos, pasarela,
 *    notificador y el propio Pedido).
 *  - Para probar la lógica hay que instanciar la pantalla.
 *  - Si mañana el caso de uso también se expone por API REST o por consola,
 *    todo esto se copia y las dos copias se desincronizan.
 *  - La UI es la que "deshace" la reserva si falla el pago: lógica crítica
 *    escondida en un botón.
 */
public class BotonPagar {

    private final Inventario inventario;
    private final PasarelaPago pasarela;
    private final Notificador notificador;
    private final RepositorioPedidos pedidos;

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

        if (!pasarela.cobrar(cliente.tarjeta(), pedido.total())) {
            inventario.liberar(carrito);          // la UI compensando...
            mostrarError("Pago rechazado");
            return;
        }
        pedidos.guardar(pedido);
        notificador.compraConfirmada(pedido);
        mostrarRecibo(pedido);
    }

    // --- cosas que sí son de la UI ---
    private void mostrarError(String mensaje) {
        System.out.println("        [pantalla] ERROR: " + mensaje);
    }
    private void mostrarRecibo(Pedido pedido) {
        System.out.printf("        [pantalla] OK: Recibo %s por $%,.0f%n", pedido.id(), pedido.total());
    }
}
