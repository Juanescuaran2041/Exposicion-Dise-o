package grasp.experto.antes;

public class DemoAntes {
    public static void ejecutar() {
        Producto teclado = new Producto("Teclado", 100000, 0.19);
        Producto mouse   = new Producto("Mouse",    40000, 0.19);

        Carrito carrito = new Carrito();
        carrito.agregar(new Linea(teclado, 2, 0.10));
        carrito.agregar(new Linea(mouse,   1, 0.00));

        ServicioCaja caja = new ServicioCaja();

        System.out.println("ANTES");
        System.out.printf("  total = $%,.0f%n", caja.calcularTotal(carrito));
        System.out.println("  ServicioCaja recorrio Carrito -> Linea -> Producto");
        System.out.println("  y aplico el mismo el descuento y el IVA.");
        System.out.println();
    }
}
