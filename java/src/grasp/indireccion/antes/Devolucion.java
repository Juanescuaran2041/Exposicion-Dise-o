package grasp.indireccion.antes;

import grasp.indireccion.comun.ApiImpuestos;

public class Devolucion {
    private double subtotal;

    public Devolucion(double subtotal) {
        this.subtotal = subtotal;
    }

    public double impuesto() {
        ApiImpuestos api = new ApiImpuestos("CLAVE-123");
        long centavos = api.calcularEnCentavos("CO", Math.round(subtotal * 100), "DEVOLUCION");

        return centavos / 100.0;        // sin plan B
    }
}
