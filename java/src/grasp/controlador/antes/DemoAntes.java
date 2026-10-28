package grasp.controlador.antes;

import grasp.controlador.comun.Carrito;
import grasp.controlador.comun.Cliente;
import grasp.controlador.comun.Inventario;
import grasp.controlador.comun.Item;
import grasp.controlador.comun.Notificador;
import grasp.controlador.comun.PasarelaPago;
import grasp.controlador.comun.RepositorioPedidos;

public class DemoAntes {
    public static void ejecutar() {
        Carrito carrito = new Carrito("C-9");
        carrito.agregar(new Item("TEC-1", "Teclado", 100000, 1));
        carrito.agregar(new Item("MOU-1", "Mouse",    40000, 2));

        Cliente ana  = new Cliente("Ana",  "ana@mail.com",  "4111-1111");
        Cliente beto = new Cliente("Beto", "beto@mail.com", "9999-0000");

        Inventario inventario = new Inventario();
        inventario.definirStock("TEC-1", 5);
        inventario.definirStock("MOU-1", 5);
        RepositorioPedidos pedidos = new RepositorioPedidos();

        BotonPagar boton = new BotonPagar(
                inventario, new PasarelaPago(), new Notificador(), pedidos);

        System.out.println("ANTES  (la pantalla coordina: 4 dependencias)");
        boton.alHacerClic(carrito, ana);     // pago aprobado
        boton.alHacerClic(carrito, beto);    // pago rechazado
        System.out.printf("    stock TEC-1 = %d · pedidos guardados = %d%n",
                inventario.disponible("TEC-1"), pedidos.cantidad());
        System.out.println();
    }
}
