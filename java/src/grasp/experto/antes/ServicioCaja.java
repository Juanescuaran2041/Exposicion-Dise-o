package grasp.experto.antes;

public class ServicioCaja {

    // Abre el carrito, abre cada linea y abre cada producto.
    public double calcularTotal(Carrito carrito) {
        double total = 0;
        for (Linea linea : carrito.getLineas()) {
            Producto producto = linea.getProducto();
            double precioConIva = producto.getPrecio() * (1 + producto.getIva());
            total = total + precioConIva * linea.getCantidad();
        }
        return total;
    }
}
