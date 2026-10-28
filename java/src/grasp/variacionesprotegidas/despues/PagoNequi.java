package grasp.variacionesprotegidas.despues;


public class PagoNequi implements PasarelaPago {
    public Cobro cobrar(double monto, String moneda) {
        if (!moneda.equals("COP")) {
            throw new PagoRechazado("Nequi solo recibe pesos colombianos");
        }
        return new Cobro("NQ-" + (int) monto, monto, nombre());
    }

    public String nombre() {
        return "Nequi";
    }
}
