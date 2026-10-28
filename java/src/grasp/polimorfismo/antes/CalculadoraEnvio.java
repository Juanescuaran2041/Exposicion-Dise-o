package grasp.polimorfismo.antes;

/**
 * PROBLEMA: el comportamiento varía según el tipo, y la variación se
 * resuelve con condicionales sobre un String.
 *
 * Síntomas:
 *  - el MISMO switch aparece repetido en cada operación (costo, días,
 *    etiqueta, seguro...). Agregar "DRON" obliga a buscarlos todos;
 *  - si se olvida uno, el error aparece en ejecución, no al compilar;
 *  - el tipo es un String: "express", "EXPRESS" y "Expres" compilan igual;
 *  - esta clase tiene que cambiar cada vez que el negocio agrega un envío,
 *    aunque los envíos que ya existían no cambiaron nada.
 */
public class CalculadoraEnvio {

    public double costo(String tipo, double kg) {
        switch (tipo) {
            case "ESTANDAR":      return  5_000 + kg * 1_000;
            case "EXPRESS":       return 12_000 + kg * 2_000;
            case "INTERNACIONAL": return 30_000 + kg * 4_500;
            default: throw new IllegalArgumentException("Tipo desconocido: " + tipo);
        }
    }

    public int diasEntrega(String tipo) {
        switch (tipo) {                       // ...el mismo switch otra vez
            case "ESTANDAR":      return 5;
            case "EXPRESS":       return 1;
            case "INTERNACIONAL": return 15;
            default: throw new IllegalArgumentException("Tipo desconocido: " + tipo);
        }
    }

    public boolean requiereAduana(String tipo) {
        return "INTERNACIONAL".equals(tipo);  // ...y otra condicional por tipo
    }

    public String etiqueta(String tipo) {
        switch (tipo) {                       // ...y otra
            case "ESTANDAR":      return "Estándar";
            case "EXPRESS":       return "Express 24h";
            case "INTERNACIONAL": return "Internacional";
            default: throw new IllegalArgumentException("Tipo desconocido: " + tipo);
        }
    }
}
