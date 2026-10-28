package grasp.controlador.comun;

public class Item {
    private String sku;
    private String nombre;
    private double precio;
    private int cantidad;

    public Item(String sku, String nombre, double precio, int cantidad) {
        this.sku = sku;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getSku()    { return sku; }
    public String getNombre() { return nombre; }
    public int getCantidad()  { return cantidad; }
    public double subtotal()  { return precio * cantidad; }
}
