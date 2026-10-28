package grasp.altacohesion.antes;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * PROBLEMA: una "clase Dios" con cinco motivos distintos para cambiar.
 *
 *   1. modelo del usuario        (nombre, email, clave)
 *   2. persistencia              (JDBC, SQL, conexiones)
 *   3. mensajería                (SMTP, plantillas de correo)
 *   4. reportes                  (formato PDF)
 *   5. reglas de mercadeo        (porcentajes de fidelidad)
 *
 * Síntomas de baja cohesión:
 *  - el archivo crece sin parar y lo editan cinco personas distintas;
 *  - para probar "la clave coincide" hay que arrastrar BD, SMTP y PDF;
 *  - un cambio en la tabla de la BD obliga a recompilar al dominio;
 *  - el nombre de la clase ya no describe lo que hace.
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
        this.compras = compras;
    }

    // --- 1. lo que SÍ es del usuario ---
    public boolean claveCoincide(String clave) { return hash(clave).equals(claveHash); }
    public String getNombre() { return nombre; }
    public String getEmail()  { return email; }

    // --- 2. persistencia: ¿qué hace JDBC dentro del dominio? ---
    public void guardarEnBaseDeDatos() throws SQLException {
        try (Connection cx = DriverManager.getConnection("jdbc:mysql://localhost/tienda");
             PreparedStatement ps = cx.prepareStatement(
                     "INSERT INTO usuario (nombre, email, clave) VALUES (?, ?, ?)")) {
            ps.setString(1, nombre);
            ps.setString(2, email);
            ps.setString(3, claveHash);
            ps.executeUpdate();
        }
    }

    // --- 3. mensajería ---
    public void enviarCorreoBienvenida() {
        System.out.println("        [SMTP] a " + email + ": ¡Bienvenido, " + nombre + "!");
    }

    // --- 4. reportes ---
    public byte[] exportarPDF() {
        String contenido = "%PDF-1.4 Usuario: " + nombre + " (" + email + ")";
        return contenido.getBytes(StandardCharsets.UTF_8);
    }

    // --- 5. reglas de mercadeo ---
    public double calcularDescuento() {
        if (compras.size() > 10) return 0.15;
        if (compras.size() > 3)  return 0.08;
        return 0.0;
    }

    private static String hash(String clave) { return "h:" + clave.hashCode(); }
}
