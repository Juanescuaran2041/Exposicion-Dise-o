package grasp.controlador.comun;

public class Inventario {
    private int disponibles;

    public Inventario(int disponibles) {
        this.disponibles = disponibles;
    }

    public boolean reservar(Carrito carrito) {
        if (carrito.getUnidades() > disponibles) {
            return false;
        }
        disponibles = disponibles - carrito.getUnidades();
        return true;
    }

    public void liberar(Carrito carrito) {
        disponibles = disponibles + carrito.getUnidades();
    }

    public int getDisponibles() { return disponibles; }
}
