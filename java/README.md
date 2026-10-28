# Los 9 patrones GRASP · ejemplos en Java

Un paquete por patrón. Cada uno muestra **el mismo caso dos veces**: el diseño
con el problema (`antes`) y el diseño aplicando el patrón (`despues`). Las dos
versiones se ejecutan y se comparan en la consola, así se ve que GRASP no
cambia *qué* hace el programa, sino *quién* lo hace.

## Cómo ejecutar

**Con los scripts (PowerShell, parado en esta carpeta):**

```powershell
.\compilar.ps1          # compila src/ hacia out/
.\ejecutar.ps1          # corre los 9 patrones
.\ejecutar.ps1 3        # corre solo el patrón 3
.\ejecutar.ps1 experto  # o por nombre
```

**A mano:**

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java | % FullName)
java "-Dstdout.encoding=UTF-8" -cp out grasp.Main
java "-Dstdout.encoding=UTF-8" -cp out grasp.experto.Demo   # un solo patrón
```

Si los acentos salen como `?`, ejecuta antes `chcp 65001` (es la consola de
Windows, no el programa).

## Qué Java se usa

A propósito, solo lo básico: clases, atributos, constructores, getters,
`for`, `if`, `ArrayList`, `HashMap`, interfaces, herencia, `enum` y
excepciones. **No** hay conexiones a bases de datos, ni `record`, ni streams,
ni lambdas, ni `Optional`. Las partes "técnicas" (la base de datos, el
servidor de correo, las pasarelas de pago, la API de impuestos) están
**simuladas** con clases pequeñas que solo imprimen lo que harían, para que
todo se ejecute sin instalar nada.

## Los 9 paquetes

| # | Paquete | Patrón | Qué muestra el ejemplo |
|---|---------|--------|------------------------|
| 1 | `grasp.experto` | Experto en Información | `ServicioCaja` recorría `Carrito → Línea → Producto` y aplicaba él mismo descuento e IVA; ahora cada clase calcula lo suyo (3 dependencias → 1) |
| 2 | `grasp.creador` | Creador | La pantalla hacía `new LineaPedido` y metía mano en la lista; ahora `Pedido` crea sus líneas, agrupa los repetidos y entrega copias |
| 3 | `grasp.controlador` | Controlador | El botón validaba, cobraba, guardaba, notificaba y liberaba la reserva; ahora `ControladorCompra` coordina y el caso de uso se llama sin pantalla |
| 4 | `grasp.bajoacoplamiento` | Bajo Acoplamiento | `Caja` conocía 5 clases para registrar un pago; ahora conoce 2 y `Venta` cuida su propia regla |
| 5 | `grasp.altacohesion` | Alta Cohesión | `Usuario` guardaba, enviaba correos, hacía reportes y calculaba descuentos; ahora son 5 clases con un tema cada una |
| 6 | `grasp.polimorfismo` | Polimorfismo | 4 condicionales sobre un `String`; ahora cada `Envio` sabe lo suyo y el tipo nuevo (`EnvioDron`) no obligó a tocar nada |
| 7 | `grasp.fabricacionpura` | Fabricación Pura | `Producto` armaba el SQL y cargaba la base de datos; ahora lo hace un `RepositorioProductos` inventado |
| 8 | `grasp.indireccion` | Indirección | 3 clases copiaban la llamada a la API de impuestos y a una se le olvidó el plan B (el error se ve al ejecutar); ahora media `ServicioImpuestos` |
| 9 | `grasp.variacionesprotegidas` | Variaciones Protegidas | `Checkout` estaba casado con PayPal; ahora usa `PasarelaPago` y el mismo `Checkout` funciona con PayPal, Stripe y Nequi |

## Estructura de cada paquete

```
src/grasp/experto/
├── Demo.java              ← llama a las dos versiones (con import, no rutas)
├── antes/
│   ├── Producto.java  Linea.java  Carrito.java  ServicioCaja.java
│   └── DemoAntes.java     ← ejecuta la versión con el problema
└── despues/
    ├── Producto.java  Linea.java  Carrito.java  ServicioCaja.java
    └── DemoDespues.java   ← ejecuta la versión con el patrón
```

Las clases de `antes` y de `despues` se llaman igual a propósito: así se
comparan línea por línea. Como están en paquetes distintos, cada `DemoAntes` y
`DemoDespues` usa **sus** clases sin escribir rutas largas, y el `Demo` del
patrón solo importa esos dos:

```java
package grasp.experto;

import grasp.experto.antes.DemoAntes;
import grasp.experto.despues.DemoDespues;

public class Demo {
    public static void main(String[] args) {
        DemoAntes.ejecutar();
        DemoDespues.ejecutar();
    }
}
```

Algunos patrones tienen además una carpeta `comun/` con las clases que **no
cambian** entre las dos versiones (el inventario, la pasarela, la API
simulada). Así, al comparar `antes` con `despues`, lo único distinto es el
reparto de responsabilidades.

## Cómo leer los ejemplos

Las clases **no llevan comentarios explicativos**: la idea es que el código se
lea de un vistazo durante la exposición y que la explicación la den el diagrama
de la lámina y la tabla de arriba.

1. Abre `antes/` y `despues/` uno al lado del otro: las clases se llaman igual,
   así que la diferencia salta a la vista.
2. Corre el `Demo` del paquete: imprime las dos versiones y el número que
   cambió (dependencias, motivos de cambio, clases atadas a la API).

## Aviso

Ninguno de los nueve patrones es una regla obligatoria. Son **criterios** para
decidir dónde poner una responsabilidad, y a veces se contradicen: el Experto
en Información empujaría el SQL hacia `Producto`, y la Alta Cohesión lo saca de
ahí. Diseñar es sopesarlos, no aplicarlos todos a la vez.
