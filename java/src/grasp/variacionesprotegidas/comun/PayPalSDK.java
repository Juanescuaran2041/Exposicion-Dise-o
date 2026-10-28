package grasp.variacionesprotegidas.comun;

public class PayPalSDK {

    public PayPalPago createPayment(double monto) {
        if (monto <= 0) {
            return new PayPalPago(null, "FAILED", 0);
        }
        return new PayPalPago("PP-" + (int) monto, "APPROVED", monto);
    }
}
