package grasp.variacionesprotegidas.despues;

/**
 * VARIACIONES PROTEGIDAS: esta interfaz es la "coraza" alrededor del punto
 * de variación (cómo se cobra). Es un contrato estable que define NUESTRO
 * lenguaje; los proveedores se adaptan a él, no al contrario.
 *
 * Pasos del patrón:
 *  1. identificar el punto de inestabilidad previsible -> la pasarela de pago;
 *  2. envolverlo con una interfaz estable               -> PasarelaPago;
 *  3. hacer que el resto del sistema dependa de la interfaz, no de la
 *     implementación                                    -> Checkout.
 */
public interface PasarelaPago {

    Cobro cobrar(double monto, String moneda) throws PagoRechazado;

    String nombre();
}
