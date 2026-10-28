package grasp.bajoacoplamiento.antes;

import grasp.bajoacoplamiento.comun.EstadoVenta;

public class Venta {
    private String id;
    private double monto;
    private Pago pago;
    private EstadoVenta estado = EstadoVenta.ABIERTA;

    public Venta(String id, double monto) {
        this.id = id;
        this.monto = monto;
    }

    public String getId()          { return id; }
    public double getMonto()       { return monto; }
    public EstadoVenta getEstado() { return estado; }

    public void setPago(Pago pago)            { this.pago = pago; }
    public void setEstado(EstadoVenta estado) { this.estado = estado; }
}
