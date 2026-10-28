package grasp.variacionesprotegidas;

import grasp.variacionesprotegidas.antes.DemoAntes;
import grasp.variacionesprotegidas.despues.DemoDespues;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== 9. VARIACIONES PROTEGIDAS ===");
        System.out.println();
        DemoAntes.ejecutar();
        DemoDespues.ejecutar();
        System.out.println("Si cambia la pasarela se reescribe:  antes Checkout  ->  despues nada");
        System.out.println();
    }
}
