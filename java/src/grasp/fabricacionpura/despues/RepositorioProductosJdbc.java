package grasp.fabricacionpura.despues;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementación real: TODO el SQL vive aquí, en un solo lugar,
 * y el dominio no se enteró. Recibe la conexión en el constructor,
 * así que tampoco decide de dónde sale (eso es de la configuración).
 *
 * En la demo no se ejecuta: necesita una base de datos. El punto es
 * justamente que el dominio ya no necesita una para poder probarse.
 */
public class RepositorioProductosJdbc implements RepositorioProductos {

    private final Connection cx;

    public RepositorioProductosJdbc(Connection cx) { this.cx = cx; }

    @Override public void guardar(Producto p) {
        String sql = "INSERT INTO producto (sku, nombre, precio) VALUES (?, ?, ?)";
        try (PreparedStatement ps = cx.prepareStatement(sql)) {
            ps.setString(1, p.sku());
            ps.setString(2, p.nombre());
            ps.setDouble(3, p.precio());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new ErrorDePersistencia("No se pudo guardar " + p.sku(), e);
        }
    }

    @Override public Optional<Producto> buscar(String sku) {
        String sql = "SELECT sku, nombre, precio FROM producto WHERE sku = ?";
        try (PreparedStatement ps = cx.prepareStatement(sql)) {
            ps.setString(1, sku);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(mapear(rs)) : Optional.empty();
            }
        } catch (SQLException e) {
            throw new ErrorDePersistencia("No se pudo buscar " + sku, e);
        }
    }

    @Override public List<Producto> todos() {
        List<Producto> lista = new ArrayList<>();
        try (PreparedStatement ps = cx.prepareStatement("SELECT sku, nombre, precio FROM producto");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
            return lista;
        } catch (SQLException e) {
            throw new ErrorDePersistencia("No se pudo listar productos", e);
        }
    }

    private Producto mapear(ResultSet rs) throws SQLException {
        return new Producto(rs.getString("sku"), rs.getString("nombre"), rs.getDouble("precio"));
    }
}
