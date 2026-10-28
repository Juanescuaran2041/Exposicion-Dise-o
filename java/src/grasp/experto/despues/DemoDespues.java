package grasp.experto.despues;

public class DemoDespues {
    public static void ejecutar() {
        Producto teclado = new Producto("Teclado", 100000, 0.19);
        Producto mouse   = new Producto("Mouse",    40000, 0.19);

        Carrito carrito = new Carrito();
        carrito.agregar(new Linea(teclado, 2, 0.10));
        carrito.agregar(new Linea(mouse,   1, 0.00));

        ServicioCaja caja = new ServicioCaja();

        System.out.println("DESPUES");
        System.out.printf("  total = $%,.0f%n", caja.cobrar(carrito));

        for (Linea linea : carrito.getLineas()) {
            System.out.printf("  %-14s subtotal = $%,.0f%n",
                    linea.descripcion(), linea.subtotal());
        }
        System.out.println("  Cada objeto calculo lo suyo. ServicioCaja solo pregunto.");
        System.out.println();
    }
}
