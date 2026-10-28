package grasp.indireccion.despues;

public class Cotizacion {

    private final double subtotal;
    private final ServicioImpuestos impuestos;

    public Cotizacion(double subtotal, ServicioImpuestos impuestos) {
        this.subtotal = subtotal;
        this.impuestos = impuestos;
    }

    public double impuesto() { return impuestos.calcular("CO", subtotal, "COTIZACION"); }
}
