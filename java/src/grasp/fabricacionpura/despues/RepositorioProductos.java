package grasp.fabricacionpura.despues;

import java.util.List;
import java.util.Optional;

/**
 * FABRICACIÓN PURA: "RepositorioProductos" no existe en el negocio
 * (nadie en la tienda dice "tráeme el repositorio"). Es una clase
 * inventada por conveniencia de diseño para agrupar una responsabilidad
 * técnica: la persistencia.
 *
 * Al ser una interfaz, además logra Variaciones Protegidas: el dominio
 * depende del contrato, no de JDBC.
 */
public interface RepositorioProductos {

    void guardar(Producto producto);

    Optional<Producto> buscar(String sku);

    List<Producto> todos();
}
