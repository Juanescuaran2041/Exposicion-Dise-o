package grasp.variacionesprotegidas.despues;

// La pasarela nueva: una clase mas, nada que reescribir.
public class PagoNequi implements PasarelaPago {

    public String cobrar(double monto) {
        return "NQ-" + (int) monto;
    }
}
