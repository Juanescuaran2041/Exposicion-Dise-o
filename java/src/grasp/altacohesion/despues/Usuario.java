package grasp.altacohesion.despues;

import java.util.List;

/**
 * SOLUCIÓN: Usuario queda con una sola razón de cambio: representar al
 * usuario. Sigue siendo EXPERTO de sus propios datos (por eso conserva
 * claveCoincide y comprasRealizadas), pero no sabe nada de BD, correo o PDF.
 *
 * Alta cohesión no es "clases con un solo método": es clases cuyos métodos
 * hablan todos del mismo tema.
 */
public class Usuario {

    private final String nombre;
    private final String email;
    private final String claveHash;
    private final List<Compra> compras;

    public Usuario(String nombre, String email, String clave, List<Compra> compras) {
        this.nombre = nombre;
        this.email = email;
        this.claveHash = hash(clave);
        this.compras = List.copyOf(compras);
    }

    public boolean claveCoincide(String clave) { return hash(clave).equals(claveHash); }

    public int comprasRealizadas()  { return compras.size(); }
    public double totalComprado()   { return compras.stream().mapToDouble(Compra::monto).sum(); }

    public String nombre()    { return nombre; }
    public String email()     { return email; }
    public String claveHash() { return claveHash; }

    private static String hash(String clave) { return "h:" + clave.hashCode(); }
}
