package grasp.variacionesprotegidas.comun;

public class Recibo {
    private String referencia;
    private double monto;
    private String pasarela;

    public Recibo(String referencia, double monto, String pasarela) {
        this.referencia = referencia;
        this.monto = monto;
        this.pasarela = pasarela;
    }

    public String getReferencia() { return referencia; }
    public double getMonto()      { return monto; }
    public String getPasarela()   { return pasarela; }

    @Override
    public String toString() {
        return String.format("Recibo{ref=%s, monto=$%,.0f, por=%s}",
                referencia, monto, pasarela);
    }
}
