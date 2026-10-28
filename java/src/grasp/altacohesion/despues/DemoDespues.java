package grasp.altacohesion.despues;

import java.util.ArrayList;

public class DemoDespues {
    public static void ejecutar() {
        ArrayList<Compra> compras = new ArrayList<Compra>();
        compras.add(new Compra(100000));
        compras.add(new Compra(50000));
        Usuario ana = new Usuario("Ana", "ana@correo.com", compras);

        System.out.println("DESPUES");
        new RepositorioUsuarios().guardar(ana);
        new ServicioCorreo().bienvenida(ana);
        System.out.println("  " + new ReporteUsuarios().generar(ana));
        System.out.printf("  descuento = %.0f%%%n",
                new ProgramaFidelidad().descuento(ana) * 100);
        System.out.println("  Usuario solo habla del usuario.");
        System.out.println();
    }
}
