package grasp.variacionesprotegidas.despues;

// La interfaz estable: nuestro vocabulario, no el de PayPal.
public interface PasarelaPago {
    Cobro cobrar(double monto);
}
