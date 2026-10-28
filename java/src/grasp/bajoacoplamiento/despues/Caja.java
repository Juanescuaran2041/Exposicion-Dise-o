package grasp.bajoacoplamiento.despues;

import grasp.bajoacoplamiento.comun.Recibo;

public class Caja {

    public Recibo registrarPago(Venta venta, String tarjeta) {
        return venta.pagar(tarjeta);
    }
}
