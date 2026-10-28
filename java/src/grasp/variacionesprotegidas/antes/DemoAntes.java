package grasp.variacionesprotegidas.antes;

public class DemoAntes {
    public static void ejecutar() {
        Checkout checkout = new Checkout();

        System.out.println("ANTES");
        System.out.println("  referencia = " + checkout.pagar(240000));
        System.out.println("  Checkout habla el idioma de PayPal: su SDK, su tipo y su estado.");
        System.out.println("  Cambiar de pasarela = reescribir Checkout.");
        System.out.println();
    }
}
