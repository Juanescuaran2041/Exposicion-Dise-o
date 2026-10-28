package grasp.variacionesprotegidas.despues;

import grasp.variacionesprotegidas.comun.PayPalPago;
import grasp.variacionesprotegidas.comun.PayPalSDK;

// Lo unico que sabe de PayPal en todo el sistema.
public class PagoPayPal implements PasarelaPago {
    private PayPalSDK sdk = new PayPalSDK();

    public String cobrar(double monto) {
        PayPalPago pago = sdk.createPayment(monto);
        if (!pago.getEstado().equals("APPROVED")) {
            throw new IllegalStateException("PayPal rechazo el pago");
        }
        return pago.getId();
    }
}
