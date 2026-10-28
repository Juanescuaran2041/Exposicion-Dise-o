package grasp.experto.despues;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<Linea> lineas = new ArrayList<Linea>();

    public void agregar(Linea linea) {
        lineas.add(linea);
    }

    // El total lo sabe el carrito: el tiene las lineas.
    public double total() {
        double total = 0;
        for (Linea linea : lineas) {
            total = total + linea.subtotal();
        }
        return total;
    }
}
