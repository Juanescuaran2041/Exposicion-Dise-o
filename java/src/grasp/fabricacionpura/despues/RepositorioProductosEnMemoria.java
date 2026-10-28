package grasp.fabricacionpura.despues;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Implementación para pruebas y demos: rápida y sin infraestructura. */
public class RepositorioProductosEnMemoria implements RepositorioProductos {

    private final Map<String, Producto> tabla = new LinkedHashMap<>();

    @Override public void guardar(Producto producto) { tabla.put(producto.sku(), producto); }

    @Override public Optional<Producto> buscar(String sku) {
        return Optional.ofNullable(tabla.get(sku));
    }

    @Override public List<Producto> todos() { return List.copyOf(tabla.values()); }
}
