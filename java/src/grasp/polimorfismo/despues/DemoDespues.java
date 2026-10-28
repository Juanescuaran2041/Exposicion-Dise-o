package grasp.polimorfismo.despues;

public class DemoDespues {
    public static void ejecutar() {
        Envio[] envios = { new EnvioEstandar(), new EnvioExpress(),
                           new EnvioInternacional(), new EnvioDron() };
        String[] nombres = { "Estandar", "Express", "Internacional", "Dron (nuevo)" };

        System.out.println("DESPUES");
        for (int i = 0; i < envios.length; i++) {
            Pedido pedido = new Pedido(envios[i], 2);
            System.out.printf("  %-14s $%,.0f en %d dia(s)%n",
                    nombres[i], pedido.costoEnvio(), pedido.diasEntrega());
        }
        System.out.println("  EnvioDron se agrego sin tocar las otras clases.");
        System.out.println();
    }
}
