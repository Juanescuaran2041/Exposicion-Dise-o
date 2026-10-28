package grasp.fabricacionpura.antes;

import grasp.fabricacionpura.comun.BaseDeDatos;

public class DemoAntes {
    public static void ejecutar() {
        Producto teclado = new Producto("TEC-1", 100000, new BaseDeDatos());

        System.out.println("ANTES");
        System.out.printf("  precio con IVA = $%,.0f%n", teclado.precioConIva());
        teclado.guardar();
        teclado.eliminar();
        System.out.println("  Producto sabe de SQL y carga con la base de datos.");
        System.out.println();
    }
}
