package grasp.indireccion.antes;

import grasp.indireccion.comun.*;

/**
 * PROBLEMA: la Factura habla directo con la API externa. Para hacerlo
 * tiene que saber: la clave, el formato del request, que la respuesta
 * viene en centavos, qué código de estado significa éxito y qué hacer
 * cuando el servicio se cae.
 */
public class Factura {

    private final double subtotal;

    public Factura(double subtotal) { this.subtotal = subtotal; }

    public double impuesto() {
        TaxMasterClient api = new TaxMasterClient("KEY-123");          // clave repetida
        TaxResponse r = api.calc(new TaxRequest("CO", Math.round(subtotal * 100), "FACTURA"));
        if (r.status() != 200) return subtotal * 0.19;                 // respaldo repetido
        return r.amountCents() / 100.0;                                // centavos -> pesos
    }
}
