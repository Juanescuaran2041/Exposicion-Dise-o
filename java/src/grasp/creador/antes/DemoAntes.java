package grasp.creador.antes;

public class DemoAntes {
    public static void ejecutar() {
        Producto teclado = new Producto("Teclado", 100000);
        Pedido pedido = new Pedido();
        PantallaCompra pantalla = new PantallaCompra();

        pantalla.agregar(pedido, teclado, 2);

        System.out.println("ANTES");
        System.out.printf("  lineas = %d · total = $%,.0f%n",
                pedido.getLineas().size(), pedido.total());
        System.out.println("  La pantalla hizo new LineaPedido y toco la lista del pedido.");
        System.out.println();
    }
}
