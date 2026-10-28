package grasp.creador;

import grasp.creador.antes.DemoAntes;
import grasp.creador.despues.DemoDespues;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== 2. CREADOR ===");
        System.out.println();

        DemoAntes.ejecutar();
        DemoDespues.ejecutar();

        System.out.println("Quien hace new LineaPedido:  antes la pantalla  ->  despues Pedido");
        System.out.println();
    }
}
