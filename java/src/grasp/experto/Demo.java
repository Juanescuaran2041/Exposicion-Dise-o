package grasp.experto;

/**
 * PATRÓN 1 · EXPERTO EN INFORMACIÓN (Information Expert)
 *
 * Pregunta:  ¿quién debe hacer esta tarea?
 * Respuesta: la clase que tiene la información necesaria para hacerla.
 *
 * El resultado numérico es idéntico en las dos versiones: GRASP no cambia
 * el QUÉ hace el programa, cambia QUIÉN lo hace.
 */
public final class Demo {

    public static void main(String[] args) {
        System.out.println("=== 1. EXPERTO EN INFORMACIÓN ===\n");

        // ---------- ANTES ----------
        var pAntes = new grasp.experto.antes.Producto("Teclado", 100_000, 0.19);
        var cAntes = new grasp.experto.antes.Carrito();
        cAntes.agregar(new grasp.experto.antes.Linea(pAntes, 2, 0.10));
        cAntes.agregar(new grasp.experto.antes.Linea(
                new grasp.experto.antes.Producto("Mouse", 40_000, 0.19), 1, 0.0));

        double totalAntes = new grasp.experto.antes.ServicioCaja().calcularTotal(cAntes);
        System.out.printf("ANTES   total = $%,.0f%n", totalAntes);
        System.out.println("        ServicioCaja navegó Carrito -> Linea -> Producto");
        System.out.println("        y aplicó él mismo las reglas de descuento e IVA.\n");

        // ---------- DESPUÉS ----------
        var pDespues = new grasp.experto.despues.Producto("Teclado", 100_000, 0.19);
        var cDespues = new grasp.experto.despues.Carrito()
                .agregar(new grasp.experto.despues.Linea(pDespues, 2, 0.10))
                .agregar(new grasp.experto.despues.Linea(
                        new grasp.experto.despues.Producto("Mouse", 40_000, 0.19), 1, 0.0));

        double totalDespues = new grasp.experto.despues.ServicioCaja().cobrar(cDespues);
        System.out.printf("DESPUÉS total = $%,.0f%n", totalDespues);
        for (var l : cDespues.lineas()) {
            System.out.printf("        %-18s subtotal = $%,.0f%n", l.descripcion(), l.subtotal());
        }
        System.out.println("        Cada objeto calculó lo suyo. ServicioCaja solo preguntó.\n");

        System.out.println("Clases que conoce ServicioCaja:  antes 3  ->  después 1");
        System.out.println("Mismo total: " + (Math.abs(totalAntes - totalDespues) < 0.01) + "\n");
    }

    private Demo() { }
}
