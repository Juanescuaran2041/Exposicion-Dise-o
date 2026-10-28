package grasp.controlador.antes;

import grasp.controlador.comun.Inventario;
import grasp.controlador.comun.PasarelaPago;

public class DemoAntes {
    public static void ejecutar() {
        Inventario inventario = new Inventario(10);
        BotonPagar boton = new BotonPagar(inventario, new PasarelaPago());

        System.out.println("ANTES");
        boton.alHacerClic(2, 240000, "4111");
        boton.alHacerClic(1, 100000, "9999");
        System.out.println("  stock = " + inventario.getDisponibles());
        System.out.println("  El boton reservo, cobro y deshizo la reserva: eso no es pintar.");
        System.out.println();
    }
}
