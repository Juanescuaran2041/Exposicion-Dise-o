package grasp.polimorfismo.antes;

public class DemoAntes {
    public static void ejecutar() {
        CalculadoraEnvio calculadora = new CalculadoraEnvio();
        String[] tipos = { "ESTANDAR", "EXPRESS", "INTERNACIONAL" };

        System.out.println("ANTES  (4 condicionales sobre el mismo texto)");
        for (String tipo : tipos) {
            System.out.printf("  %-14s $%,.0f · %d dia(s) · %s%n",
                    tipo,
                    calculadora.costo(tipo, 2.5),
                    calculadora.diasEntrega(tipo),
                    calculadora.etiqueta(tipo));
        }

        try {
            calculadora.costo("DRON", 2.5);        // tipo nuevo
        } catch (IllegalArgumentException e) {
            System.out.println("  tipo nuevo \"DRON\" -> " + e.getMessage());
            System.out.println("  para soportarlo hay que editar los 4 metodos de la clase");
        }
        System.out.println();
    }
}
