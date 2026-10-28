package grasp.indireccion.despues;

import grasp.indireccion.comun.ApiImpuestos;

public class DemoDespues {
    public static void ejecutar() {
        ServicioImpuestos impuestos =
                new ServicioImpuestos(new ApiImpuestos("CLAVE-123"), 0.19);

        System.out.println("DESPUES");
        ApiImpuestos.servicioCaido = true;      // se cae el servicio otra vez
        System.out.printf("  factura    = $%,.0f%n", new Factura(100000, impuestos).impuesto());
        System.out.printf("  cotizacion = $%,.0f%n", new Cotizacion(100000, impuestos).impuesto());
        System.out.printf("  devolucion = $%,.0f%n", new Devolucion(100000, impuestos).impuesto());
        ApiImpuestos.servicioCaido = false;
        System.out.println("  Las tres usaron el plan B sin repetir una sola linea.");
        System.out.println();
    }
}
