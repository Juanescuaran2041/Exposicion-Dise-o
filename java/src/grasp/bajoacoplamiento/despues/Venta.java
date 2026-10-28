package grasp.bajoacoplamiento.despues;

import grasp.bajoacoplamiento.comun.EstadoVenta;
import grasp.bajoacoplamiento.comun.Recibo;

/**
 * Venta YA conocía a Pago (lo tiene como atributo), así que darle la
 * responsabilidad de pagar no agrega ni un acoplamiento nuevo al diseño:
 * solo quita los de Caja. Esa es la pregunta de Bajo Acoplamiento:
 * "¿esta asignación crea dependencias nuevas o aprovecha las que ya hay?"
 */
public class Venta {
    private final String id;
    private final double monto;
    private Pago pago;
    private EstadoVenta estado = EstadoVenta.ABIERTA;

    public Venta(String id, double monto) {
        this.id = id;
        this.monto = monto;
    }

    public Recibo pagar(double monto, String tarjeta) {
        if (estado != EstadoVenta.ABIERTA) throw new IllegalStateException("Venta ya cerrada");
        this.pago = Pago.conTarjeta(monto, tarjeta);
        this.estado = EstadoVenta.PAGADA;
        return new Recibo(id, monto, pago.autorizacion());
    }

    public String id()           { return id; }
    public double monto()        { return monto; }
    public EstadoVenta estado()  { return estado; }
}
