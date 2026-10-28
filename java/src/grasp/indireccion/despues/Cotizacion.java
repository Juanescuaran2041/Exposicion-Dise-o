package grasp.indireccion.despues;

public class Cotizacion {
    private double subtotal;
    private ServicioImpuestos impuestos;

    public Cotizacion(double subtotal, ServicioImpuestos impuestos) {
        this.subtotal = subtotal;
        this.impuestos = impuestos;
    }

    public double impuesto() {
        return impuestos.calcular("CO", subtotal, "COTIZACION");
    }
}
