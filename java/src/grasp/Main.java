package grasp;

public class Main {
    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println("  LOS 9 PATRONES GRASP - ejemplos en Java (antes/despues)");
        System.out.println("  ¿Quien debe hacer cada tarea?");
        System.out.println("============================================================");
        System.out.println();

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

        resumen();
    }

    private static void resumen() {
        System.out.println("------------------------------------------------------------");
        System.out.println("RESUMEN");
        System.out.println();
        System.out.println("  1. Experto en Informacion  hace la tarea quien tiene los datos");
        System.out.println("  2. Creador                 crea A quien contiene o inicializa a A");
        System.out.println("  3. Controlador             un coordinador recibe los eventos");
        System.out.println("  4. Bajo Acoplamiento       depender de pocas clases");
        System.out.println("  5. Alta Cohesion           cada clase, un proposito");
        System.out.println("  6. Polimorfismo            mismo mensaje, distinto comportamiento");
        System.out.println("  7. Fabricacion Pura        inventar una clase tecnica");
        System.out.println("  8. Indireccion             poner un intermediario");
        System.out.println("  9. Variaciones Protegidas  aislar lo que puede cambiar");
        System.out.println();
        System.out.println("Los nueve buscan lo mismo: mas cohesion y menos acoplamiento.");
        System.out.println("------------------------------------------------------------");
    }

    private static void ejecutarUno(String patron) {
        String[] vacio = {};
        String nombre = patron.toLowerCase();

        if (nombre.equals("1") || nombre.equals("experto")) {
            grasp.experto.Demo.main(vacio);
        } else if (nombre.equals("2") || nombre.equals("creador")) {
            grasp.creador.Demo.main(vacio);
        } else if (nombre.equals("3") || nombre.equals("controlador")) {
            grasp.controlador.Demo.main(vacio);
        } else if (nombre.equals("4") || nombre.equals("acoplamiento")) {
            grasp.bajoacoplamiento.Demo.main(vacio);
        } else if (nombre.equals("5") || nombre.equals("cohesion")) {
            grasp.altacohesion.Demo.main(vacio);
        } else if (nombre.equals("6") || nombre.equals("polimorfismo")) {
            grasp.polimorfismo.Demo.main(vacio);
        } else if (nombre.equals("7") || nombre.equals("fabricacion")) {
            grasp.fabricacionpura.Demo.main(vacio);
        } else if (nombre.equals("8") || nombre.equals("indireccion")) {
            grasp.indireccion.Demo.main(vacio);
        } else if (nombre.equals("9") || nombre.equals("variaciones")) {
            grasp.variacionesprotegidas.Demo.main(vacio);
        } else {
            System.out.println("Patron desconocido: " + patron);
            System.out.println("Usa un numero del 1 al 9, o uno de estos nombres:");
            System.out.println("  experto, creador, controlador, acoplamiento, cohesion,");
            System.out.println("  polimorfismo, fabricacion, indireccion, variaciones");
        }
    }
}
