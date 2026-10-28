package grasp.variacionesprotegidas.despues;

public class Checkout {
    private PasarelaPago pasarela;

    public Checkout(PasarelaPago pasarela) {
        this.pasarela = pasarela;
    }

    // No cambia aunque cambie la pasarela.
    public String pagar(double monto) {
        return pasarela.cobrar(monto);
    }
}
