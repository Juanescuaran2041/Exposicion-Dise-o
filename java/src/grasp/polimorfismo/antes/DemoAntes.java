package grasp.polimorfismo.antes;

public class DemoAntes {
    public static void ejecutar() {
        CalculadoraEnvio calculadora = new CalculadoraEnvio();
        String[] tipos = { "ESTANDAR", "EXPRESS", "INTERNACIONAL" };

        System.out.println("ANTES");
        for (String tipo : tipos) {
            System.out.printf("  %-14s $%,.0f en %d dia(s)%n",
                    tipo, calculadora.costo(tipo, 2), calculadora.diasEntrega(tipo));
        }
        System.out.println("  Para un tipo nuevo hay que editar los 2 switch.");
        System.out.println();
    }
}
