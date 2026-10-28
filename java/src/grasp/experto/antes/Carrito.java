package grasp.experto.antes;

import java.util.ArrayList;
import java.util.List;

/** Carrito anémico: expone su lista para que otros la recorran. */
public class Carrito {
    private final List<Linea> lineas = new ArrayList<>();

    public void agregar(Linea linea) { lineas.add(linea); }

    /** Fuga de encapsulamiento: cualquiera puede recorrer y modificar. */
    public List<Linea> getLineas() { return lineas; }
}
