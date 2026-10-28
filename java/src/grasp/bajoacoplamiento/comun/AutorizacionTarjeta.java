package grasp.bajoacoplamiento.comun;

/** Servicio de autorización de tarjetas (simulado). */
public class AutorizacionTarjeta {
    private final String tarjeta;

    public AutorizacionTarjeta(String tarjeta) { this.tarjeta = tarjeta; }

    public String autorizar(double monto) {
        if (!tarjeta.startsWith("4")) throw new IllegalStateException("Tarjeta rechazada");
        return "AUT-" + Math.abs((tarjeta + monto).hashCode());
    }
}
