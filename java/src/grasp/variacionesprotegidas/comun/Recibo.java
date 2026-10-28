package grasp.variacionesprotegidas.comun;

public class Recibo {
    private String referencia;
    private double monto;

    public Recibo(String referencia, double monto) {
        this.referencia = referencia;
        this.monto = monto;
    }

    @Override
    public String toString() {
        return String.format("Recibo{ref=%s, monto=$%,.0f}", referencia, monto);
    }
}
