package grasp.fabricacionpura.antes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * PROBLEMA: Producto es un concepto del negocio, pero aquí también es un
 * cliente de JDBC. ¿Quién es el "experto en información" para guardar?
 * Producto tiene los datos... pero no sabe nada de conexiones, tablas,
 * transacciones ni SQL.
 *
 * Si le damos esa responsabilidad al dominio:
 *  - baja la cohesión: Producto habla de negocio Y de base de datos;
 *  - sube el acoplamiento: el dominio depende de java.sql y del esquema;
 *  - no se puede probar sin una base de datos encendida (lo verás en la demo);
 *  - el código SQL se repetirá en Cliente, Pedido, Factura...
 */
public class Producto {

    private static final String URL = "jdbc:mysql://localhost/tienda";

    private final String sku;
    private final String nombre;
    private final double precio;

    public Producto(String sku, String nombre, double precio) {
        this.sku = sku;
        this.nombre = nombre;
        this.precio = precio;
    }

    public double precioConIva() { return precio * 1.19; }   // esto sí es del dominio

    /** Persistencia dentro de la entidad del negocio. */
    public void guardar() throws SQLException {
        try (Connection cx = DriverManager.getConnection(URL);
             PreparedStatement ps = cx.prepareStatement(
                     "INSERT INTO producto (sku, nombre, precio) VALUES (?, ?, ?)")) {
            ps.setString(1, sku);
            ps.setString(2, nombre);
            ps.setDouble(3, precio);
            ps.executeUpdate();
        }
    }

    public static List<Producto> buscarTodos() throws SQLException {
        List<Producto> encontrados = new ArrayList<>();
        try (Connection cx = DriverManager.getConnection(URL);
             PreparedStatement ps = cx.prepareStatement("SELECT sku, nombre, precio FROM producto");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                encontrados.add(new Producto(rs.getString(1), rs.getString(2), rs.getDouble(3)));
            }
        }
        return encontrados;
    }

    public String sku()    { return sku; }
    public String nombre() { return nombre; }
    public double precio() { return precio; }
}
