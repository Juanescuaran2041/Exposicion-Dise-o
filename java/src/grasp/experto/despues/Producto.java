package grasp.experto.despues;

public class Producto {
    private String nombre;
    private double precio;
    private double iva;

    public Producto(String nombre, double precio, double iva) {
        this.nombre = nombre;
        this.precio = precio;
        this.iva = iva;
    }

    // El IVA lo sabe el producto: el tiene el dato.
    public double precioConIva() {
        return precio * (1 + iva);
    }
}
