package grasp.bajoacoplamiento.antes;

import grasp.bajoacoplamiento.comun.AutorizacionTarjeta;
import grasp.bajoacoplamiento.comun.EstadoVenta;
import grasp.bajoacoplamiento.comun.Recibo;

public class Caja {
    public Recibo registrarPago(Venta venta, double monto, String tarjeta) {
        Pago pago = new Pago(monto, "2026-10-27");                   // conoce Pago
        AutorizacionTarjeta auto = new AutorizacionTarjeta(tarjeta); // y Autorizacion
        pago.setAutorizacion(auto.autorizar(monto));
        venta.setPago(pago);
        venta.setEstado(EstadoVenta.PAGADA);                         // y EstadoVenta
        return new Recibo(venta.getId(), monto, pago.getAutorizacion());
    }
}
