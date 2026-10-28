package grasp.polimorfismo.antes;

public class CalculadoraEnvio {
    public double costo(String tipo, double kg) {
        switch (tipo) {
            case "ESTANDAR":      return  5000 + kg * 1000;
            case "EXPRESS":       return 12000 + kg * 2000;
            case "INTERNACIONAL": return 30000 + kg * 4500;
            default: throw new IllegalArgumentException("Tipo desconocido: " + tipo);
        }
    }

    public int diasEntrega(String tipo) {
        switch (tipo) {                      // el mismo switch otra vez
            case "ESTANDAR":      return 5;
            case "EXPRESS":       return 1;
            case "INTERNACIONAL": return 15;
            default: throw new IllegalArgumentException("Tipo desconocido: " + tipo);
        }
    }

    public String etiqueta(String tipo) {
        switch (tipo) {                      // y otra vez
            case "ESTANDAR":      return "Estandar";
            case "EXPRESS":       return "Express 24h";
            case "INTERNACIONAL": return "Internacional";
            default: throw new IllegalArgumentException("Tipo desconocido: " + tipo);
        }
    }

    public boolean requiereAduana(String tipo) {
        return tipo.equals("INTERNACIONAL");  // y una condicional mas
    }
}
