package grasp.creador.antes;

public class DemoAntes {
    public static void ejecutar() {
        Producto teclado = new Producto("TEC-1", "Teclado", 100000);
        Pedido pedido = new Pedido("P-001");
        PantallaCompra pantalla = new PantallaCompra();

        pantalla.agregar(pedido, teclado, 1);
        pantalla.agregar(pedido, teclado, 2);        // el mismo producto

        System.out.println("ANTES");
        System.out.printf("  lineas = %d · total = $%,.0f%n",
                pedido.getLineas().size(), pedido.total());

        // Como getLineas() entrega la lista real, cualquiera la vacia:
        pedido.getLineas().clear();
        System.out.printf("  alguien llamo getLineas().clear() -> lineas = %d · total = $%,.0f%n",
                pedido.getLineas().size(), pedido.total());
        System.out.println("  Pedido no pudo defender su propio contenido.");
        System.out.println();
    }
}
