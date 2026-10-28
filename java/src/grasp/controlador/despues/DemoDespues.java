package grasp.controlador.despues;

import grasp.controlador.comun.Inventario;
import grasp.controlador.comun.PasarelaPago;

public class DemoDespues {
    public static void ejecutar() {
        Inventario inventario = new Inventario(10);
        ControladorCompra controlador =
                new ControladorCompra(inventario, new PasarelaPago());
        BotonPagar boton = new BotonPagar(controlador);

        System.out.println("DESPUES");
        boton.alHacerClic(2, 240000, "4111");
        boton.alHacerClic(1, 100000, "9999");
        System.out.println("  stock = " + inventario.getDisponibles());

        // El mismo caso de uso, ahora sin pantalla:
        boolean ok = controlador.confirmarCompra(1, 50000, "4111");
        System.out.println("  llamando al controlador directo: compra ok = " + ok);
        System.out.println();
    }
}
