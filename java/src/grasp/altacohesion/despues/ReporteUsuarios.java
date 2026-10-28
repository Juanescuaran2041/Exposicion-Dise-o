package grasp.altacohesion.despues;

import java.util.ArrayList;

public class ReporteUsuarios {
    public String generar(ArrayList<Usuario> usuarios) {
        String reporte = "REPORTE DE USUARIOS";
        for (Usuario usuario : usuarios) {
            reporte = reporte + "\n      - " + usuario.getNombre()
                    + " <" + usuario.getEmail() + "> compras: "
                    + usuario.comprasRealizadas();
        }
        return reporte;
    }
}
