package grasp.variacionesprotegidas.comun;

public class PayPalSDK {
    private String idComercio;

    public PayPalSDK(String idComercio) {
        this.idComercio = idComercio;
    }

    public PayPalPago createPayment(double monto, String moneda) {
        if (monto <= 0) {
            return new PayPalPago(null, "FAILED", 0, "INVALID_AMOUNT");
        }
        return new PayPalPago("PP-" + idComercio + "-" + (int) monto, "APPROVED", monto, null);
    }
}
