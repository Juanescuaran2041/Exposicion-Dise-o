package grasp.fabricacionpura.antes;

import grasp.fabricacionpura.comun.BaseDeDatos;

public class Producto {
    private String sku;
    private String nombre;
    private double precio;
    private BaseDeDatos baseDeDatos;      // el negocio cargando la base

    public Producto(String sku, String nombre, double precio, BaseDeDatos baseDeDatos) {
        this.sku = sku;
        this.nombre = nombre;
        this.precio = precio;
        this.baseDeDatos = baseDeDatos;
    }

    public double precioConIva() {
        return precio * 1.19;
    }

    public void guardar() {
        baseDeDatos.ejecutar("INSERT INTO producto (sku, nombre, precio) VALUES ('"
                + sku + "', '" + nombre + "', " + precio + ")");
    }

    public void eliminar() {
        baseDeDatos.ejecutar("DELETE FROM producto WHERE sku = '" + sku + "'");
    }

    public String getSku()    { return sku; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
}
