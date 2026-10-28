package grasp.altacohesion.antes;

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

    // --- 1. esto si es del usuario ---
    public boolean claveCoincide(String clave) {
        return claveHash.equals("hash:" + clave.length());
    }

    public String getNombre() { return nombre; }
    public String getEmail()  { return email; }

    // --- 2. guardar en la base de datos ---
    public void guardarEnBaseDeDatos() {
        String sql = "INSERT INTO usuario (nombre, email, clave) VALUES ('"
                + nombre + "', '" + email + "', '" + claveHash + "')";
        System.out.println("    [base de datos] " + sql);
    }

    // --- 3. enviar correos ---
    public void enviarCorreoBienvenida() {
        System.out.println("    [correo a " + email + "] Bienvenido, " + nombre + "!");
    }

    // --- 4. reportes ---
    public String exportarReporte() {
        return "REPORTE | " + nombre + " | " + email + " | compras: " + compras.size();
    }

    // --- 5. reglas de mercadeo ---
    public double calcularDescuento() {
        if (compras.size() > 10) {
            return 0.15;
        }
        if (compras.size() > 3) {
            return 0.08;
        }
        return 0.0;
    }
}
