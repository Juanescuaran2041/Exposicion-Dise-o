package grasp.altacohesion.despues;

public class ProgramaFidelidad {

    public double descuento(Usuario usuario) {
        if (usuario.comprasRealizadas() > 3) {
            return 0.10;
        }
        return 0.0;
    }
}
