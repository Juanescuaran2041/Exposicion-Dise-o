package grasp.controlador.comun;

public record Item(String sku, String nombre, double precio, int cantidad) {
    public double subtotal() { return precio * cantidad; }
}
