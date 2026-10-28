package grasp.controlador.comun;

public class Inventario {
    private int disponibles;

    public Inventario(int disponibles) {
        this.disponibles = disponibles;
    }

    public boolean reservar(int unidades) {
        if (unidades > disponibles) {
            return false;
        }
        disponibles = disponibles - unidades;
        return true;
    }

    public void liberar(int unidades) {
        disponibles = disponibles + unidades;
    }

    public int getDisponibles() { return disponibles; }
}
