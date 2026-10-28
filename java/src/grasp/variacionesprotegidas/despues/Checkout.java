package grasp.variacionesprotegidas.despues;

import grasp.variacionesprotegidas.comun.Pedido;
import grasp.variacionesprotegidas.comun.Recibo;

public class Checkout {
    private PasarelaPago pasarela;

    public Checkout(PasarelaPago pasarela) {
        this.pasarela = pasarela;
    }

    public Recibo pagar(Pedido pedido) {
        Cobro cobro = pasarela.cobrar(pedido.getTotal());
        return new Recibo(cobro.getReferencia(), cobro.getMonto());
    }
}
