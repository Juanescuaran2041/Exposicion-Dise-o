package grasp.polimorfismo.despues;

public class EnvioInternacional implements Envio {
    public double costo(double kg) { return 30000 + kg * 4500; }
    public int diasEntrega()       { return 15; }
}
