package grasp.indireccion.antes;

import grasp.indireccion.comun.*;

/**
 * ...y otra vez. Nótese el error sutil: aquí alguien olvidó el respaldo
 * y, si la API falla, la devolución queda con impuesto 0.
 * Así es como la duplicación se convierte en bugs distintos en cada copia.
 */
public class Devolucion {

    private final double subtotal;

    public Devolucion(double subtotal) { this.subtotal = subtotal; }

    public double impuesto() {
        TaxMasterClient api = new TaxMasterClient("KEY-123");
        TaxResponse r = api.calc(new TaxRequest("CO", Math.round(subtotal * 100), "DEVOLUCION"));
        return r.amountCents() / 100.0;          // sin respaldo: devuelve 0 si falla
    }
}
