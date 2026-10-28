package grasp.experto.antes;

public class ServicioCaja {
    public double calcularTotal(Carrito carrito) {
        double total = 0;

        for (Linea linea : carrito.getLineas()) {
            Producto producto = linea.getProducto();
            double bruto = producto.getPrecio() * linea.getCantidad();
            double rebaja = bruto * linea.getDescuento();
            total = total + (bruto - rebaja) * (1 + producto.getIva());
        }
        return total;
    }
}
