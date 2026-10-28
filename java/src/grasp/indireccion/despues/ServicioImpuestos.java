package grasp.indireccion.despues;

import grasp.indireccion.comun.ApiImpuestos;

public class ServicioImpuestos {
    private ApiImpuestos api;
    private double tasaDeRespaldo;
    private int vecesQueUsoElRespaldo = 0;

    public ServicioImpuestos(ApiImpuestos api, double tasaDeRespaldo) {
        this.api = api;
        this.tasaDeRespaldo = tasaDeRespaldo;
    }

    public double calcular(String pais, double base, String tipoDocumento) {
        long centavos = api.calcularEnCentavos(pais, Math.round(base * 100), tipoDocumento);

        if (centavos == -1) {
            vecesQueUsoElRespaldo++;
            return base * tasaDeRespaldo;
        }
        return centavos / 100.0;
    }

    public int getVecesQueUsoElRespaldo() {
        return vecesQueUsoElRespaldo;
    }
}
