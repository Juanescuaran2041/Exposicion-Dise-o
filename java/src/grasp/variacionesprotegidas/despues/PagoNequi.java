package grasp.variacionesprotegidas.despues;

/**
 * El proveedor que llegó DESPUÉS de escribir Checkout.
 * Se agregó esta clase y nada más: Checkout no se tocó.
 */
public class PagoNequi implements PasarelaPago {

    @Override public Cobro cobrar(double monto, String moneda) throws PagoRechazado {
        if (!"COP".equals(moneda)) throw new PagoRechazado("Nequi solo opera en COP");
        return new Cobro("NQ-" + Math.round(monto), monto, nombre());
    }

    @Override public String nombre() { return "Nequi"; }
}
