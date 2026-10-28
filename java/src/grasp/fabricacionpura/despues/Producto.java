package grasp.fabricacionpura.despues;

public class Producto {
    private String sku;
    private double precio;

    public Producto(String sku, double precio) {
        this.sku = sku;
        this.precio = precio;
    }

    public double precioConIva() {
        return precio * 1.19;
    }

    public String getSku()    { return sku; }
    public double getPrecio() { return precio; }
}
