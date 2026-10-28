package grasp.variacionesprotegidas.despues;

public class PagoRechazado extends RuntimeException {
    public PagoRechazado(String mensaje) {
        super(mensaje);
    }
}
