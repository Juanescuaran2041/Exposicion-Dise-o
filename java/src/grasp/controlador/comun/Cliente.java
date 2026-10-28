package grasp.controlador.comun;

public class Cliente {
    private String nombre;
    private String tarjeta;

    public Cliente(String nombre, String tarjeta) {
        this.nombre = nombre;
        this.tarjeta = tarjeta;
    }

    public String getNombre()  { return nombre; }
    public String getTarjeta() { return tarjeta; }
}
