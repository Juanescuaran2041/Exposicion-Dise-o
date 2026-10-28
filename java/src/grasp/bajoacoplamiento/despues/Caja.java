package grasp.bajoacoplamiento.despues;

import grasp.bajoacoplamiento.comun.Recibo;

public class Caja {
    public Recibo registrarPago(Venta venta, double monto, String tarjeta) {
        return venta.pagar(monto, tarjeta);
    }
}
