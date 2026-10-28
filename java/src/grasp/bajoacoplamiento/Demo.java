package grasp.bajoacoplamiento;

/**
 * PATRÓN 4 · BAJO ACOPLAMIENTO (Low Coupling)
 *
 * Entre dos diseños que funcionan igual, elige el que deje a cada clase
 * dependiendo de menos clases. Menos flechas = menos propagación de cambios,
 * más reutilización y pruebas más fáciles.
 */
public final class Demo {

    public static void main(String[] args) {
        System.out.println("=== 4. BAJO ACOPLAMIENTO ===\n");

        // ---------- ANTES ----------
        var ventaAntes = new grasp.bajoacoplamiento.antes.Venta("V-100", 250_000);
        var reciboAntes = new grasp.bajoacoplamiento.antes.Caja()
                .registrarPago(ventaAntes, 250_000, "4111-2222");

        System.out.println("ANTES");
        System.out.println("  " + reciboAntes);
        System.out.println("  estado = " + ventaAntes.getEstado());
        System.out.println("  Caja conoce: Venta, Pago, AutorizacionTarjeta, EstadoVenta, Recibo\n");

        // ---------- DESPUÉS ----------
        var venta = new grasp.bajoacoplamiento.despues.Venta("V-100", 250_000);
        var recibo = new grasp.bajoacoplamiento.despues.Caja()
                .registrarPago(venta, 250_000, "4111-2222");

        System.out.println("DESPUÉS");
        System.out.println("  " + recibo);
        System.out.println("  estado = " + venta.estado());
        System.out.println("  Caja conoce: Venta, Recibo");

        // Beneficio extra: ahora Venta protege su propia invariante.
        try {
            venta.pagar(250_000, "4111-2222");
        } catch (IllegalStateException e) {
            System.out.println("  pagar dos veces -> " + e.getMessage());
        }

        System.out.println("\nDependencias de Caja:  antes 4 (+Recibo)  ->  después 1 (+Recibo)\n");
    }

    private Demo() { }
}
