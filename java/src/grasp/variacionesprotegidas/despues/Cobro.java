package grasp.variacionesprotegidas.despues;

/**
 * NUESTRO vocabulario, no el del proveedor.
 * Cada implementación traduce su jerga a este tipo estable.
 */
public record Cobro(String referencia, double monto, String pasarela) { }
