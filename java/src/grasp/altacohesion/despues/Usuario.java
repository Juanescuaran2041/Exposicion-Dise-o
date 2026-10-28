package grasp.altacohesion.despues;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String email;
    private String claveHash;
    private ArrayList<Compra> compras;

    public Usuario(String nombre, String email, String clave, ArrayList<Compra> compras) {
        this.nombre = nombre;
        this.email = email;
        this.claveHash = "hash:" + clave.length();
        this.compras = compras;
    }

    public boolean claveCoincide(String clave) {
        return claveHash.equals("hash:" + clave.length());
    }

    public int comprasRealizadas() {
        return compras.size();
    }

    public double totalComprado() {
        double total = 0;
        for (Compra compra : compras) {
            total = total + compra.getMonto();
        }
        return total;
    }

    public String getNombre()    { return nombre; }
    public String getEmail()     { return email; }
    public String getClaveHash() { return claveHash; }
}
