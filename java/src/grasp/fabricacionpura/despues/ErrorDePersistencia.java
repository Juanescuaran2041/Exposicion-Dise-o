package grasp.fabricacionpura.despues;

/**
 * El repositorio traduce SQLException a una excepción propia:
 * así los que lo usan tampoco se acoplan a java.sql.
 */
public class ErrorDePersistencia extends RuntimeException {
    public ErrorDePersistencia(String mensaje, Throwable causa) { super(mensaje, causa); }
}
