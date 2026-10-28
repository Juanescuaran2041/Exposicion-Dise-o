package grasp.polimorfismo;

import grasp.polimorfismo.antes.DemoAntes;
import grasp.polimorfismo.despues.DemoDespues;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== 6. POLIMORFISMO ===");
        System.out.println();
        DemoAntes.ejecutar();
        DemoDespues.ejecutar();
        System.out.println("Para un tipo nuevo:  antes editar 2 switch  ->  despues +1 clase");
        System.out.println();
    }
}
