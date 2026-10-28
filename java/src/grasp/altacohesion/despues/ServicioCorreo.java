package grasp.altacohesion.despues;

public class ServicioCorreo {

    public void bienvenida(Usuario usuario) {
        System.out.println("    [correo a " + usuario.getEmail() + "] Bienvenido, "
                + usuario.getNombre() + "!");
    }
}
