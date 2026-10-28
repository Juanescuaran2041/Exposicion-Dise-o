package grasp.experto.antes;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<Linea> lineas = new ArrayList<Linea>();

    public void agregar(Linea linea) {
        lineas.add(linea);
    }

    public ArrayList<Linea> getLineas() {
        return lineas;
    }
}
