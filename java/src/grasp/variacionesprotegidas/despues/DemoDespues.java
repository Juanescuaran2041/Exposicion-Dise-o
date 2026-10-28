package grasp.variacionesprotegidas.despues;

public class DemoDespues {
    public static void ejecutar() {
        System.out.println("DESPUES");
        System.out.println("  con PayPal: " + new Checkout(new PagoPayPal()).pagar(240000));
        System.out.println("  con Nequi:  " + new Checkout(new PagoNequi()).pagar(240000));
        System.out.println("  Checkout no cambio ni una linea entre una y otra.");
        System.out.println();
    }
}
