package grasp.variacionesprotegidas.despues;

import grasp.variacionesprotegidas.comun.Pedido;
import grasp.variacionesprotegidas.comun.Recibo;

/**
 * SOLUCIÓN: Checkout depende de la interfaz estable y recibe la
 * implementación desde afuera (inyección de dependencias).
 *
 * Este archivo NO cambia si:
 *  - se cambia PayPal por Stripe,
 *  - se agrega Nequi,
 *  - se usan dos pasarelas distintas según el país,
 *  - en las pruebas se inyecta una pasarela falsa.
 */
public class Checkout {

    private final PasarelaPago pasarela;

    public Checkout(PasarelaPago pasarela) { this.pasarela = pasarela; }

    public Recibo pagar(Pedido pedido) throws PagoRechazado {
        Cobro cobro = pasarela.cobrar(pedido.total(), "COP");
        return new Recibo(cobro.referencia(), cobro.monto(), cobro.pasarela());
    }
}
