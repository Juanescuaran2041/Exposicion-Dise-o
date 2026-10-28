package grasp.controlador.despues;

import grasp.controlador.comun.Pedido;

public class Resultado {
    private boolean exito;
    private Pedido pedido;
    private String mensaje;

    private Resultado(boolean exito, Pedido pedido, String mensaje) {
        this.exito = exito;
        this.pedido = pedido;
        this.mensaje = mensaje;
    }

    public static Resultado ok(Pedido pedido) {
        return new Resultado(true, pedido, "OK");
    }

    public static Resultado error(String mensaje) {
        return new Resultado(false, null, mensaje);
    }

    public boolean isExito()   { return exito; }
    public Pedido getPedido()  { return pedido; }
    public String getMensaje() { return mensaje; }
}
