package grasp.polimorfismo.despues;

public class EnvioEstandar implements Envio {
    @Override public double costo(double kg) { return 5_000 + kg * 1_000; }
    @Override public int diasEntrega()       { return 5; }
    @Override public String etiqueta()       { return "Estándar"; }
}
