package grasp.variacionesprotegidas.despues;

public class Cobro {
    private String referencia;
    private double monto;

    public Cobro(String referencia, double monto) {
        this.referencia = referencia;
        this.monto = monto;
    }

    public String getReferencia() { return referencia; }
    public double getMonto()      { return monto; }
}
