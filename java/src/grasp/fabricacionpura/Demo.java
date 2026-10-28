package grasp.fabricacionpura;

import grasp.fabricacionpura.despues.Producto;
import grasp.fabricacionpura.despues.RepositorioProductos;
import grasp.fabricacionpura.despues.RepositorioProductosEnMemoria;

/**
 * PATRÓN 7 · FABRICACIÓN PURA (Pure Fabrication)
 *
 * Cuando una responsabilidad no cabe en ninguna clase del dominio sin
 * arruinar su cohesión, se inventa una clase que no representa nada del
 * negocio: un repositorio, un mapeador, un validador, un servicio técnico.
 *
 * "Pura" = fabricada por conveniencia de diseño, no descubierta en el dominio.
 */
public final class Demo {

    public static void main(String[] args) {
        System.out.println("=== 7. FABRICACIÓN PURA ===\n");

        // ---------- ANTES: la entidad guarda sola ----------
        var pAntes = new grasp.fabricacionpura.antes.Producto("TEC-1", "Teclado", 100_000);
        System.out.println("ANTES");
        System.out.printf("  precio con IVA = $%,.0f   (esto sí es del dominio)%n", pAntes.precioConIva());
        try {
            pAntes.guardar();
        } catch (Exception e) {
            System.out.println("  producto.guardar() -> " + e.getClass().getSimpleName()
                    + ": \"" + e.getMessage() + "\"");
        }
        System.out.println("  el dominio importa java.sql y exige una BD para poder probarse\n");

        // ---------- DESPUÉS: el repositorio inventado guarda ----------
        System.out.println("DESPUÉS");
        var producto = new Producto("TEC-1", "Teclado", 100_000);
        System.out.printf("  precio con IVA = $%,.0f   (Producto no tiene ni un import de java.sql)%n",
                producto.precioConIva());

        RepositorioProductos repo = new RepositorioProductosEnMemoria();   // en pruebas
        repo.guardar(producto);
        repo.guardar(new Producto("MOU-1", "Mouse", 40_000));

        System.out.println("  guardados = " + repo.todos().size());
        repo.buscar("MOU-1").ifPresent(p -> System.out.println("  buscar(\"MOU-1\") -> " + p.nombre()));
        System.out.println("  buscar(\"XXX\") presente: " + repo.buscar("XXX").isPresent());
        System.out.println("  en producción se inyecta RepositorioProductosJdbc: mismo contrato,");
        System.out.println("  y el dominio nunca supo cuál de los dos le tocó.\n");

        System.out.println("¿Producto sabe de SQL?:  antes sí  ->  después no\n");
    }

    private Demo() { }
}
