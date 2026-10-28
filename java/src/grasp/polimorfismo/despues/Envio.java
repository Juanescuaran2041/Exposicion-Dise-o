package grasp.polimorfismo.despues;

/**
 * POLIMORFISMO: el punto de variación se vuelve una operación polimórfica.
 * Cada tipo de envío implementa su propio comportamiento y el código que
 * los usa deja de preguntar "¿de qué tipo eres?".
 */
public interface Envio {

    double costo(double kg);

    int diasEntrega();

    String etiqueta();

    /** Valor por defecto: la mayoría de envíos no pasa por aduana. */
    default boolean requiereAduana() { return false; }
}
