package grasp.variacionesprotegidas.despues;

/** Nuestra excepción: ni "FAILED" de PayPal ni las de Stripe salen al dominio. */
public class PagoRechazado extends Exception {
    public PagoRechazado(String mensaje) { super(mensaje); }
}
