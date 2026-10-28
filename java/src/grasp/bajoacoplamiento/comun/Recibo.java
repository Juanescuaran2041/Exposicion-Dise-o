package grasp.bajoacoplamiento.comun;

public class Recibo {
    private String ventaId;
    private double monto;
    private String autorizacion;

    public Recibo(String ventaId, double monto, String autorizacion) {
        this.ventaId = ventaId;
        this.monto = monto;
        this.autorizacion = autorizacion;
    }

    public double getMonto()        { return monto; }
    public String getAutorizacion() { return autorizacion; }

    @Override
    public String toString() {
        return String.format("Recibo{venta=%s, monto=$%,.0f, aut=%s}",
                ventaId, monto, autorizacion);
    }
}
