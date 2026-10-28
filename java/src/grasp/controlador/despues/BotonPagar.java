package grasp.controlador.despues;

public class BotonPagar {
    private ControladorCompra controlador;

    public BotonPagar(ControladorCompra controlador) {
        this.controlador = controlador;
    }

    // La pantalla delega y pinta.
    public void alHacerClic(int unidades, double total, String tarjeta) {
        if (controlador.confirmarCompra(unidades, total, tarjeta)) {
            mostrar("OK: compra confirmada");
        } else {
            mostrar("ERROR: no se pudo completar la compra");
        }
    }

    private void mostrar(String mensaje) {
        System.out.println("    [pantalla] " + mensaje);
    }
}
