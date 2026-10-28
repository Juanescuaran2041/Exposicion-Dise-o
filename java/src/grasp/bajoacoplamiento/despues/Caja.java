package grasp.bajoacoplamiento.despues;

import grasp.bajoacoplamiento.comun.Recibo;

/**
 * SOLUCIÓN: Caja conoce UNA clase, Venta, y le pide el servicio completo.
 * Ya no sabe que existen Pago, AutorizacionTarjeta ni EstadoVenta.
 *
 * Bajo acoplamiento no significa "cero dependencias": significa elegir,
 * entre varios diseños posibles, el que crea menos dependencias nuevas.
 */
public class Caja {

    public Recibo registrarPago(Venta venta, double monto, String tarjeta) {
        return venta.pagar(monto, tarjeta);
    }
}
