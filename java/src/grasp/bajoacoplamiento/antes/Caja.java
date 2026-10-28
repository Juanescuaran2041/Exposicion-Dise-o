package grasp.bajoacoplamiento.antes;

import grasp.bajoacoplamiento.comun.AutorizacionTarjeta;
import grasp.bajoacoplamiento.comun.Recibo;

public class Caja {

    public Recibo registrarPago(Venta venta, String tarjeta) {
        Pago pago = new Pago(venta.getMonto());                 // conoce Pago
        AutorizacionTarjeta auto =
                new AutorizacionTarjeta(tarjeta);               // y Autorizacion
        pago.setAutorizacion(auto.autorizar(venta.getMonto()));
        venta.setPago(pago);
        venta.setPagada(true);
        return new Recibo(venta.getId(), venta.getMonto(),
                          pago.getAutorizacion());
    }
}
