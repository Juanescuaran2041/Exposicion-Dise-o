package grasp.altacohesion.despues;

public class ReporteUsuarios {

    public String generar(Usuario usuario) {
        return "REPORTE | " + usuario.getNombre()
                + " | compras: " + usuario.comprasRealizadas();
    }
}
