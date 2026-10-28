package grasp.polimorfismo;

import grasp.polimorfismo.despues.*;
import java.util.List;

/**
 * PATRÓN 6 · POLIMORFISMO (Polymorphism)
 *
 * Cuando el comportamiento varía según el tipo, no uses condicionales
 * sobre el tipo: asigna la responsabilidad a cada tipo con operaciones
 * polimórficas.
 */
public final class Demo {

    public static void main(String[] args) {
        System.out.println("=== 6. POLIMORFISMO ===\n");

        // ---------- ANTES: switch por String ----------
        var calc = new grasp.polimorfismo.antes.CalculadoraEnvio();
        System.out.println("ANTES  (4 condicionales sobre el mismo String)");
        for (String tipo : List.of("ESTANDAR", "EXPRESS", "INTERNACIONAL")) {
            System.out.printf("  %-14s $%,.0f · %d día(s) · %s%n",
                    tipo, calc.costo(tipo, 2.5), calc.diasEntrega(tipo), calc.etiqueta(tipo));
        }
        try {
            calc.costo("DRON", 2.5);                 // tipo nuevo = error en ejecución
        } catch (IllegalArgumentException e) {
            System.out.println("  tipo nuevo \"DRON\" -> " + e.getMessage());
            System.out.println("  para soportarlo hay que editar los 4 métodos de la clase\n");
        }

        // ---------- DESPUÉS: una clase por tipo ----------
        System.out.println("DESPUÉS  (cada tipo sabe lo suyo; el dron ya está incluido)");
        List<Envio> envios = List.of(
                new EnvioEstandar(), new EnvioExpress(),
                new EnvioInternacional(), new EnvioDron());

        int i = 1;
        for (Envio envio : envios) {                 // ni un if, ni un switch
            System.out.println("  " + new Pedido("PED-" + i++, envio, 2.5).resumen());
        }

        double masBarato = envios.stream().mapToDouble(e -> e.costo(2.5)).min().orElse(0);
        System.out.printf("  opción más económica para 2,5 kg: $%,.0f%n", masBarato);

        System.out.println("\nAgregar un tipo:  antes editar 4 switch  ->  después +1 clase\n");
    }

    private Demo() { }
}
