package grasp.experto.despues;

public class DemoDespues {
    public static void ejecutar() {
        Carrito carrito = new Carrito();
        carrito.agregar(new Linea(new Producto("Teclado", 100000, 0.19), 2));
        carrito.agregar(new Linea(new Producto("Mouse", 40000, 0.19), 1));

        ServicioCaja caja = new ServicioCaja();

        System.out.println("DESPUES");
        System.out.printf("  total = $%,.0f%n", caja.cobrar(carrito));
        System.out.println("  Cada objeto calculo lo suyo. ServicioCaja solo pregunto.");
        System.out.println();
    }
}
