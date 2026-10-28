package grasp.experto.despues;

/**
 * EXPERTO de su precio: Producto tiene el precio y el IVA,
 * así que es él quien sabe calcular el precio final.
 */
public class Producto {
    private final String nombre;
    private final double precio;
    private final double iva;

    public Producto(String nombre, double precio, double iva) {
        this.nombre = nombre;
        this.precio = precio;
        this.iva = iva;
    }

    public String nombre() { return nombre; }

    /** Tiene precio e iva -> él calcula el precio con impuesto. */
    public double precioConIva() { return precio * (1 + iva); }
}
