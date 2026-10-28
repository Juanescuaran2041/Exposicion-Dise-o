package grasp.indireccion;

import grasp.indireccion.antes.DemoAntes;
import grasp.indireccion.despues.DemoDespues;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== 8. INDIRECCION ===");
        System.out.println();
        DemoAntes.ejecutar();
        DemoDespues.ejecutar();
        System.out.println("Clases atadas a la API:  antes 3  ->  despues 1");
        System.out.println();
    }
}
