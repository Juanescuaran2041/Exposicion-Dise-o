package grasp.variacionesprotegidas.comun;

/**
 * LIBRERÍA EXTERNA (simulada). Fíjate en su vocabulario propio:
 * "payment", estados en texto, montos en unidades enteras y códigos
 * de error suyos. Nada de eso es de nuestro negocio.
 */
public class PayPalSDK {

    private final String merchantId;

    public PayPalSDK(String merchantId) { this.merchantId = merchantId; }

    public PayPalPayment createPayment(double amount, String currency) {
        if (amount <= 0) return new PayPalPayment(null, "FAILED", 0, "INVALID_AMOUNT");
        return new PayPalPayment("PP-" + Math.abs((merchantId + amount).hashCode()),
                "APPROVED", amount, null);
    }
}
