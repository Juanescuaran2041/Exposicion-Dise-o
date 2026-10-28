package grasp.variacionesprotegidas.despues;

import grasp.variacionesprotegidas.comun.PayPalPago;
import grasp.variacionesprotegidas.comun.PayPalSDK;

public class PagoPayPal implements PasarelaPago {
    private PayPalSDK sdk;

    public PagoPayPal(String idComercio) {
        this.sdk = new PayPalSDK(idComercio);
    }

    public Cobro cobrar(double monto, String moneda) {
        PayPalPago pago = sdk.createPayment(monto, moneda);

        if (!pago.getEstado().equals("APPROVED")) {
            throw new PagoRechazado("PayPal: " + pago.getCodigoError());
        }
        return new Cobro(pago.getId(), pago.getMonto(), nombre());
    }

    public String nombre() {
        return "PayPal";
    }
}
