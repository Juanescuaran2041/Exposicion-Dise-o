package grasp.fabricacionpura.despues;

import grasp.fabricacionpura.comun.BaseDeDatos;

public class DemoDespues {
    public static void ejecutar() {
        // el producto se crea solo, sin base de datos
        Producto teclado = new Producto("TEC-1", "Teclado", 100000);
        Producto mouse   = new Producto("MOU-1", "Mouse",    40000);

        System.out.println("DESPUES");
        System.out.printf("  precio con IVA = $%,.0f   (Producto no sabe de bases de datos)%n",
                teclado.precioConIva());

        RepositorioProductos repositorio = new RepositorioProductos(new BaseDeDatos());
        repositorio.guardar(teclado);
        repositorio.guardar(mouse);

        System.out.println("  guardados = " + repositorio.todos().size());

        Producto encontrado = repositorio.buscar("MOU-1");
        System.out.println("  buscar(\"MOU-1\") -> " + encontrado.getNombre());
        System.out.println("  buscar(\"XXX\")   -> " + repositorio.buscar("XXX"));
        System.out.println();
    }
}
