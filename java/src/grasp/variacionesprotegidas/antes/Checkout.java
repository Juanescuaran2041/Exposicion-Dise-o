package grasp.variacionesprotegidas.antes;

import grasp.variacionesprotegidas.comun.PayPalPago;
import grasp.variacionesprotegidas.comun.PayPalSDK;
import grasp.variacionesprotegidas.comun.Pedido;
import grasp.variacionesprotegidas.comun.Recibo;

public class Checkout {
    private PayPalSDK paypal = new PayPalSDK();      // decidido aqui

    public Recibo pagar(Pedido pedido) {
        PayPalPago pago = paypal.createPayment(pedido.getTotal());
        if (!pago.getEstado().equals("APPROVED")) {  // el idioma de PayPal
            throw new IllegalStateException("Pago rechazado");
        }
        return new Recibo(pago.getId(), pago.getMonto());
    }
}
