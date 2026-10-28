package grasp.fabricacionpura;

import grasp.fabricacionpura.antes.DemoAntes;
import grasp.fabricacionpura.despues.DemoDespues;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== 7. FABRICACION PURA ===");
        System.out.println();

        DemoAntes.ejecutar();
        DemoDespues.ejecutar();

        System.out.println("¿Producto sabe de SQL?:  antes si  ->  despues no");
        System.out.println();
    }
}
