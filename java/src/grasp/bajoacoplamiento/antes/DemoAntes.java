package grasp.bajoacoplamiento.antes;

import grasp.bajoacoplamiento.comun.Recibo;

public class DemoAntes {
    public static void ejecutar() {
        Venta venta = new Venta("V-100", 250000);
        Caja caja = new Caja();

        Recibo recibo = caja.registrarPago(venta, 250000, "4111-2222");

        System.out.println("ANTES");
        System.out.println("  " + recibo);
        System.out.println("  estado = " + venta.getEstado());
        System.out.println("  Caja conoce: Venta, Pago, AutorizacionTarjeta, EstadoVenta y Recibo");
        System.out.println();
    }
}
