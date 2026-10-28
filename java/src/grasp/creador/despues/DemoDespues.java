package grasp.creador.despues;

public class DemoDespues {
    public static void ejecutar() {
        Producto teclado = new Producto("Teclado", 100000);
        Pedido pedido = new Pedido();
        PantallaCompra pantalla = new PantallaCompra();

        pantalla.agregar(pedido, teclado, 2);

        System.out.println("DESPUES");
        System.out.printf("  lineas = %d · total = $%,.0f%n",
                pedido.cantidadDeLineas(), pedido.total());
        System.out.println("  La pantalla solo pidio; el pedido creo su linea.");
        System.out.println();
    }
}
