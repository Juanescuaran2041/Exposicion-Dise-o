package grasp.controlador.comun;

public class Carrito {
    private int unidades;
    private double total;

    public Carrito(int unidades, double total) {
        this.unidades = unidades;
        this.total = total;
    }

    public int getUnidades() { return unidades; }
    public double getTotal() { return total; }
}
