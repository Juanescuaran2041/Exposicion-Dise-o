package grasp.variacionesprotegidas.antes;

import grasp.variacionesprotegidas.comun.PayPalPago;
import grasp.variacionesprotegidas.comun.PayPalSDK;

public class Checkout {
    private PayPalSDK paypal = new PayPalSDK();      // la pasarela, decidida aqui

    // Checkout habla el idioma de PayPal.
    public String pagar(double monto) {
        PayPalPago pago = paypal.createPayment(monto);
        if (!pago.getEstado().equals("APPROVED")) {
            throw new IllegalStateException("Pago rechazado");
        }
        return pago.getId();
    }
}
