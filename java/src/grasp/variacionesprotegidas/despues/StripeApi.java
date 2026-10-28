package grasp.variacionesprotegidas.despues;

public class StripeApi {
    public static String charge(long montoEnCentavos, String moneda) {
        if (montoEnCentavos <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
        return "ch_" + montoEnCentavos;
    }
}
