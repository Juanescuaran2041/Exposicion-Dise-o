package grasp.creador.despues;

public class DemoDespues {
    public static void ejecutar() {
        Producto teclado = new Producto("TEC-1", "Teclado", 100000);
        Pedido pedido = new Pedido("P-001");
        PantallaCompra pantalla = new PantallaCompra();

        pantalla.agregar(pedido, teclado, 1);
        pantalla.agregar(pedido, teclado, 2);        // se agrupa solo

        System.out.println("DESPUES");
        System.out.printf("  lineas = %d · total = $%,.0f%n",
                pedido.getLineas().size(), pedido.total());

        for (LineaPedido linea : pedido.getLineas()) {
            System.out.println("  " + linea.descripcion());
        }

        // getLineas() entrega una copia: vaciarla no afecta al pedido
        pedido.getLineas().clear();
        System.out.printf("  alguien llamo getLineas().clear() -> lineas = %d · total = $%,.0f%n",
                pedido.getLineas().size(), pedido.total());
        System.out.println("  el pedido siguio intacto.");
        System.out.println();
    }
}
