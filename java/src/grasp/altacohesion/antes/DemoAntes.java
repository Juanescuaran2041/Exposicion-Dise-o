package grasp.altacohesion.antes;

import java.util.ArrayList;

public class DemoAntes {
    public static void ejecutar() {
        ArrayList<Compra> compras = new ArrayList<Compra>();
        compras.add(new Compra(100000));
        compras.add(new Compra(50000));
        Usuario ana = new Usuario("Ana", "ana@correo.com", compras);

        System.out.println("ANTES");
        ana.guardarEnBaseDeDatos();
        ana.enviarCorreoBienvenida();
        System.out.println("  " + ana.exportarReporte());
        System.out.printf("  descuento = %.0f%%%n", ana.calcularDescuento() * 100);
        System.out.println("  Usuario habla de 5 temas: el mismo, base de datos,");
        System.out.println("  correos, reportes y mercadeo.");
        System.out.println();
    }
}
