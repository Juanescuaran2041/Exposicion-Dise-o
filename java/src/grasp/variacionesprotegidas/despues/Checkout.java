package grasp.variacionesprotegidas.despues;

import grasp.variacionesprotegidas.comun.Pedido;

public class Checkout {
    private PasarelaPago pasarela;

    public Checkout(PasarelaPago pasarela) {
        this.pasarela = pasarela;
    }

    public Cobro pagar(Pedido pedido) {
        return pasarela.cobrar(pedido.getTotal());
    }
}
