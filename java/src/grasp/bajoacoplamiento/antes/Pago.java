package grasp.bajoacoplamiento.antes;

public class Pago {
    private double monto;
    private String autorizacion;

    public Pago(double monto) {
        this.monto = monto;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public String getAutorizacion() { return autorizacion; }
}
