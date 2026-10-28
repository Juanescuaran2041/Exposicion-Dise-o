package grasp.fabricacionpura.antes;

import grasp.fabricacionpura.comun.BaseDeDatos;

public class Producto {
    private String sku;
    private double precio;
    private BaseDeDatos baseDeDatos;      // el negocio cargando la base

    public Producto(String sku, double precio, BaseDeDatos baseDeDatos) {
        this.sku = sku;
        this.precio = precio;
        this.baseDeDatos = baseDeDatos;
    }

    // Esto si es del producto.
    public double precioConIva() {
        return precio * 1.19;
    }

    // Esto no: es trabajo tecnico.
    public void guardar() {
        baseDeDatos.ejecutar("INSERT INTO producto VALUES ('" + sku + "', " + precio + ")");
    }

    public void eliminar() {
        baseDeDatos.ejecutar("DELETE FROM producto WHERE sku = '" + sku + "'");
    }
}
