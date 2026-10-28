package grasp.variacionesprotegidas.comun;

public record Recibo(String referencia, double monto, String pasarela) {
    @Override public String toString() {
        return String.format("Recibo{ref=%s, monto=$%,.0f, via=%s}", referencia, monto, pasarela);
    }
}
