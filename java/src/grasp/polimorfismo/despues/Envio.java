package grasp.polimorfismo.despues;

public interface Envio {
    double costo(double kg);

    int diasEntrega();

    String etiqueta();

    boolean requiereAduana();
}
