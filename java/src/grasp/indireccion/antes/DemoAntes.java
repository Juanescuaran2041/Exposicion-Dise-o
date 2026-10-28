package grasp.indireccion.antes;

import grasp.indireccion.comun.ApiImpuestos;

public class DemoAntes {
    public static void ejecutar() {
        System.out.println("ANTES");
        ApiImpuestos.servicioCaido = false;
        System.out.printf("  factura    = $%,.0f%n", new Factura(100000).impuesto());

        ApiImpuestos.servicioCaido = true;      // se cae el servicio
        System.out.printf("  factura    = $%,.0f  (uso el plan B)%n",
                new Factura(100000).impuesto());
        System.out.printf("  cotizacion = $%,.0f  (uso el plan B)%n",
                new Cotizacion(100000).impuesto());
        System.out.printf("  devolucion = $%,.2f  (se quedo sin plan B)%n",
                new Devolucion(100000).impuesto());
        ApiImpuestos.servicioCaido = false;
        System.out.println("  Tres clases atadas a la API: tres copias del mismo codigo.");
        System.out.println();
    }
}
