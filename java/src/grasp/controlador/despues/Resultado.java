package grasp.controlador.despues;

import grasp.controlador.comun.Pedido;

/** Lo que el controlador le devuelve a la interfaz: datos, no decisiones. */
public record Resultado(boolean exito, Pedido pedido, String mensaje) {

    public static Resultado ok(Pedido pedido)    { return new Resultado(true, pedido, "OK"); }
    public static Resultado error(String mensaje) { return new Resultado(false, null, mensaje); }
}
