package grasp.controlador.comun;

/** Colaborador: cobra. Simula aprobar solo las tarjetas que empiezan por 4. */
public class PasarelaPago {
    public boolean cobrar(String tarjeta, double monto) {
        return tarjeta != null && tarjeta.startsWith("4") && monto > 0;
    }
}
