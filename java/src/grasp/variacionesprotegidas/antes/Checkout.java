package grasp.variacionesprotegidas.antes;

import grasp.variacionesprotegidas.comun.*;

/**
 * PROBLEMA: Checkout está casado con PayPal.
 *
 * El punto de variación ("¿con qué pasarela cobramos?") no está aislado:
 * está esparcido por el código del dominio. Checkout conoce el SDK,
 * su estado "APPROVED", sus códigos de error y su moneda.
 *
 * El día que la empresa cambie de proveedor (y va a pasar), hay que
 * reescribir Checkout y todo lo que mencione PayPalSDK. Tampoco se puede
 * probar sin llamar a PayPal, ni cobrar en pesos, ni tener dos pasarelas
 * a la vez para un experimento A/B.
 */
public class Checkout {

    private final PayPalSDK paypal = new PayPalSDK("merchant-1");   // decidido aquí, en duro

    public Recibo pagar(Pedido pedido) {
        PayPalPayment pago = paypal.createPayment(pedido.total(), "USD");

        if (!"APPROVED".equals(pago.state())) {                     // vocabulario de PayPal
            throw new IllegalStateException("Pago rechazado: " + pago.errorCode());
        }
        return new Recibo(pago.id(), pago.amount(), "PayPal");
    }
}
