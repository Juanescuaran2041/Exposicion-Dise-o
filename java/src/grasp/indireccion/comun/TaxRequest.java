package grasp.indireccion.comun;

/** Tipo de la librería externa: así lo definió el proveedor, no nosotros. */
public record TaxRequest(String countryCode, long amountCents, String docType) { }
