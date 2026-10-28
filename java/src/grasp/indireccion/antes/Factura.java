package grasp.indireccion.antes;

import grasp.indireccion.comun.ApiImpuestos;

public class Factura {
    private double subtotal;

    public Factura(double subtotal) {
        this.subtotal = subtotal;
    }

    public double impuesto() {
        ApiImpuestos api = new ApiImpuestos("CLAVE-123");       // clave repetida
        long centavos = api.calcularEnCentavos("CO", Math.round(subtotal * 100), "FACTURA");

        if (centavos == -1) {
            return subtotal * 0.19;                             // plan B
        }
        return centavos / 100.0;                                // centavos a pesos
    }
}
