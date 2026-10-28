package grasp.bajoacoplamiento.comun;

public class AutorizacionTarjeta {
    private String tarjeta;

    public AutorizacionTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String autorizar(double monto) {
        return "AUT-" + tarjeta + "-" + (int) monto;
    }
}
