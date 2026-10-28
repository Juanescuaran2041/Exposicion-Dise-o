package grasp.bajoacoplamiento.despues;

import grasp.bajoacoplamiento.comun.AutorizacionTarjeta;

public class Pago {
    private double monto;
    private String fecha;
    private String autorizacion;

    private Pago(double monto, String fecha, String autorizacion) {
        this.monto = monto;
        this.fecha = fecha;
        this.autorizacion = autorizacion;
    }

    public static Pago conTarjeta(double monto, String tarjeta) {
        AutorizacionTarjeta auto = new AutorizacionTarjeta(tarjeta);
        return new Pago(monto, "2026-10-27", auto.autorizar(monto));
    }

    public double getMonto()        { return monto; }
    public String getAutorizacion() { return autorizacion; }
}
