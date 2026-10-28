package grasp.altacohesion.antes;

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

    // --- 1. esto si es del usuario ---
    public String getNombre() { return nombre; }
    public String getEmail()  { return email; }
    public int comprasRealizadas() { return compras.size(); }

    // --- 2. base de datos ---
    public void guardarEnBaseDeDatos() {
        System.out.println("    [base de datos] INSERT INTO usuario ('" + nombre + "')");
    }

    // --- 3. correos ---
    public void enviarCorreoBienvenida() {
        System.out.println("    [correo a " + email + "] Bienvenido, " + nombre + "!");
    }

    // --- 4. reportes ---
    public String exportarReporte() {
        return "REPORTE | " + nombre + " | compras: " + compras.size();
    }

    // --- 5. mercadeo ---
    public double calcularDescuento() {
        if (compras.size() > 3) {
            return 0.10;
        }
        return 0.0;
    }
}
