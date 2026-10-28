package grasp;

/**
 * Los 9 patrones GRASP (General Responsibility Assignment Software Patterns)
 * con un ejemplo "antes / después" ejecutable por cada uno.
 *
 * Un paquete por patrón, y dentro de cada paquete:
 *   antes/    -> el diseño con el problema
 *   despues/  -> el mismo caso aplicando el patrón
 *   comun/    -> colaboradores compartidos (cuando el ejemplo los necesita)
 *   Demo.java -> ejecuta las dos versiones y compara el resultado
 *
 * Ejecutar todo:        java -cp out grasp.Main
 * Ejecutar uno solo:    java -cp out grasp.experto.Demo
 */
public final class Main {

    public static void main(String[] args) {
        System.out.println("""
                ============================================================
                   LOS 9 PATRONES GRASP - ejemplos en Java (antes/despues)
                   Quien debe hacer cada tarea?
                ============================================================
                """);

        if (args.length > 0) {
            ejecutarUno(args[0]);
            return;
        }

        grasp.experto.Demo.main(args);
        grasp.creador.Demo.main(args);
        grasp.controlador.Demo.main(args);
        grasp.bajoacoplamiento.Demo.main(args);
        grasp.altacohesion.Demo.main(args);
        grasp.polimorfismo.Demo.main(args);
        grasp.fabricacionpura.Demo.main(args);
        grasp.indireccion.Demo.main(args);
        grasp.variacionesprotegidas.Demo.main(args);

        System.out.println("""
                ------------------------------------------------------------
                RESUMEN

                  1. Experto en Información  hace la tarea quien tiene los datos
                  2. Creador                 crea A quien contiene o inicializa a A
                  3. Controlador             un coordinador recibe los eventos del sistema
                  4. Bajo Acoplamiento       depender de pocas clases
                  5. Alta Cohesión           cada clase, un propósito
                  6. Polimorfismo            mismo mensaje, distinto comportamiento
                  7. Fabricación Pura        inventar una clase técnica
                  8. Indirección             poner un intermediario
                  9. Variaciones Protegidas  aislar lo que puede cambiar

                Los nueve persiguen lo mismo: mayor cohesión y menor acoplamiento.
                ------------------------------------------------------------""");
    }

    private static void ejecutarUno(String patron) {
        String[] vacio = {};
        switch (patron.toLowerCase()) {
            case "1", "experto"        -> grasp.experto.Demo.main(vacio);
            case "2", "creador"        -> grasp.creador.Demo.main(vacio);
            case "3", "controlador"    -> grasp.controlador.Demo.main(vacio);
            case "4", "acoplamiento"   -> grasp.bajoacoplamiento.Demo.main(vacio);
            case "5", "cohesion"       -> grasp.altacohesion.Demo.main(vacio);
            case "6", "polimorfismo"   -> grasp.polimorfismo.Demo.main(vacio);
            case "7", "fabricacion"    -> grasp.fabricacionpura.Demo.main(vacio);
            case "8", "indireccion"    -> grasp.indireccion.Demo.main(vacio);
            case "9", "variaciones"    -> grasp.variacionesprotegidas.Demo.main(vacio);
            default -> System.out.println("Patrón desconocido: " + patron + """
                    
                    Usa un número del 1 al 9, o uno de estos nombres:
                    experto, creador, controlador, acoplamiento, cohesion,
                    polimorfismo, fabricacion, indireccion, variaciones""");
        }
    }

    private Main() { }
}
