package grasp.controlador.comun;

public class Notificador {
    public void compraConfirmada(Pedido pedido) {
        System.out.printf("    [correo a %s] Pedido %s confirmado por $%,.0f%n",
                pedido.getCliente().getEmail(), pedido.getId(), pedido.getTotal());
    }
}
