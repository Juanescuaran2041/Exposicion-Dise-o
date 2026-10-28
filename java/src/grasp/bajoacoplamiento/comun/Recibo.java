package grasp.bajoacoplamiento.comun;

public record Recibo(String ventaId, double monto, String autorizacion) {
    @Override public String toString() {
        return String.format("Recibo{venta=%s, monto=$%,.0f, aut=%s}", ventaId, monto, autorizacion);
    }
}
