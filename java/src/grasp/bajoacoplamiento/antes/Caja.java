package grasp.bajoacoplamiento.antes;

import grasp.bajoacoplamiento.comun.AutorizacionTarjeta;
import grasp.bajoacoplamiento.comun.EstadoVenta;
import grasp.bajoacoplamiento.comun.Recibo;
import java.time.LocalDate;

/**
 * PROBLEMA: para registrar un pago, Caja termina conociendo a
 * Venta, Pago, AutorizacionTarjeta, EstadoVenta y Recibo: 5 clases.
 *
 * Caja no necesitaba saber nada de eso. Cada clase que toca es una razón
 * más para que Caja tenga que cambiar:
 *  - si Pago cambia su constructor -> cambia Caja
 *  - si aparece un estado nuevo    -> cambia Caja
 *  - si el recibo necesita un dato -> cambia Caja
 * Y esa secuencia (crear pago, autorizar, marcar estado) se copiará
 * en la caja web, en la app y en las devoluciones.
 */
public class Caja {

    public Recibo registrarPago(Venta venta, double monto, String tarjeta) {
        Pago pago = new Pago(monto, LocalDate.now());               // conoce Pago
        AutorizacionTarjeta aut = new AutorizacionTarjeta(tarjeta); // conoce Autorizacion
        pago.setAutorizacion(aut.autorizar(monto));
        venta.setPago(pago);
        venta.setEstado(EstadoVenta.PAGADA);                        // conoce EstadoVenta
        return new Recibo(venta.getId(), monto, pago.getAutorizacion());
    }
}
