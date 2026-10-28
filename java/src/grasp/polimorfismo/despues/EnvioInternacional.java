package grasp.polimorfismo.despues;

public class EnvioInternacional implements Envio {
    @Override public double costo(double kg) { return 30_000 + kg * 4_500; }
    @Override public int diasEntrega()       { return 15; }
    @Override public String etiqueta()       { return "Internacional"; }
    @Override public boolean requiereAduana() { return true; }
}
