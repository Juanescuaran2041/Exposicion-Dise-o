package grasp.variacionesprotegidas.comun;

public class PayPalPago {
    private String id;
    private String estado;        // "APPROVED" o "FAILED"
    private double monto;

    public PayPalPago(String id, String estado, double monto) {
        this.id = id;
        this.estado = estado;
        this.monto = monto;
    }

    public String getId()     { return id; }
    public String getEstado() { return estado; }
    public double getMonto()  { return monto; }
}
