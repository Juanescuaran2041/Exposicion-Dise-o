package grasp.bajoacoplamiento.despues;

import grasp.bajoacoplamiento.comun.AutorizacionTarjeta;
import java.time.LocalDate;

/**
 * Pago sabe construirse a sí mismo ya autorizado: un objeto válido
 * desde el primer instante (no hay un "pago a medio llenar").
 */
public class Pago {
    private final double monto;
    private final LocalDate fecha;
    private final String autorizacion;

    private Pago(double monto, LocalDate fecha, String autorizacion) {
        this.monto = monto;
        this.fecha = fecha;
        this.autorizacion = autorizacion;
    }

    /** Fábrica: el único modo de obtener un Pago es uno ya autorizado. */
    public static Pago conTarjeta(double monto, String tarjeta) {
        String aut = new AutorizacionTarjeta(tarjeta).autorizar(monto);
        return new Pago(monto, LocalDate.now(), aut);
    }

    public double monto()        { return monto; }
    public LocalDate fecha()     { return fecha; }
    public String autorizacion() { return autorizacion; }
}
