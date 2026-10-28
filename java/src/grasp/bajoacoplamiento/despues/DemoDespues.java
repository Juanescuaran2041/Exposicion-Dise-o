package grasp.bajoacoplamiento.despues;

import grasp.bajoacoplamiento.comun.Recibo;

public class DemoDespues {
    public static void ejecutar() {
        Venta venta = new Venta("V-001", 240000);
        Caja caja = new Caja();

        Recibo recibo = caja.registrarPago(venta, "4111");

        System.out.println("DESPUES");
        System.out.println("  " + recibo);
        System.out.println("  venta pagada = " + venta.estaPagada());
        System.out.println("  Caja solo conoce Venta y Recibo.");
        System.out.println();
    }
}
