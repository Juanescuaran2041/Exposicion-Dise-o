package grasp.experto.despues;

import java.util.ArrayList;
import java.util.List;

/**
 * EXPERTO del total: Carrito tiene las líneas, así que él las suma.
 * Ya no necesita exponer su lista: expone el resultado.
 */
public class Carrito {
    private final List<Linea> lineas = new ArrayList<>();

    public Carrito agregar(Linea linea) {
        lineas.add(linea);
        return this;
    }

    /** Tiene las líneas -> él calcula el total. */
    public double total() {
        return lineas.stream().mapToDouble(Linea::subtotal).sum();
    }

    public int cantidadDeLineas() { return lineas.size(); }

    /** Copia inmutable: se puede leer, no romper. */
    public List<Linea> lineas() { return List.copyOf(lineas); }
}
