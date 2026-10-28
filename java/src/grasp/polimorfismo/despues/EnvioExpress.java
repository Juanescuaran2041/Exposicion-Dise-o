package grasp.polimorfismo.despues;

public class EnvioExpress implements Envio {
    public double costo(double kg) { return 12000 + kg * 2000; }
    public int diasEntrega()       { return 1; }
}
