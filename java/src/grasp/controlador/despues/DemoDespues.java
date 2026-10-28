package grasp.controlador.despues;

import grasp.controlador.comun.Carrito;
import grasp.controlador.comun.Cliente;
import grasp.controlador.comun.Inventario;
import grasp.controlador.comun.Item;
import grasp.controlador.comun.Notificador;
import grasp.controlador.comun.PasarelaPago;
import grasp.controlador.comun.RepositorioPedidos;

public class DemoDespues {
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

        ControladorCompra controlador = new ControladorCompra(
                inventario, new PasarelaPago(), new Notificador(), pedidos);
        BotonPagar boton = new BotonPagar(controlador);

        System.out.println("DESPUES  (la pantalla delega: 1 dependencia)");
        boton.alHacerClic(carrito, ana);
        boton.alHacerClic(carrito, beto);
        System.out.printf("    stock TEC-1 = %d · pedidos guardados = %d%n",
                inventario.disponible("TEC-1"), pedidos.cantidad());

        // El mismo caso de uso, llamado sin ninguna pantalla:
        Resultado sinPantalla = controlador.confirmarCompra(carrito, ana);
        System.out.println("    llamado sin ninguna pantalla (como lo haria una app movil)"
                + " -> pedido " + sinPantalla.getPedido().getId());
        System.out.println();
    }
}
