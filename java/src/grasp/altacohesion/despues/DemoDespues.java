package grasp.altacohesion.despues;

import java.util.ArrayList;

public class DemoDespues {
    public static void ejecutar() {
        ArrayList<Compra> compras = new ArrayList<Compra>();
        for (int i = 1; i <= 5; i++) {
            compras.add(new Compra("C" + i, 50000));
        }
        Usuario ana = new Usuario("Ana", "ana@mail.com", "1234", compras);

        RepositorioUsuarios repositorio = new RepositorioUsuarios();
        ServicioCorreo correo = new ServicioCorreo();
        ReporteUsuarios reporte = new ReporteUsuarios();
        ProgramaFidelidad fidelidad = new ProgramaFidelidad();

        System.out.println("DESPUES  (cinco clases, un tema cada una)");
        System.out.println("  clave correcta: " + ana.claveCoincide("1234"));
        repositorio.guardar(ana);
        correo.bienvenida(ana);
        System.out.println("    " + reporte.generar(repositorio.todos()));
        System.out.printf("    nivel %s · descuento = %.0f%%%n",
                fidelidad.nivel(ana), fidelidad.descuento(ana) * 100);
        System.out.printf("    total comprado = $%,.0f%n", ana.totalComprado());
        System.out.println("  Usuario solo habla del usuario.");
        System.out.println();
    }
}
