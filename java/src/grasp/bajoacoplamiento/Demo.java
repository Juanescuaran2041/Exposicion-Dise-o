package grasp.bajoacoplamiento;

import grasp.bajoacoplamiento.antes.DemoAntes;
import grasp.bajoacoplamiento.despues.DemoDespues;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== 4. BAJO ACOPLAMIENTO ===");
        System.out.println();
        DemoAntes.ejecutar();
        DemoDespues.ejecutar();
        System.out.println("Clases que conoce Caja:  antes 4  ->  despues 2");
        System.out.println();
    }
}
