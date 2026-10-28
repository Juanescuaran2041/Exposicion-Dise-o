package grasp.experto;

import grasp.experto.antes.DemoAntes;
import grasp.experto.despues.DemoDespues;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== 1. EXPERTO EN INFORMACION ===");
        System.out.println();

        DemoAntes.ejecutar();
        DemoDespues.ejecutar();

        System.out.println("Clases que conoce ServicioCaja:  antes 3  ->  despues 1");
        System.out.println();
    }
}
