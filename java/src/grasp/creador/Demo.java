package grasp.creador;

/**
 * PATRÓN 2 · CREADOR (Creator)
 *
 * B debe crear instancias de A si:
 *   - B contiene o agrega objetos A,      <- este es el caso del ejemplo
 *   - B registra instancias de A,
 *   - B usa A muy de cerca,
 *   - B tiene los datos de inicialización de A.
 */
public final class Demo {

    public static void main(String[] args) {
        System.out.println("=== 2. CREADOR ===\n");

        // ---------- ANTES: la UI construye las líneas ----------
        var teclado = new grasp.creador.antes.Producto("TEC-1", "Teclado", 100_000);
        var pedidoAntes = new grasp.creador.antes.Pedido("P-001");
        var pantallaAntes = new grasp.creador.antes.PantallaCompra();

        pantallaAntes.agregar(pedidoAntes, teclado, 1);
        pantallaAntes.agregar(pedidoAntes, teclado, 2);     // mismo producto

        System.out.println("ANTES");
        System.out.printf("  líneas = %d · total = $%,.0f%n",
                pedidoAntes.getLineas().size(), pedidoAntes.total());

        // Y como getLineas() entrega la lista real, cualquiera la rompe:
        pedidoAntes.getLineas().clear();
        System.out.printf("  alguien llamó getLineas().clear() -> líneas = %d · total = $%,.0f%n",
                pedidoAntes.getLineas().size(), pedidoAntes.total());
        System.out.println("  Pedido no pudo defender su propio contenido.\n");

        // ---------- DESPUÉS: Pedido crea sus líneas ----------
        var tecladoD = new grasp.creador.despues.Producto("TEC-1", "Teclado", 100_000);
        var pedido = new grasp.creador.despues.Pedido("P-001");
        var pantalla = new grasp.creador.despues.PantallaCompra();

        pantalla.agregar(pedido, tecladoD, 1);
        pantalla.agregar(pedido, tecladoD, 2);              // se agrupa solo

        System.out.println("DESPUÉS");
        System.out.printf("  líneas = %d · total = $%,.0f%n", pedido.lineas().size(), pedido.total());
        for (var l : pedido.lineas()) System.out.println("  " + l.descripcion());

        try {
            pedido.lineas().clear();                        // copia inmutable
        } catch (UnsupportedOperationException e) {
            System.out.println("  intentar lineas().clear() -> " + e.getClass().getSimpleName());
        }
        System.out.printf("  el pedido sigue intacto: %d línea(s)%n%n", pedido.lineas().size());

        System.out.println("Quién hace new LineaPedido:  antes la UI  ->  después Pedido\n");
    }

    private Demo() { }
}
