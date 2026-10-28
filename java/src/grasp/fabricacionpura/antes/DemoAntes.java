package grasp.fabricacionpura.antes;

import grasp.fabricacionpura.comun.BaseDeDatos;

public class DemoAntes {
    public static void ejecutar() {
        BaseDeDatos baseDeDatos = new BaseDeDatos();

        // para crear un producto ya hay que pasarle la base de datos
        Producto teclado = new Producto("TEC-1", "Teclado", 100000, baseDeDatos);

        System.out.println("ANTES");
        System.out.printf("  precio con IVA = $%,.0f   (esto si es del negocio)%n",
                teclado.precioConIva());
        teclado.guardar();
        teclado.eliminar();
        System.out.println("  Producto sabe de SQL, de tablas y de columnas,");
        System.out.println("  y no se puede crear uno sin una base de datos.");
        System.out.println();
    }
}
