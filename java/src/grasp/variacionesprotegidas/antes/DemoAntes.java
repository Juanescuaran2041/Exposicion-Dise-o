package grasp.variacionesprotegidas.antes;

import grasp.variacionesprotegidas.comun.Pedido;

public class DemoAntes {
    public static void ejecutar() {
        Checkout checkout = new Checkout();

        System.out.println("ANTES");
        System.out.println("  " + checkout.pagar(new Pedido(240000)));
        System.out.println("  Checkout habla el idioma de PayPal: su SDK y su estado.");
        System.out.println("  Cambiar de pasarela = reescribir Checkout.");
        System.out.println();
    }
}
