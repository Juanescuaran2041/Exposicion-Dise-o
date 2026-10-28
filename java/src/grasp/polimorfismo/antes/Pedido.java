package grasp.polimorfismo.antes;

/** El pedido guarda el tipo de envío como texto. */
public record Pedido(String id, String tipoEnvio, double pesoKg) { }
