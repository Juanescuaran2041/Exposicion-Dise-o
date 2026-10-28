package grasp.variacionesprotegidas.despues;

import grasp.variacionesprotegidas.comun.Pedido;

public class DemoDespues {
    public static void ejecutar() {
        System.out.println("DESPUES");
        System.out.println("  con PayPal: " + new Checkout(new PagoPayPal()).pagar(new Pedido(240000)));
        System.out.println("  con Nequi:  " + new Checkout(new PagoNequi()).pagar(new Pedido(240000)));
        System.out.println("  Checkout no cambio ni una linea entre una y otra.");
        System.out.println();
    }
}
