package grasp.indireccion.antes;

import grasp.indireccion.comun.ApiImpuestos;

public class DemoAntes {
    public static void ejecutar() {
        double base = 1000000;

        ApiImpuestos.servicioCaido = false;
        ApiImpuestos.reiniciarContador();

        System.out.println("ANTES  (3 clases atadas a la API externa)");
        System.out.println("  API funcionando:");
        System.out.printf("    Factura    = $%,.0f%n", new Factura(base).impuesto());
        System.out.printf("    Cotizacion = $%,.0f%n", new Cotizacion(base).impuesto());
        System.out.printf("    Devolucion = $%,.0f%n", new Devolucion(base).impuesto());

        ApiImpuestos.servicioCaido = true;
        System.out.println("  API caida:");
        System.out.printf("    Factura    = $%,.0f   (su copia si tenia plan B)%n",
                new Factura(base).impuesto());
        System.out.printf("    Cotizacion = $%,.0f   (su copia si tenia plan B)%n",
                new Cotizacion(base).impuesto());
        System.out.printf("    Devolucion = $%,.2f   <- ERROR: sin plan B, el -1 de la API%n",
                new Devolucion(base).impuesto());
        System.out.println("                            se convirtio en un impuesto absurdo");
        System.out.println("  tres copias del mismo codigo = tres errores distintos esperando.");
        System.out.println();
    }
}
