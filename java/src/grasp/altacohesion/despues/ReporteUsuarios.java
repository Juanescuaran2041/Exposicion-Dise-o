package grasp.altacohesion.despues;

import java.nio.charset.StandardCharsets;
import java.util.List;

/** Responsabilidad única: armar reportes. */
public class ReporteUsuarios {
    public byte[] pdf(List<Usuario> usuarios) {
        StringBuilder sb = new StringBuilder("%PDF-1.4\n");
        usuarios.forEach(u -> sb.append(u.nombre()).append(" <").append(u.email()).append(">\n"));
        return sb.toString().getBytes(StandardCharsets.UTF_8);
    }
}
