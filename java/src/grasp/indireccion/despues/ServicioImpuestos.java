package grasp.indireccion.despues;

import grasp.indireccion.comun.*;

/**
 * INDIRECCIÓN: un objeto intermedio entre el dominio y la API externa.
 *
 * Todo lo feo queda aquí, en un solo lugar:
 *  - la clave de la API,
 *  - la conversión pesos <-> centavos,
 *  - la interpretación de los códigos de estado,
 *  - la política de respaldo cuando el servicio se cae,
 *  - (y si mañana hay que cachear o reintentar, también va aquí).
 *
 * El dominio pregunta en pesos y recibe pesos.
 */
public class ServicioImpuestos {

    private final TaxMasterClient api;
    private final double tasaRespaldo;
    private int vecesQueUsoElRespaldo = 0;

    public ServicioImpuestos(TaxMasterClient api, double tasaRespaldo) {
        this.api = api;
        this.tasaRespaldo = tasaRespaldo;
    }

    public double calcular(String pais, double base, String tipoDocumento) {
        TaxResponse r = api.calc(new TaxRequest(pais, Math.round(base * 100), tipoDocumento));
        if (r.status() != 200) {
            vecesQueUsoElRespaldo++;
            return base * tasaRespaldo;
        }
        return r.amountCents() / 100.0;
    }

    public int vecesQueUsoElRespaldo() { return vecesQueUsoElRespaldo; }
}
