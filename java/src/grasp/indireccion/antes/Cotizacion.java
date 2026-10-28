package grasp.indireccion.antes;

import grasp.indireccion.comun.*;

/** ...y aquí están las mismas cinco líneas copiadas. */
public class Cotizacion {

    private final double subtotal;

    public Cotizacion(double subtotal) { this.subtotal = subtotal; }

    public double impuesto() {
        TaxMasterClient api = new TaxMasterClient("KEY-123");
        TaxResponse r = api.calc(new TaxRequest("CO", Math.round(subtotal * 100), "COTIZACION"));
        if (r.status() != 200) return subtotal * 0.19;
        return r.amountCents() / 100.0;
    }
}
