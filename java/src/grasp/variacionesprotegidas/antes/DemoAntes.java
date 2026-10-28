package grasp.variacionesprotegidas.antes;

import grasp.variacionesprotegidas.comun.Pedido;

public class DemoAntes {
    public static void ejecutar() {
        Pedido pedido = new Pedido("PED-77", 350000);
        Checkout checkout = new Checkout();

        System.out.println("ANTES");
        System.out.println("  " + checkout.pagar(pedido));
        System.out.println("  cobro en USD porque PayPal se configuro dentro de Checkout.");
        System.out.println("  ¿cambiar a Stripe? -> reescribir Checkout y sus pruebas.");
        System.out.println();
    }
}
