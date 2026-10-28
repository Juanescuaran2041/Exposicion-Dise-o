package grasp.bajoacoplamiento.despues;

import grasp.bajoacoplamiento.comun.Recibo;

public class DemoDespues {
    public static void ejecutar() {
        Venta venta = new Venta("V-100", 250000);
        Caja caja = new Caja();

        Recibo recibo = caja.registrarPago(venta, 250000, "4111-2222");

        System.out.println("DESPUES");
        System.out.println("  " + recibo);
        System.out.println("  estado = " + venta.getEstado());
        System.out.println("  Caja conoce: Venta y Recibo");

        // Ventaja extra: ahora Venta cuida su propia regla.
        try {
            caja.registrarPago(venta, 250000, "4111-2222");
        } catch (IllegalStateException e) {
            System.out.println("  cobrar dos veces -> " + e.getMessage());
        }
        System.out.println();
    }
}
