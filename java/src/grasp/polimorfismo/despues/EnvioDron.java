package grasp.polimorfismo.despues;

public class EnvioDron implements Envio {
    public double costo(double kg)   { return 20000 + kg * 8000; }
    public int diasEntrega()         { return 0; }     // el mismo dia
    public String etiqueta()         { return "Dron (2 horas)"; }
    public boolean requiereAduana()  { return false; }
}
