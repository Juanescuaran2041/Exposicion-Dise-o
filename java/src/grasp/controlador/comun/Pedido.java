package grasp.controlador.comun;

public class Pedido {
    private String id;
    private Cliente cliente;
    private double total;

    public Pedido(String id, Cliente cliente, double total) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
    }

    public static Pedido desde(Carrito carrito, Cliente cliente) {
        return new Pedido("PED-" + carrito.getId(), cliente, carrito.total());
    }

    public String getId()      { return id; }
    public Cliente getCliente() { return cliente; }
    public double getTotal()   { return total; }
}
