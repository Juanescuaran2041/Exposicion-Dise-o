package grasp.polimorfismo.despues;

public class Pedido {
    private String id;
    private Envio envio;
    private double pesoKg;

    public Pedido(String id, Envio envio, double pesoKg) {
        this.id = id;
        this.envio = envio;
        this.pesoKg = pesoKg;
    }

    public double costoEnvio() {
        return envio.costo(pesoKg);
    }

    public String resumen() {
        String texto = String.format("%s · %s · $%,.0f · %d dia(s)",
                id, envio.etiqueta(), costoEnvio(), envio.diasEntrega());

        if (envio.requiereAduana()) {
            texto = texto + " · requiere aduana";
        }
        return texto;
    }
}
