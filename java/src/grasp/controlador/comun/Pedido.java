package grasp.controlador.comun;

public class Pedido {
    private Cliente cliente;
    private double total;

    public Pedido(Cliente cliente, double total) {
        this.cliente = cliente;
        this.total = total;
    }

    public Cliente getCliente() { return cliente; }
    public double getTotal()    { return total; }
}
