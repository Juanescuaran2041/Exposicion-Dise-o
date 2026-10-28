package grasp.variacionesprotegidas.despues;

// La pasarela nueva: una clase mas, nada que reescribir.
public class PagoNequi implements PasarelaPago {

    public Cobro cobrar(double monto) {
        return new Cobro("NQ-" + (int) monto, monto);
    }
}
