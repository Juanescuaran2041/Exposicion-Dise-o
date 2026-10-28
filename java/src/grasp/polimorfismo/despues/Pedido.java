package grasp.polimorfismo.despues;

public class Pedido {
    private Envio envio;
    private double pesoKg;

    public Pedido(Envio envio, double pesoKg) {
        this.envio = envio;
        this.pesoKg = pesoKg;
    }

    public double costoEnvio() {
        return envio.costo(pesoKg);
    }

    public int diasEntrega() {
        return envio.diasEntrega();
    }
}
