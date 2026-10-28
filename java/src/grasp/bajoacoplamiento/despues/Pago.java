package grasp.bajoacoplamiento.despues;

import grasp.bajoacoplamiento.comun.AutorizacionTarjeta;

public class Pago {
    private double monto;
    private String autorizacion;

    private Pago(double monto, String autorizacion) {
        this.monto = monto;
        this.autorizacion = autorizacion;
    }

    // El pago sabe como nace un pago con tarjeta.
    public static Pago conTarjeta(double monto, String tarjeta) {
        AutorizacionTarjeta auto = new AutorizacionTarjeta(tarjeta);
        return new Pago(monto, auto.autorizar(monto));
    }

    public String getAutorizacion() { return autorizacion; }
}
