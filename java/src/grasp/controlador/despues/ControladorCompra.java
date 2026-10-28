package grasp.controlador.despues;

import grasp.controlador.comun.Inventario;
import grasp.controlador.comun.PasarelaPago;

public class ControladorCompra {
    private Inventario inventario;
    private PasarelaPago pasarela;

    public ControladorCompra(Inventario inventario, PasarelaPago pasarela) {
        this.inventario = inventario;
        this.pasarela = pasarela;
    }

    // El caso de uso completo, sin una sola linea de pantalla.
    public boolean confirmarCompra(int unidades, double total, String tarjeta) {
        if (!inventario.reservar(unidades)) {
            return false;
        }
        if (!pasarela.cobrar(tarjeta, total)) {
            inventario.liberar(unidades);     // la correccion vive aqui
            return false;
        }
        return true;
    }
}
