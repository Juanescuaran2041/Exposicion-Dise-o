package grasp.altacohesion.despues;

import java.util.ArrayList;

public class RepositorioUsuarios {
    private ArrayList<Usuario> almacen = new ArrayList<Usuario>();

    public void guardar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre, email, clave) VALUES ('"
                + usuario.getNombre() + "', '" + usuario.getEmail()
                + "', '" + usuario.getClaveHash() + "')";
        System.out.println("    [base de datos] " + sql);
        almacen.add(usuario);
    }

    public Usuario porEmail(String email) {
        for (Usuario usuario : almacen) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    public ArrayList<Usuario> todos() {
        return new ArrayList<Usuario>(almacen);
    }
}
