package grasp.variacionesprotegidas.despues;

import grasp.variacionesprotegidas.comun.PayPalPayment;
import grasp.variacionesprotegidas.comun.PayPalSDK;

/** Adaptador: traduce el idioma de PayPal al nuestro. */
public class PagoPayPal implements PasarelaPago {

    private final PayPalSDK sdk;

    public PagoPayPal(String merchantId) { this.sdk = new PayPalSDK(merchantId); }

    @Override public Cobro cobrar(double monto, String moneda) throws PagoRechazado {
        PayPalPayment pago = sdk.createPayment(monto, moneda);
        if (!"APPROVED".equals(pago.state())) {
            throw new PagoRechazado("PayPal: " + pago.errorCode());
        }
        return new Cobro(pago.id(), pago.amount(), nombre());
    }

    @Override public String nombre() { return "PayPal"; }
}
