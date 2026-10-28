package grasp.indireccion.comun;

public class ApiImpuestos {
    public static boolean servicioCaido = false;

    private static int llamadas = 0;

    private String clave;

    public ApiImpuestos(String clave) {
        this.clave = clave;
    }

    public long calcularEnCentavos(String pais, long baseEnCentavos, String tipoDocumento) {
        llamadas++;

        if (!clave.startsWith("CLAVE-")) {
            return -1;
        }
        if (servicioCaido) {
            return -1;
        }
        return Math.round(baseEnCentavos * 0.19);
    }

    public static int llamadas() {
        return llamadas;
    }

    public static void reiniciarContador() {
        llamadas = 0;
    }
}
