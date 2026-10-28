package grasp.polimorfismo.despues;

/** El pedido guarda un Envio, no un String: el compilador ayuda. */
public record Pedido(String id, Envio envio, double pesoKg) {

    public double costoEnvio() { return envio.costo(pesoKg); }

    public String resumen() {
        return String.format("%s · %s · $%,.0f · %d día(s)%s",
                id, envio.etiqueta(), costoEnvio(), envio.diasEntrega(),
                envio.requiereAduana() ? " · requiere aduana" : "");
    }
}
