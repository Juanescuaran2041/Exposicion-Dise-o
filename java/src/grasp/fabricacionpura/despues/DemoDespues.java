package grasp.fabricacionpura.despues;

import grasp.fabricacionpura.comun.BaseDeDatos;

public class DemoDespues {
    public static void ejecutar() {
        Producto teclado = new Producto("TEC-1", 100000);
        RepositorioProductos repositorio = new RepositorioProductos(new BaseDeDatos());

        System.out.println("DESPUES");
        System.out.printf("  precio con IVA = $%,.0f%n", teclado.precioConIva());
        repositorio.guardar(teclado);
        repositorio.eliminar(teclado);
        System.out.println("  Producto volvio a ser solo negocio.");
        System.out.println();
    }
}
