package grasp.polimorfismo;

import grasp.polimorfismo.antes.DemoAntes;
import grasp.polimorfismo.despues.DemoDespues;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== 6. POLIMORFISMO ===");
        System.out.println();

        DemoAntes.ejecutar();
        DemoDespues.ejecutar();

        System.out.println("Agregar un tipo:  antes editar 4 switch  ->  despues 1 clase nueva");
        System.out.println();
    }
}
