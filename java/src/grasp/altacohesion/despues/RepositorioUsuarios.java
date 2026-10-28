package grasp.altacohesion.despues;

public class RepositorioUsuarios {

    public void guardar(Usuario usuario) {
        System.out.println("    [base de datos] INSERT INTO usuario ('"
                + usuario.getNombre() + "')");
    }
}
