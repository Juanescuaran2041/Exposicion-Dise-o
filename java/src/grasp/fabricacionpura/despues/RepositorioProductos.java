package grasp.fabricacionpura.despues;

import grasp.fabricacionpura.comun.BaseDeDatos;
import java.util.ArrayList;

public class RepositorioProductos {
    private BaseDeDatos baseDeDatos;
    private ArrayList<Producto> guardados = new ArrayList<Producto>();

    public RepositorioProductos(BaseDeDatos baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public void guardar(Producto producto) {
        baseDeDatos.ejecutar("INSERT INTO producto (sku, nombre, precio) VALUES ('"
                + producto.getSku() + "', '" + producto.getNombre() + "', "
                + producto.getPrecio() + ")");
        guardados.add(producto);
    }

    public void eliminar(Producto producto) {
        baseDeDatos.ejecutar("DELETE FROM producto WHERE sku = '"
                + producto.getSku() + "'");
        guardados.remove(producto);
    }

    public Producto buscar(String sku) {
        for (Producto producto : guardados) {
            if (producto.getSku().equals(sku)) {
                return producto;
            }
        }
        return null;
    }

    public ArrayList<Producto> todos() {
        return new ArrayList<Producto>(guardados);
    }
}
