package grasp.indireccion;

import grasp.indireccion.comun.TaxMasterClient;
import grasp.indireccion.despues.*;

/**
 * PATRÓN 8 · INDIRECCIÓN (Indirection)
 *
 * Para que dos cosas no se conozcan directamente, se pone un objeto en medio.
 * Es el patrón detrás de los adaptadores, los repositorios, los
 * controladores y casi todo el "pegamento" de un sistema.
 *
 * La demo corre cada versión dos veces: con la API en pie y con la API caída.
 */
public final class Demo {

    private static final double BASE = 1_000_000;

    public static void main(String[] args) {
        System.out.println("=== 8. INDIRECCIÓN ===\n");

        // ---------- ANTES: cada clase habla con la API ----------
        TaxMasterClient.servicioCaido = false;
        TaxMasterClient.reiniciarContador();

        System.out.println("ANTES  (3 clases atadas a la API externa)");
        System.out.println("  API en pie:");
        System.out.printf("    Factura    = $%,.0f%n", new grasp.indireccion.antes.Factura(BASE).impuesto());
        System.out.printf("    Cotizacion = $%,.0f%n", new grasp.indireccion.antes.Cotizacion(BASE).impuesto());
        System.out.printf("    Devolucion = $%,.0f%n", new grasp.indireccion.antes.Devolucion(BASE).impuesto());

        TaxMasterClient.servicioCaido = true;
        System.out.println("  API caída (503):");
        System.out.printf("    Factura    = $%,.0f   (su copia sí tenía respaldo)%n",
                new grasp.indireccion.antes.Factura(BASE).impuesto());
        System.out.printf("    Cotizacion = $%,.0f   (su copia sí tenía respaldo)%n",
                new grasp.indireccion.antes.Cotizacion(BASE).impuesto());
        System.out.printf("    Devolucion = $%,.0f           <- BUG: a esta copia se le olvidó%n",
                new grasp.indireccion.antes.Devolucion(BASE).impuesto());
        System.out.println("  tres copias de las mismas 5 líneas = tres bugs distintos esperando.\n");

        // ---------- DESPUÉS: todas hablan con el intermediario ----------
        TaxMasterClient.servicioCaido = false;
        TaxMasterClient.reiniciarContador();

        var api = new TaxMasterClient("KEY-123");
        var impuestos = new ServicioImpuestos(api, 0.19);
        var factura = new Factura(BASE, impuestos);

        System.out.println("DESPUÉS  (1 clase atada a la API externa)");
        System.out.println("  API en pie:");
        System.out.printf("    Factura    = $%,.0f · total = $%,.0f%n", factura.impuesto(), factura.total());
        System.out.printf("    Cotizacion = $%,.0f%n", new Cotizacion(BASE, impuestos).impuesto());
        System.out.printf("    Devolucion = $%,.0f%n", new Devolucion(BASE, impuestos).impuesto());

        TaxMasterClient.servicioCaido = true;
        System.out.println("  API caída (503):");
        System.out.printf("    Factura    = $%,.0f%n", new Factura(BASE, impuestos).impuesto());
        System.out.printf("    Cotizacion = $%,.0f%n", new Cotizacion(BASE, impuestos).impuesto());
        System.out.printf("    Devolucion = $%,.0f   <- nadie pudo olvidar el respaldo%n",
                new Devolucion(BASE, impuestos).impuesto());

        System.out.println("  llamadas a la API: " + TaxMasterClient.llamadasTotales()
                + " · respaldos aplicados por el intermediario: " + impuestos.vecesQueUsoElRespaldo());
        System.out.println("  ¿cambia el proveedor de impuestos? se edita UN archivo.\n");

        TaxMasterClient.servicioCaido = false;
        System.out.println("Clases acopladas a la API:  antes 3  ->  después 1\n");
    }

    private Demo() { }
}
