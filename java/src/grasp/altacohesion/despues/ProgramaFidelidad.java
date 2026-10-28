package grasp.altacohesion.despues;

public class ProgramaFidelidad {
    public double descuento(Usuario usuario) {
        if (usuario.comprasRealizadas() > 10) {
            return 0.15;
        }
        if (usuario.comprasRealizadas() > 3) {
            return 0.08;
        }
        return 0.0;
    }

    public String nivel(Usuario usuario) {
        if (usuario.comprasRealizadas() > 10) {
            return "ORO";
        }
        if (usuario.comprasRealizadas() > 3) {
            return "PLATA";
        }
        return "BRONCE";
    }
}
