package grasp.indireccion.despues;

public class Factura {
    private double subtotal;
    private ServicioImpuestos impuestos;

    public Factura(double subtotal, ServicioImpuestos impuestos) {
        this.subtotal = subtotal;
        this.impuestos = impuestos;
    }

    public double impuesto() {
        return impuestos.calcular(subtotal);
    }
}
