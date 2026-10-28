package grasp.controlador.antes;

import grasp.controlador.comun.Inventario;
import grasp.controlador.comun.PasarelaPago;

public class BotonPagar {
    private Inventario inventario;
    private PasarelaPago pasarela;

    public BotonPagar(Inventario inventario, PasarelaPago pasarela) {
        this.inventario = inventario;
        this.pasarela = pasarela;
    }

    // La pantalla hace todo el caso de uso.
    public void alHacerClic(int unidades, double total, String tarjeta) {
        if (!inventario.reservar(unidades)) {
            mostrar("ERROR: sin stock");
            return;
        }
        if (!pasarela.cobrar(tarjeta, total)) {
            inventario.liberar(unidades);     // la pantalla corrigiendo
            mostrar("ERROR: pago rechazado");
            return;
        }
        mostrar("OK: compra confirmada");
    }

    private void mostrar(String mensaje) {
        System.out.println("    [pantalla] " + mensaje);
    }
}
