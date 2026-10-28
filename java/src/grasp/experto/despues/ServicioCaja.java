package grasp.experto.despues;

/**
 * SOLUCIÓN: ServicioCaja ya no calcula nada; coordina.
 * Conoce una sola clase (Carrito) y una sola operación (total()).
 * Si mañana cambia la regla de IVA o de descuento, este archivo no se toca.
 */
public class ServicioCaja {

    public double cobrar(Carrito carrito) {
        return carrito.total();
    }
}
