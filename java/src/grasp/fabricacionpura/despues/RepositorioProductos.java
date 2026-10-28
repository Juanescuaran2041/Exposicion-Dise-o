package grasp.fabricacionpura.despues;

import grasp.fabricacionpura.comun.BaseDeDatos;

// Clase inventada: no existe en el negocio, pero hace falta.
public class RepositorioProductos {
    private BaseDeDatos baseDeDatos;

    public RepositorioProductos(BaseDeDatos baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public void guardar(Producto producto) {
        baseDeDatos.ejecutar("INSERT INTO producto VALUES ('"
                + producto.getSku() + "', " + producto.getPrecio() + ")");
    }

    public void eliminar(Producto producto) {
        baseDeDatos.ejecutar("DELETE FROM producto WHERE sku = '"
                + producto.getSku() + "'");
    }
}
