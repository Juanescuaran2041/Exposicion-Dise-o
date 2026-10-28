package grasp.altacohesion.despues;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** Responsabilidad única: guardar y recuperar usuarios. */
public class RepositorioUsuarios {
    private final List<Usuario> almacen = new ArrayList<>();

    public void guardar(Usuario u) { almacen.add(u); }

    public Optional<Usuario> porEmail(String email) {
        return almacen.stream().filter(u -> u.email().equals(email)).findFirst();
    }

    public List<Usuario> todos() { return List.copyOf(almacen); }
}
