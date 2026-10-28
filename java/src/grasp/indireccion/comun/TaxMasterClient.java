package grasp.indireccion.comun;

/**
 * API EXTERNA (simulada). Representa el SDK de un tercero:
 *  - pide la clave en el constructor,
 *  - habla en centavos (long), no en pesos,
 *  - devuelve códigos de estado en vez de lanzar excepciones,
 *  - y a veces, simplemente, se cae.
 *
 * Nosotros no controlamos esta clase: puede cambiar de versión mañana.
 */
public class TaxMasterClient {

    /** Interruptor de la demo: simula que el servicio del tercero está caído. */
    public static boolean servicioCaido = false;

    private static int llamadasTotales = 0;

    private final String apiKey;

    public TaxMasterClient(String apiKey) { this.apiKey = apiKey; }

    public TaxResponse calc(TaxRequest request) {
        llamadasTotales++;
        if (!apiKey.startsWith("KEY-")) return new TaxResponse(401, 0);
        if (servicioCaido)              return new TaxResponse(503, 0);
        return new TaxResponse(200, Math.round(request.amountCents() * 0.19));
    }

    public static int llamadasTotales() { return llamadasTotales; }

    public static void reiniciarContador() { llamadasTotales = 0; }
}
