package grasp.polimorfismo.despues;

/**
 * El tipo NUEVO del mes: una clase nueva.
 * No se tocó ni una línea de Envio, ni de las otras implementaciones,
 * ni del código que los usa. Esa es la ganancia del polimorfismo.
 */
public class EnvioDron implements Envio {
    @Override public double costo(double kg) { return 20_000 + kg * 8_000; }
    @Override public int diasEntrega()       { return 0; }   // mismo día
    @Override public String etiqueta()       { return "Dron (2 h)"; }
}
