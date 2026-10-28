package grasp.bajoacoplamiento.antes;

import java.time.LocalDate;

public class Pago {
    private final double monto;
    private final LocalDate fecha;
    private String autorizacion;

    public Pago(double monto, LocalDate fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

    public void setAutorizacion(String autorizacion) { this.autorizacion = autorizacion; }
    public String getAutorizacion() { return autorizacion; }
    public double getMonto() { return monto; }
    public LocalDate getFecha() { return fecha; }
}
