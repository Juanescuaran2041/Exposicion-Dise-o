package grasp.variacionesprotegidas.comun;

// El tipo de PayPal, con el vocabulario de PayPal.
public class PayPalPago {
    private String id;
    private String estado;        // "APPROVED" o "FAILED"

    public PayPalPago(String id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    public String getId()     { return id; }
    public String getEstado() { return estado; }
}
