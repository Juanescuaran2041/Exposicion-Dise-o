package grasp.polimorfismo.despues;

public class EnvioExpress implements Envio {
    @Override public double costo(double kg) { return 12_000 + kg * 2_000; }
    @Override public int diasEntrega()       { return 1; }
    @Override public String etiqueta()       { return "Express 24h"; }
}
