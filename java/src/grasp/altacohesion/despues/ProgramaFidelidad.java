package grasp.altacohesion.despues;

/**
 * Responsabilidad única: las reglas de fidelidad.
 * Mercadeo cambia los porcentajes todos los meses y solo toca este archivo.
 */
public class ProgramaFidelidad {

    public double descuento(Usuario u) {
        if (u.comprasRealizadas() > 10) return 0.15;
        if (u.comprasRealizadas() > 3)  return 0.08;
        return 0.0;
    }

    public String nivel(Usuario u) {
        if (u.comprasRealizadas() > 10) return "ORO";
        if (u.comprasRealizadas() > 3)  return "PLATA";
        return "BRONCE";
    }
}
