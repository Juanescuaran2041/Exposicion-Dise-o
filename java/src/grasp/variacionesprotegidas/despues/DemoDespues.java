package grasp.variacionesprotegidas.despues;

import grasp.variacionesprotegidas.comun.Pedido;

public class DemoDespues {
    public static void ejecutar() {
        Pedido pedido = new Pedido("PED-77", 350000);

        PasarelaPago[] pasarelas = {
                new PagoPayPal("comercio-1"),
                new PagoStripe(),
                new PagoNequi()                 // llego despues, nada cambio
        };

        System.out.println("DESPUES  (el mismo Checkout, tres pasarelas)");

        for (PasarelaPago pasarela : pasarelas) {
            Checkout checkout = new Checkout(pasarela);   // solo cambia lo que se le pasa
            System.out.printf("  %-8s -> %s%n", pasarela.nombre(), checkout.pagar(pedido));
        }

        // El error tambien quedo traducido a nuestro idioma:
        try {
            new Checkout(new PagoStripe()).pagar(new Pedido("PED-78", 0));
        } catch (PagoRechazado e) {
            System.out.println("  monto 0 -> PagoRechazado (nuestro error, no el de Stripe):");
            System.out.println("            " + e.getMessage());
        }
        System.out.println();
    }
}
