package grasp.variacionesprotegidas.despues;

public class Cobro {
    private String referencia;
    private double monto;
    private String pasarela;

    public Cobro(String referencia, double monto, String pasarela) {
        this.referencia = referencia;
        this.monto = monto;
        this.pasarela = pasarela;
    }

    public String getReferencia() { return referencia; }
    public double getMonto()      { return monto; }
    public String getPasarela()   { return pasarela; }
}
