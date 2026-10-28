package grasp.bajoacoplamiento.comun;

public class AutorizacionTarjeta {
    private String tarjeta;

    public AutorizacionTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String autorizar(double monto) {
        if (!tarjeta.startsWith("4")) {
            throw new IllegalStateException("Tarjeta rechazada");
        }
        return "AUT-" + (int) monto + "-" + tarjeta.substring(0, 4);
    }
}
