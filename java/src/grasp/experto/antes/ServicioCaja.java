package grasp.experto.antes;

/**
 * PROBLEMA: ServicioCaja no tiene ningún dato propio, pero concentra toda
 * la lógica. Para calcular el total tiene que navegar tres niveles
 * (Carrito -> Linea -> Producto) y además conocer las reglas de descuento
 * e IVA que pertenecen a otras clases.
 *
 * Consecuencias:
 *  - Acoplamiento: depende de 3 clases y de la forma interna de cada una.
 *  - Si Linea cambia cómo guarda el descuento, hay que editar ServicioCaja.
 *  - La misma fórmula se copiará en el informe, en la factura, en el recibo...
 */
public class ServicioCaja {

    public double calcularTotal(Carrito carrito) {
        double total = 0;
        for (Linea l : carrito.getLineas()) {       // navega al carrito
            Producto p = l.getProducto();           // navega a la línea
            double bruto = p.getPrecio() * l.getCantidad();
            double descuento = bruto * l.getPorcentajeDescuento();
            total += (bruto - descuento) * (1 + p.getIva());
        }
        return total;
    }
}
