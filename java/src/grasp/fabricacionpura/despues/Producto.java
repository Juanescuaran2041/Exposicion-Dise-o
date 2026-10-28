package grasp.fabricacionpura.despues;

/**
 * Dominio puro: ni un import de java.sql.
 * Producto solo habla de productos, y se puede probar en un milisegundo.
 */
public record Producto(String sku, String nombre, double precio) {

    public Producto {
        if (precio < 0) throw new IllegalArgumentException("precio >= 0");
    }

    public double precioConIva() { return precio * 1.19; }
}
