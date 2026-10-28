package grasp.indireccion.antes;

import grasp.indireccion.comun.ApiImpuestos;

public class Cotizacion {
    private double subtotal;

    public Cotizacion(double subtotal) {
        this.subtotal = subtotal;
    }

    public double impuesto() {
        ApiImpuestos api = new ApiImpuestos("CLAVE-123");
        long centavos = api.calcularEnCentavos("CO", Math.round(subtotal * 100), "COTIZACION");

        if (centavos == -1) {
            return subtotal * 0.19;
        }
        return centavos / 100.0;
    }
}
