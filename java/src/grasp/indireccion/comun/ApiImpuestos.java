package grasp.indireccion.comun;

public class ApiImpuestos {
    public static boolean servicioCaido = false;

    private String clave;

    public ApiImpuestos(String clave) {
        this.clave = clave;
    }

    // Habla en centavos y devuelve -1 cuando no pudo.
    public long calcularEnCentavos(long baseEnCentavos) {
        if (servicioCaido || !clave.startsWith("CLAVE-")) {
            return -1;
        }
        return Math.round(baseEnCentavos * 0.19);
    }
}
