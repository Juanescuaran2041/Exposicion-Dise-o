package grasp.variacionesprotegidas.comun;

/**
 * OTRA LIBRERÍA EXTERNA (simulada), con un vocabulario COMPLETAMENTE
 * distinto al de PayPal: cobra en centavos, devuelve un "charge id"
 * y lanza excepciones en vez de usar estados.
 *
 * Esta diferencia es la razón de ser del patrón: si el dominio habla
 * el idioma de una librería, no puede cambiar de librería.
 */
public class StripeApi {

    public static String charge(long amountCents, String currency) {
        if (amountCents <= 0) throw new IllegalArgumentException("amount must be positive");
        return "ch_" + Long.toHexString(amountCents);
    }
}
