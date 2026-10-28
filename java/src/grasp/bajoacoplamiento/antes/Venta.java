package grasp.bajoacoplamiento.antes;

import grasp.bajoacoplamiento.comun.EstadoVenta;

/** Venta pasiva: expone setters para que otros la configuren paso a paso. */
public class Venta {
    private final String id;
    private final double monto;
    private Pago pago;
    private EstadoVenta estado = EstadoVenta.ABIERTA;

    public Venta(String id, double monto) {
        this.id = id;
        this.monto = monto;
    }

    public String getId()        { return id; }
    public double getMonto()     { return monto; }
    public Pago getPago()        { return pago; }
    public EstadoVenta getEstado() { return estado; }

    public void setPago(Pago pago)        { this.pago = pago; }
    public void setEstado(EstadoVenta e)  { this.estado = e; }
}
