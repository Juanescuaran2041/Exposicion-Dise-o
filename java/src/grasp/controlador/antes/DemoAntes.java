package grasp.controlador.antes;

import grasp.controlador.comun.Carrito;
import grasp.controlador.comun.Cliente;
import grasp.controlador.comun.Inventario;
import grasp.controlador.comun.PasarelaPago;
import grasp.controlador.comun.RepositorioPedidos;

public class DemoAntes {
    public static void ejecutar() {
        Inventario inventario = new Inventario(10);
        RepositorioPedidos pedidos = new RepositorioPedidos();
        BotonPagar boton = new BotonPagar(inventario, new PasarelaPago(), pedidos);

        System.out.println("ANTES");
        boton.alHacerClic(new Carrito(2, 240000), new Cliente("Ana", "4111"));
        boton.alHacerClic(new Carrito(1, 100000), new Cliente("Luis", "9999"));
        System.out.printf("  pedidos guardados = %d · stock = %d%n",
                pedidos.cantidad(), inventario.getDisponibles());
        System.out.println("  El boton valido, reservo, cobro, guardo y deshizo la reserva.");
        System.out.println();
    }
}
