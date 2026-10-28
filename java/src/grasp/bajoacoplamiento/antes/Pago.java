package grasp.bajoacoplamiento.antes;

public class Pago {
    private double monto;
    private String fecha;
    private String autorizacion;

    public Pago(double monto, String fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public double getMonto()        { return monto; }
    public String getAutorizacion() { return autorizacion; }
}
