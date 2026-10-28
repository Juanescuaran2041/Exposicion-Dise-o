package grasp.indireccion.despues;

import grasp.indireccion.comun.ApiImpuestos;

public class DemoDespues {
    public static void ejecutar() {
        double base = 1000000;

        ApiImpuestos.servicioCaido = false;
        ApiImpuestos.reiniciarContador();

        ApiImpuestos api = new ApiImpuestos("CLAVE-123");
        ServicioImpuestos impuestos = new ServicioImpuestos(api, 0.19);

        Factura factura = new Factura(base, impuestos);
        Cotizacion cotizacion = new Cotizacion(base, impuestos);
        Devolucion devolucion = new Devolucion(base, impuestos);

        System.out.println("DESPUES  (1 clase atada a la API externa)");
        System.out.println("  API funcionando:");
        System.out.printf("    Factura    = $%,.0f · total = $%,.0f%n",
                factura.impuesto(), factura.total());
        System.out.printf("    Cotizacion = $%,.0f%n", cotizacion.impuesto());
        System.out.printf("    Devolucion = $%,.0f%n", devolucion.impuesto());

        ApiImpuestos.servicioCaido = true;
        System.out.println("  API caida:");
        System.out.printf("    Factura    = $%,.0f%n", factura.impuesto());
        System.out.printf("    Cotizacion = $%,.0f%n", cotizacion.impuesto());
        System.out.printf("    Devolucion = $%,.0f   <- nadie pudo olvidar el plan B%n",
                devolucion.impuesto());

        System.out.println("  llamadas a la API: " + ApiImpuestos.llamadas()
                + " · veces que uso el plan B: " + impuestos.getVecesQueUsoElRespaldo());

        ApiImpuestos.servicioCaido = false;
        System.out.println();
    }
}
