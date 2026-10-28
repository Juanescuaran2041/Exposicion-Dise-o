package grasp.bajoacoplamiento.antes;

import grasp.bajoacoplamiento.comun.Recibo;

public class DemoAntes {
    public static void ejecutar() {
        Venta venta = new Venta("V-001", 240000);
        Caja caja = new Caja();

        Recibo recibo = caja.registrarPago(venta, "4111");

        System.out.println("ANTES");
        System.out.println("  " + recibo);
        System.out.println("  venta pagada = " + venta.estaPagada());
        System.out.println("  Caja conoce Venta, Pago, AutorizacionTarjeta y Recibo.");
        System.out.println();
    }
}
