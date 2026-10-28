package grasp.controlador.comun;

public class PasarelaPago {

    public boolean cobrar(String tarjeta, double monto) {
        return tarjeta.startsWith("4");
    }
}
