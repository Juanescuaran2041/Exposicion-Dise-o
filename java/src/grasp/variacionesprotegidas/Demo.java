package grasp.variacionesprotegidas;

import grasp.variacionesprotegidas.comun.Pedido;
import grasp.variacionesprotegidas.despues.*;
import java.util.List;

/**
 * PATRÓN 9 · VARIACIONES PROTEGIDAS (Protected Variations)
 *
 * Identifica los puntos donde el sistema va a cambiar o donde hay
 * inestabilidad previsible (proveedores, formatos, normativas, dispositivos)
 * y envuélvelos con una interfaz estable.
 *
 * Es el patrón "paraguas": Polimorfismo, Indirección y Fabricación Pura
 * son maneras concretas de lograrlo.
 */
public final class Demo {

    public static void main(String[] args) {
        System.out.println("=== 9. VARIACIONES PROTEGIDAS ===\n");

        var pedido = new Pedido("PED-77", 350_000);

        // ---------- ANTES: Checkout casado con PayPal ----------
        System.out.println("ANTES");
        var checkoutAntes = new grasp.variacionesprotegidas.antes.Checkout();
        System.out.println("  " + checkoutAntes.pagar(pedido));
        System.out.println("  cobró en USD porque PayPal se configuró así dentro de Checkout.");
        System.out.println("  ¿cambiar a Stripe? -> reescribir Checkout (y sus pruebas).\n");

        // ---------- DESPUÉS: Checkout contra la interfaz ----------
        System.out.println("DESPUÉS  (el mismo Checkout, tres pasarelas)");
        List<PasarelaPago> pasarelas = List.of(new PagoPayPal("merchant-1"), new PagoStripe(), new PagoNequi());

        for (PasarelaPago pasarela : pasarelas) {
            var checkout = new Checkout(pasarela);        // solo cambia lo que se inyecta
            try {
                System.out.printf("  %-8s -> %s%n", pasarela.nombre(), checkout.pagar(pedido));
            } catch (PagoRechazado e) {
                System.out.printf("  %-8s -> rechazado: %s%n", pasarela.nombre(), e.getMessage());
            }
        }

        // Y el error también quedó traducido a nuestro lenguaje:
        try {
            new Checkout(new PagoStripe()).pagar(new Pedido("PED-78", 0));
        } catch (PagoRechazado e) {
            System.out.println("  monto 0 -> PagoRechazado (nuestra excepción, no la de Stripe):");
            System.out.println("            " + e.getMessage());
        }

        System.out.println("\nSi cambia la pasarela, se reescribe:  antes Checkout  ->  después nada\n");
    }

    private Demo() { }
}
