package grasp.altacohesion.despues;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String email;
    private ArrayList<Compra> compras;

    public Usuario(String nombre, String email, ArrayList<Compra> compras) {
        this.nombre = nombre;
        this.email = email;
        this.compras = compras;
    }

    // Un solo tema: el usuario.
    public String getNombre() { return nombre; }
    public String getEmail()  { return email; }
    public int comprasRealizadas() { return compras.size(); }
}
