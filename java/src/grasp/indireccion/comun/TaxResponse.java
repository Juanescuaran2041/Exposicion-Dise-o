package grasp.indireccion.comun;

/** Respuesta de la API externa: trae centavos y un código de estado. */
public record TaxResponse(int status, long amountCents) { }
