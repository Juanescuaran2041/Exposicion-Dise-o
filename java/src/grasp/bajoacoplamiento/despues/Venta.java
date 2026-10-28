package grasp.bajoacoplamiento.despues;

import grasp.bajoacoplamiento.comun.EstadoVenta;
import grasp.bajoacoplamiento.comun.Recibo;

public class Venta {
    private String id;
    private double monto;
    private Pago pago;
    private EstadoVenta estado = EstadoVenta.ABIERTA;

    public Venta(String id, double monto) {
        this.id = id;
        this.monto = monto;
    }

    public Recibo pagar(double monto, String tarjeta) {
        if (estado != EstadoVenta.ABIERTA) {
            throw new IllegalStateException("La venta ya estaba cerrada");
        }
        this.pago = Pago.conTarjeta(monto, tarjeta);
        this.estado = EstadoVenta.PAGADA;
        return new Recibo(id, monto, pago.getAutorizacion());
    }

    public String getId()          { return id; }
    public double getMonto()       { return monto; }
    public EstadoVenta getEstado() { return estado; }
}
