package grasp.variacionesprotegidas.comun;

public class Pedido {
    private String id;
    private double total;

    public Pedido(String id, double total) {
        this.id = id;
        this.total = total;
    }

    public String getId()    { return id; }
    public double getTotal() { return total; }
}
