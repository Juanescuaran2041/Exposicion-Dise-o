package grasp.altacohesion;

import grasp.altacohesion.antes.DemoAntes;
import grasp.altacohesion.despues.DemoDespues;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== 5. ALTA COHESION ===");
        System.out.println();

        DemoAntes.ejecutar();
        DemoDespues.ejecutar();

        System.out.println("Motivos de cambio de Usuario:  antes 5  ->  despues 1");
        System.out.println();
    }
}
