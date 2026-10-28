package grasp.controlador.comun;

/** Colaborador: avisa al cliente. */
public class Notificador {
    public void compraConfirmada(Pedido pedido) {
        System.out.printf("        [correo a %s] Pedido %s confirmado por $%,.0f%n",
                pedido.cliente().email(), pedido.id(), pedido.total());
    }
}
