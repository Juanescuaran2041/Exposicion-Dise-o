package grasp.controlador.comun;

public class Cliente {
    private String nombre;
    private String email;
    private String tarjeta;

    public Cliente(String nombre, String email, String tarjeta) {
        this.nombre = nombre;
        this.email = email;
        this.tarjeta = tarjeta;
    }

    public String getNombre()  { return nombre; }
    public String getEmail()   { return email; }
    public String getTarjeta() { return tarjeta; }
}
