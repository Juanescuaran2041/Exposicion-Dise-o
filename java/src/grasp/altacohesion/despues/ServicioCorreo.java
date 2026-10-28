package grasp.altacohesion.despues;

/** Responsabilidad única: enviar correos. */
public class ServicioCorreo {
    public void bienvenida(Usuario u) {
        System.out.println("        [SMTP] a " + u.email() + ": ¡Bienvenido, " + u.nombre() + "!");
    }
}
