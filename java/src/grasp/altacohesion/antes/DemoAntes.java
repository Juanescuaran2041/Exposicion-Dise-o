package grasp.altacohesion.antes;

import java.util.ArrayList;

public class DemoAntes {
    public static void ejecutar() {
        ArrayList<Compra> compras = new ArrayList<Compra>();
        for (int i = 1; i <= 5; i++) {
            compras.add(new Compra("C" + i, 50000));
        }
        Usuario ana = new Usuario("Ana", "ana@mail.com", "1234", compras);

        System.out.println("ANTES  (una clase, cinco temas)");
        System.out.println("  clave correcta: " + ana.claveCoincide("1234"));
        ana.guardarEnBaseDeDatos();
        ana.enviarCorreoBienvenida();
        System.out.println("    " + ana.exportarReporte());
        System.out.printf("    descuento = %.0f%%%n", ana.calcularDescuento() * 100);
        System.out.println("  Usuario mezcla: datos + base de datos + correo + reportes + mercadeo");
        System.out.println();
    }
}
