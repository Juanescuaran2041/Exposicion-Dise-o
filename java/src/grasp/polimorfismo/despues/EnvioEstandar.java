package grasp.polimorfismo.despues;

public class EnvioEstandar implements Envio {
    public double costo(double kg) { return 5000 + kg * 1000; }
    public int diasEntrega()       { return 5; }
}
