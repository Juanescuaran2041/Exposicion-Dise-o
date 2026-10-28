package grasp.variacionesprotegidas.despues;

import grasp.variacionesprotegidas.comun.StripeApi;

/** Otro adaptador: Stripe cobra en centavos y lanza excepciones. */
public class PagoStripe implements PasarelaPago {

    @Override public Cobro cobrar(double monto, String moneda) throws PagoRechazado {
        try {
            String chargeId = StripeApi.charge(Math.round(monto * 100), moneda.toLowerCase());
            return new Cobro(chargeId, monto, nombre());
        } catch (RuntimeException e) {
            throw new PagoRechazado("Stripe: " + e.getMessage());
        }
    }

    @Override public String nombre() { return "Stripe"; }
}
