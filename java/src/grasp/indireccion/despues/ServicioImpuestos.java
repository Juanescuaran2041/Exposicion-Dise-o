package grasp.indireccion.despues;

import grasp.indireccion.comun.ApiImpuestos;

// El intermediario: aqui vive todo lo que se sabe de la API.
public class ServicioImpuestos {
    private ApiImpuestos api;
    private double tasaDeRespaldo;

    public ServicioImpuestos(ApiImpuestos api, double tasaDeRespaldo) {
        this.api = api;
        this.tasaDeRespaldo = tasaDeRespaldo;
    }

    public double calcular(double base) {
        long centavos = api.calcularEnCentavos(Math.round(base * 100));
        if (centavos == -1) {
            return base * tasaDeRespaldo;
        }
        return centavos / 100.0;
    }
}
