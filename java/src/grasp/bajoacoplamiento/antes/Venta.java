package grasp.bajoacoplamiento.antes;

public class Venta {
    private String id;
    private double monto;
    private Pago pago;
    private boolean pagada;

    public Venta(String id, double monto) {
        this.id = id;
        this.monto = monto;
    }

    public String getId()    { return id; }
    public double getMonto() { return monto; }

    // Dos setters abiertos: cualquiera cambia el estado de la venta.
    public void setPago(Pago pago)       { this.pago = pago; }
    public void setPagada(boolean valor) { this.pagada = valor; }

    public boolean estaPagada() { return pagada; }
}
