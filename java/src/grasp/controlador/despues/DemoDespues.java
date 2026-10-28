package grasp.controlador.despues;

import grasp.controlador.comun.Carrito;
import grasp.controlador.comun.Cliente;
import grasp.controlador.comun.Inventario;
import grasp.controlador.comun.PasarelaPago;
import grasp.controlador.comun.RepositorioPedidos;

public class DemoDespues {
    public static void ejecutar() {
        Inventario inventario = new Inventario(10);
        RepositorioPedidos pedidos = new RepositorioPedidos();
        ControladorCompra controlador =
                new ControladorCompra(inventario, new PasarelaPago(), pedidos);
        BotonPagar boton = new BotonPagar(controlador);

        System.out.println("DESPUES");
        boton.alHacerClic(new Carrito(2, 240000), new Cliente("Ana", "4111"));
        boton.alHacerClic(new Carrito(1, 100000), new Cliente("Luis", "9999"));
        System.out.printf("  pedidos guardados = %d · stock = %d%n",
                pedidos.cantidad(), inventario.getDisponibles());

        // El caso de uso ya se puede invocar sin pantalla:
        boolean ok = controlador.confirmarCompra(
                new Carrito(1, 50000), new Cliente("Sin pantalla", "4111")) != null;
        System.out.println("  sin pantalla, llamando al controlador: compra ok = " + ok);
        System.out.println();
    }
}
