package grasp.experto.antes;

public class DemoAntes {
    public static void ejecutar() {
        Carrito carrito = new Carrito();
        carrito.agregar(new Linea(new Producto("Teclado", 100000, 0.19), 2));
        carrito.agregar(new Linea(new Producto("Mouse", 40000, 0.19), 1));

        ServicioCaja caja = new ServicioCaja();

        System.out.println("ANTES");
        System.out.printf("  total = $%,.0f%n", caja.calcularTotal(carrito));
        System.out.println("  ServicioCaja tuvo que abrir Carrito, Linea y Producto.");
        System.out.println();
    }
}
