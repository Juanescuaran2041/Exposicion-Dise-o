package grasp.polimorfismo.despues;

// El tipo nuevo: no toca ninguna clase existente.
public class EnvioDron implements Envio {
    public double costo(double kg) { return 20000 + kg * 8000; }
    public int diasEntrega()       { return 0; }
}
