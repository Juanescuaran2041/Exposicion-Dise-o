package grasp.polimorfismo.despues;

public class DemoDespues {
    public static void ejecutar() {
        Envio[] envios = {
                new EnvioEstandar(),
                new EnvioExpress(),
                new EnvioInternacional(),
                new EnvioDron()                 // el tipo nuevo, ya incluido
        };

        System.out.println("DESPUES  (cada tipo sabe lo suyo)");

        int numero = 1;
        for (Envio envio : envios) {            // ni un if, ni un switch
            Pedido pedido = new Pedido("PED-" + numero, envio, 2.5);
            System.out.println("  " + pedido.resumen());
            numero++;
        }

        double masBarato = envios[0].costo(2.5);
        for (Envio envio : envios) {
            if (envio.costo(2.5) < masBarato) {
                masBarato = envio.costo(2.5);
            }
        }
        System.out.printf("  opcion mas economica para 2,5 kg: $%,.0f%n", masBarato);
        System.out.println();
    }
}
