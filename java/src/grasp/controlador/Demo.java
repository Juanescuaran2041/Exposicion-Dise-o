package grasp.controlador;

import grasp.controlador.comun.*;
import java.util.List;

/**
 * PATRÓN 3 · CONTROLADOR (Controller)
 *
 * ¿Quién recibe un evento del sistema (clic, petición HTTP, comando)?
 * Un objeto que no pertenece a la interfaz: un controlador de caso de uso
 * (o un objeto del dominio que represente el "sistema" o la sesión).
 *
 * La demo corre el mismo caso de uso dos veces (pago aprobado y rechazado)
 * en la versión sin controlador y en la versión con controlador.
 */
public final class Demo {

    public static void main(String[] args) {
        System.out.println("=== 3. CONTROLADOR ===\n");

        var carrito = new Carrito("C-9", List.of(
                new Item("TEC-1", "Teclado", 100_000, 1),
                new Item("MOU-1", "Mouse",    40_000, 2)));

        var clienteOk   = new Cliente("U-1", "Ana",  "ana@mail.com",  "4111-1111");
        var clienteMalo = new Cliente("U-2", "Beto", "beto@mail.com", "9999-0000");

        // ---------- ANTES: todo dentro del botón ----------
        System.out.println("ANTES  (la UI orquesta: 4 dependencias)");
        var inv1 = new Inventario().conStock("TEC-1", 5).conStock("MOU-1", 5);
        var repo1 = new RepositorioPedidos();
        var boton1 = new grasp.controlador.antes.BotonPagar(
                inv1, new PasarelaPago(), new Notificador(), repo1);

        boton1.alHacerClic(carrito, clienteOk);
        boton1.alHacerClic(carrito, clienteMalo);
        System.out.printf("        stock TEC-1 = %d · pedidos guardados = %d%n%n",
                inv1.disponible("TEC-1"), repo1.cantidad());

        // ---------- DESPUÉS: el botón delega ----------
        System.out.println("DESPUÉS  (la UI delega: 1 dependencia)");
        var inv2 = new Inventario().conStock("TEC-1", 5).conStock("MOU-1", 5);
        var repo2 = new RepositorioPedidos();
        var controlador = new grasp.controlador.despues.ControladorCompra(
                inv2, new PasarelaPago(), new Notificador(), repo2);
        var boton2 = new grasp.controlador.despues.BotonPagar(controlador);

        boton2.alHacerClic(carrito, clienteOk);
        boton2.alHacerClic(carrito, clienteMalo);
        System.out.printf("        stock TEC-1 = %d · pedidos guardados = %d%n", 
                inv2.disponible("TEC-1"), repo2.cantidad());

        // El mismo caso de uso, invocado sin ninguna pantalla:
        var sinUI = controlador.confirmarCompra(carrito, clienteOk);
        System.out.println("        invocado sin UI (como lo haría un API REST): "
                + (sinUI.exito() ? "OK " + sinUI.pedido().id() : sinUI.mensaje()));

        System.out.println("\nDependencias de la UI:  antes 4  ->  después 1\n");
    }

    private Demo() { }
}
