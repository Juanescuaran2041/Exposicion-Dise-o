package grasp.bajoacoplamiento.despues;

import grasp.bajoacoplamiento.comun.Recibo;

public class Venta {
    private String id;
    private double monto;
    private Pago pago;
    private boolean pagada;

    public Venta(String id, double monto) {
        this.id = id;
        this.monto = monto;
    }

    // La venta se cobra sola: ya conocia a Pago.
    public Recibo pagar(String tarjeta) {
        this.pago = Pago.conTarjeta(monto, tarjeta);
        this.pagada = true;
        return new Recibo(id, monto, pago.getAutorizacion());
    }

    public boolean estaPagada() { return pagada; }
}
