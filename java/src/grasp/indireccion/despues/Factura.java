package grasp.indireccion.despues;

/**
 * SOLUCIÓN: la Factura ya no sabe que existe TaxMaster.
 * Recibe el intermediario y le pregunta en el lenguaje del negocio.
 */
public class Factura {

    private final double subtotal;
    private final ServicioImpuestos impuestos;

    public Factura(double subtotal, ServicioImpuestos impuestos) {
        this.subtotal = subtotal;
        this.impuestos = impuestos;
    }

    public double impuesto() { return impuestos.calcular("CO", subtotal, "FACTURA"); }

    public double total() { return subtotal + impuesto(); }
}
