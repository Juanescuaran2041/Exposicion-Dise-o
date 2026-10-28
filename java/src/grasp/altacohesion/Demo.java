package grasp.altacohesion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * PATRÓN 5 · ALTA COHESIÓN (High Cohesion)
 *
 * Cada clase debe tener responsabilidades fuertemente relacionadas.
 * Pregunta útil: "¿puedo describir lo que hace esta clase en una frase
 * sin usar la palabra Y?"
 */
public final class Demo {

    public static void main(String[] args) {
        System.out.println("=== 5. ALTA COHESIÓN ===\n");

        List<grasp.altacohesion.antes.Compra> comprasA = new ArrayList<>();
        List<grasp.altacohesion.despues.Compra> comprasD = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            comprasA.add(new grasp.altacohesion.antes.Compra("C" + i, 50_000, LocalDate.now()));
            comprasD.add(new grasp.altacohesion.despues.Compra("C" + i, 50_000, LocalDate.now()));
        }

        // ---------- ANTES ----------
        var uAntes = new grasp.altacohesion.antes.Usuario("Ana", "ana@mail.com", "1234", comprasA);
        System.out.println("ANTES  (una clase, cinco temas)");
        System.out.println("  clave correcta: " + uAntes.claveCoincide("1234"));
        uAntes.enviarCorreoBienvenida();
        System.out.println("        PDF de " + uAntes.exportarPDF().length + " bytes");
        System.out.printf("        descuento = %.0f%%%n", uAntes.calcularDescuento() * 100);
        try {
            uAntes.guardarEnBaseDeDatos();
        } catch (Exception e) {
            System.out.println("        guardarEnBaseDeDatos() -> "
                    + e.getClass().getSimpleName() + ": sin BD no se puede ni probar el dominio");
        }
        System.out.println("  Usuario mezcla: modelo + JDBC + SMTP + PDF + mercadeo\n");

        // ---------- DESPUÉS ----------
        var u = new grasp.altacohesion.despues.Usuario("Ana", "ana@mail.com", "1234", comprasD);
        var repo = new grasp.altacohesion.despues.RepositorioUsuarios();
        var correo = new grasp.altacohesion.despues.ServicioCorreo();
        var reporte = new grasp.altacohesion.despues.ReporteUsuarios();
        var fidelidad = new grasp.altacohesion.despues.ProgramaFidelidad();

        System.out.println("DESPUÉS  (cinco clases, un tema cada una)");
        System.out.println("  clave correcta: " + u.claveCoincide("1234") + "   (probado sin BD, sin SMTP)");
        repo.guardar(u);
        correo.bienvenida(u);
        System.out.println("        PDF de " + reporte.pdf(repo.todos()).length + " bytes");
        System.out.printf("        nivel %s · descuento = %.0f%%%n",
                fidelidad.nivel(u), fidelidad.descuento(u) * 100);
        System.out.println("        usuarios en el repositorio: " + repo.todos().size());

        System.out.println("\nRazones de cambio de Usuario:  antes 5  ->  después 1\n");
    }

    private Demo() { }
}
