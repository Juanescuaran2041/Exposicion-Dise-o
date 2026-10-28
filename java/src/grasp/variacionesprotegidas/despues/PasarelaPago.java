package grasp.variacionesprotegidas.despues;

public interface PasarelaPago {
    Cobro cobrar(double monto, String moneda);

    String nombre();
}
