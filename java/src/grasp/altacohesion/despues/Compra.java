package grasp.altacohesion.despues;

public class Compra {
    private String id;
    private double monto;

    public Compra(String id, double monto) {
        this.id = id;
        this.monto = monto;
    }

    public String getId()    { return id; }
    public double getMonto() { return monto; }
}
