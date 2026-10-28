package grasp.indireccion.despues;

public class Devolucion {
    private double subtotal;
    private ServicioImpuestos impuestos;

    public Devolucion(double subtotal, ServicioImpuestos impuestos) {
        this.subtotal = subtotal;
        this.impuestos = impuestos;
    }

    public double impuesto() {
        return impuestos.calcular("CO", subtotal, "DEVOLUCION");
    }
}
