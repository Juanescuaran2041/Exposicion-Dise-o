package grasp.controlador;

import grasp.controlador.antes.DemoAntes;
import grasp.controlador.despues.DemoDespues;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== 3. CONTROLADOR ===");
        System.out.println();

        DemoAntes.ejecutar();
        DemoDespues.ejecutar();

        System.out.println("Dependencias de la pantalla:  antes 4  ->  despues 1");
        System.out.println();
    }
}
