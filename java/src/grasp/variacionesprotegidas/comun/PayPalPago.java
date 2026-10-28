package grasp.variacionesprotegidas.comun;

public class PayPalPago {
    private String id;
    private String estado;        // "APPROVED" o "FAILED"
    private double monto;
    private String codigoError;

    public PayPalPago(String id, String estado, double monto, String codigoError) {
        this.id = id;
        this.estado = estado;
        this.monto = monto;
        this.codigoError = codigoError;
    }

    public String getId()          { return id; }
    public String getEstado()      { return estado; }
    public double getMonto()       { return monto; }
    public String getCodigoError() { return codigoError; }
}
