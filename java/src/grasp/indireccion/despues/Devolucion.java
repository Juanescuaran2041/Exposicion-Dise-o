package grasp.indireccion.despues;

public class Devolucion {

    private final double subtotal;
    private final ServicioImpuestos impuestos;

    public Devolucion(double subtotal, ServicioImpuestos impuestos) {
        this.subtotal = subtotal;
        this.impuestos = impuestos;
    }

    /** El respaldo ya no se puede "olvidar": lo aplica el intermediario. */
    public double impuesto() { return impuestos.calcular("CO", subtotal, "DEVOLUCION"); }
}
