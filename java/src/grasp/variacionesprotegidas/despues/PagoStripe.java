package grasp.variacionesprotegidas.despues;


public class PagoStripe implements PasarelaPago {
    public Cobro cobrar(double monto, String moneda) {
        try {
            String referencia = StripeApi.charge(Math.round(monto * 100), moneda.toLowerCase());
            return new Cobro(referencia, monto, nombre());
        } catch (IllegalArgumentException e) {
            throw new PagoRechazado("Stripe: " + e.getMessage());
        }
    }

    public String nombre() {
        return "Stripe";
    }
}
