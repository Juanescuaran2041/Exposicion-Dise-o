package grasp.fabricacionpura.comun;

import java.util.ArrayList;

public class BaseDeDatos {
    private ArrayList<String> instrucciones = new ArrayList<String>();

    public void ejecutar(String instruccion) {
        instrucciones.add(instruccion);
        System.out.println("    [base de datos] " + instruccion);
    }

    public int instruccionesEjecutadas() {
        return instrucciones.size();
    }
}
