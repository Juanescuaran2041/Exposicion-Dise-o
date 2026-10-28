package grasp.variacionesprotegidas.antes;

import grasp.variacionesprotegidas.comun.PayPalPago;
import grasp.variacionesprotegidas.comun.PayPalSDK;
import grasp.variacionesprotegidas.comun.Pedido;

public class Checkout {
    private PayPalSDK paypal = new PayPalSDK();      // decidido aqui

    public String pagar(Pedido pedido) {
        PayPalPago pago = paypal.createPayment(pedido.getTotal());
        if (!pago.getEstado().equals("APPROVED")) {  // el idioma de PayPal
            throw new IllegalStateException("Pago rechazado");
        }
        return pago.getId();
    }
}
