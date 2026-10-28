# Los 9 patrones GRASP · ejemplos en Java

Un paquete por patrón. Cada uno muestra **el mismo caso de uso dos veces**:
el diseño con el problema (`antes`) y el diseño aplicando el patrón (`despues`).
Las dos versiones se ejecutan y se comparan en la consola, así se ve que GRASP
no cambia *qué* hace el programa, sino *quién* lo hace.

## Cómo ejecutar

**Opción 1 — scripts (PowerShell, en esta carpeta):**

```powershell
.\compilar.ps1          # compila src/ hacia out/
.\ejecutar.ps1          # corre los 9 patrones
.\ejecutar.ps1 3        # corre solo el patrón 3
.\ejecutar.ps1 experto  # o por nombre
```

**Opción 2 — a mano:**

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java | % FullName)
java "-Dstdout.encoding=UTF-8" -cp out grasp.Main
java "-Dstdout.encoding=UTF-8" -cp out grasp.experto.Demo   # un solo patrón
```

Requiere **JDK 17 o superior** (se usan `record`, `var`, `switch` con flechas y
bloques de texto). Si los acentos salen como `?`, ejecuta antes `chcp 65001`.

## Los 9 paquetes

| # | Paquete | Patrón | Pregunta que responde | Qué muestra el ejemplo |
|---|---------|--------|----------------------|------------------------|
| 1 | `grasp.experto` | Experto en Información | ¿Quién hace la tarea? | `ServicioCaja` recorría `Carrito → Línea → Producto` para sumar; ahora cada objeto calcula lo suyo (3 dependencias → 1) |
| 2 | `grasp.creador` | Creador | ¿Quién crea el objeto? | La UI hacía `new LineaPedido` y metía mano en la lista del pedido; ahora `Pedido` crea sus líneas, las agrupa y devuelve copias inmutables |
| 3 | `grasp.controlador` | Controlador | ¿Quién recibe el evento del sistema? | Un botón validaba stock, cobraba, guardaba y notificaba; ahora `ControladorCompra` coordina y el mismo caso de uso se invoca sin UI |
| 4 | `grasp.bajoacoplamiento` | Bajo Acoplamiento | ¿Qué diseño crea menos dependencias? | `Caja` conocía 5 clases para registrar un pago; ahora conoce `Venta` y `Venta` protege su invariante |
| 5 | `grasp.altacohesion` | Alta Cohesión | ¿Esta clase habla de un solo tema? | `Usuario` hacía JDBC + SMTP + PDF + mercadeo; ahora son 5 clases y el dominio se prueba sin BD |
| 6 | `grasp.polimorfismo` | Polimorfismo | ¿Cómo evito preguntar el tipo? | 4 `switch` sobre un `String`; ahora cada `Envio` sabe su costo y el tipo nuevo (`EnvioDron`) no tocó nada |
| 7 | `grasp.fabricacionpura` | Fabricación Pura | ¿Y si ninguna clase del dominio encaja? | `Producto` abría conexiones JDBC; ahora un `RepositorioProductos` inventado persiste (en memoria y en SQL) |
| 8 | `grasp.indireccion` | Indirección | ¿Cómo desacoplo dos partes? | 3 clases copiaban la llamada a la API de impuestos (y una olvidó el respaldo: se ve el bug); ahora media `ServicioImpuestos` |
| 9 | `grasp.variacionesprotegidas` | Variaciones Protegidas | ¿Qué va a cambiar mañana? | `Checkout` estaba casado con el SDK de PayPal; ahora usa `PasarelaPago` y funciona con PayPal, Stripe y Nequi sin tocarse |

## Estructura

```
src/grasp/
├── Main.java                   ← ejecuta los 9 demos
├── experto/
│   ├── Demo.java               ← corre antes y después y compara
│   ├── antes/                  ← el diseño con el problema
│   └── despues/                ← el diseño con el patrón
├── creador/            {Demo, antes, despues}
├── controlador/        {Demo, antes, despues, comun}
├── bajoacoplamiento/   {Demo, antes, despues, comun}
├── altacohesion/       {Demo, antes, despues}
├── polimorfismo/       {Demo, antes, despues}
├── fabricacionpura/    {Demo, antes, despues}
├── indireccion/        {Demo, antes, despues, comun}
└── variacionesprotegidas/ {Demo, antes, despues, comun}
```

`comun/` guarda los colaboradores que **no cambian** entre las dos versiones
(inventario, pasarela de pago, la API externa simulada...). Así, al comparar
`antes` con `despues`, la única diferencia es la asignación de responsabilidades.

## Cómo leer los ejemplos

1. Abre primero `antes/`: el comentario de la clase principal explica el
   problema y sus consecuencias.
2. Abre `despues/`: el comentario explica por qué el patrón resuelve eso.
3. Corre el `Demo` del paquete: imprime las dos versiones y la métrica que
   cambió (dependencias, razones de cambio, clases acopladas a la API...).

Los ejemplos están escritos para leerse en una exposición, así que simulan la
infraestructura (BD, correo, pasarelas, API de impuestos) en vez de usarla.
Los dos únicos sitios con JDBC real son `altacohesion/antes/Usuario.java` y
`fabricacionpura/antes/Producto.java`: fallan a propósito al ejecutarse, y ese
fallo *es* la lección (un dominio acoplado a la BD no se puede probar solo).

## Aviso

Ninguno de los nueve patrones es una regla obligatoria. Son **criterios** para
decidir dónde poner una responsabilidad, y a veces se contradicen entre sí:
el Experto en Información empujaría el SQL hacia `Producto`, y la Alta Cohesión
lo saca de ahí. Diseñar es sopesar esos criterios, no aplicarlos todos a la vez.
