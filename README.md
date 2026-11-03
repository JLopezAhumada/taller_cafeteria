# Taller: Sistema de Cafetería

TIFC2DEV-JAVA · Generation Colombia · 2026

Proyecto hecho en IntelliJ IDEA con Java 21. Todos los archivos están en la carpeta `src`.

| Archivo | Contenido |
|---|---|
| `Ejercicio1.java` | Variables y tipos de dato |
| `Ejercicio2.java` | Operadores |
| `Ejercicio3.java` | switch |
| `Ejercicio4.java` | while |
| `Ejercicio5.java` | do-while |
| `Ejercicio6.java` | for y arrays |
| `CajaRegistradora.java` | Ejercicio 7: Debugging (código corregido) |
| `SistemaCafeteria.java` | Parte 2: Sistema de turno de cafetería |

Para ejecutar cada uno, se abre el archivo en IntelliJ y se da clic en el botón verde de Run al lado del `main`.

---

## Parte 1: Respuestas escritas

### Ejercicio 1: Variables y tipos de dato

**¿Por qué usas double para el precio y no int? ¿Qué pasaría si declaras el precio como int y le asignas 3.50?**

Uso `double` porque el precio puede tener decimales y `int` solo guarda números enteros. Si declaro `int precio = 3.50;` el programa no compila, porque Java no deja guardar un decimal en un entero sin hacer un cast (sale el error "possible lossy conversion from double to int"). Y si hago el cast `(int) 3.50`, el valor queda en 3 y se pierden los 50 centavos.

### Ejercicio 2: Operadores

**¿Qué operador usaste para determinar si aplica el descuento? ¿Qué tipo de dato devuelve ese operador?**

Usé el operador relacional `>` (mayor que): `subtotal > 30000`. Ese operador devuelve un `boolean`, o sea `true` o `false`. Como 42.500 es mayor que 30.000, el resultado es `true` y sí aplica el descuento.

### Ejercicio 3: switch

**¿En qué situación preferirías usar switch en lugar de una cadena de if-else? ¿Hay algún caso en este ejercicio donde el switch no sería la mejor opción?**

Prefiero `switch` cuando comparo una sola variable contra varios valores exactos, como aquí con las letras B, F, C y P. Se lee más ordenado que muchos `if-else`.

El `switch` no sirve bien cuando hay que comparar rangos (por ejemplo "si el precio es mayor a 5.000") o condiciones combinadas, porque `switch` solo compara valores exactos. En este ejercicio, comida y postre tienen el mismo IVA (8%), y si solo quisiera saber el IVA un `if` con `categoria == 'C' || categoria == 'P'` también funcionaría bien.

### Ejercicio 4: while

**¿Qué ocurre si la condición del while nunca se vuelve falsa? ¿Cómo lo prevendrías en este caso?**

Si la condición nunca se vuelve falsa se forma un ciclo infinito: el programa se queda repitiendo y nunca termina. Para prevenirlo, dentro del `while` siempre resto las unidades del inventario (`inventario = inventario - consumoPorPedido;`), así el inventario va bajando y en algún momento queda en menos de 10 y el ciclo para.

### Ejercicio 5: do-while

**¿Por qué do-while es más apropiado que while aquí? Describe con tus palabras la diferencia en el orden de ejecución.**

Porque el cajero siempre tiene que ingresar el monto por lo menos una vez, y el `do-while` garantiza que el bloque se ejecute al menos una vez. En el `do-while` primero se ejecuta el código y después se revisa la condición. En el `while` es al revés: primero revisa la condición y, si es falsa desde el inicio, el código no se ejecuta nunca.

### Ejercicio 6: for y arrays

**¿Por qué usas for aquí y no while? ¿Qué tiene el for que lo hace más conveniente cuando conoces el número de elementos?**

Uso `for` porque ya sé cuántos productos hay (5, que es `productos.length`). El `for` junta en una sola línea el contador que empieza en 0, la condición para parar y el incremento `i++`, entonces es más difícil que se me olvide aumentar el contador y quede un ciclo infinito. Con `while` tendría que escribir esas tres partes por separado.

### Ejercicio 7: Debugging

Código original:

```java
public class CajaRegistradora { public static void main(String[] args) { int
cantidadVendida = "5"; double precioUnitario = 4500; double total = cantidadVendida *
precioUnitario boolean aplicaDescuento = (total > 20000); if (aplicaDescuento = true)
{ total = total - (total * 0.10); } System.out.println("Total: " + total); } }
```

**¿Cuántos errores encontraste? Clasifica cada uno: ¿es un error de compilación o un error lógico? ¿Cómo los distingues?**

Encontré 3 errores:

| # | Error | Corrección | Tipo |
|---|---|---|---|
| 1 | `int cantidadVendida = "5";` guarda un texto (String) en una variable `int` | `int cantidadVendida = 5;` | Compilación |
| 2 | Falta el punto y coma al final de `double total = cantidadVendida * precioUnitario` | Agregar `;` al final | Compilación |
| 3 | `if (aplicaDescuento = true)` usa `=` que es asignación, no comparación. Siempre vale `true` y el descuento se aplicaría siempre, aunque el total fuera menor a 20.000 | `if (aplicaDescuento)` (o `aplicaDescuento == true`) | Lógico |

Cómo los distingo: un error de compilación lo marca IntelliJ en rojo y el programa no corre hasta que se arregle. Un error lógico no marca nada, el programa corre, pero el resultado puede salir mal. En este caso el error 3 no se nota a simple vista porque el total (22.500) sí es mayor a 20.000, pero con una cantidad menor el descuento se aplicaría cuando no debe.

Con el código corregido el total es 5 × 4.500 = 22.500, menos el 10% = **20.250**.

---

## Parte 2: Sistema de turno de cafetería

Archivo: `SistemaCafeteria.java`. No usa Scanner, todos los datos están en el código.

- **Tarea 4, apertura de turno:** antes de los pedidos se simula la apertura de caja con un `do-while`. El primer valor es -50.000 (inválido) y el segundo 100.000, así el ciclo se repite al menos una vez.
- **Tarea 1, procesamiento de pedidos:** un `for` recorre los 6 pedidos y muestra el número de pedido, el producto, la cantidad, la categoría (con `switch`) y el subtotal.
- **Tarea 2, descuento por pedido:** si el subtotal pasa de $12.000 se descuenta el 10% y se muestra si aplicó o no y el valor final.
- **Tarea 3, validación de inventario:** hay 10 Brownies. Cuando el pedido es de Brownie (índice 4) se revisa con un `if` si alcanza el inventario; si no alcanza se imprime "producto agotado" y no se cobra (`continue`). No se usan ciclos anidados.
- **Tarea 5, reporte de cierre:** al final se muestra el total de pedidos procesados, el total recaudado y el número del pedido con mayor valor.

Resultado del reporte de cierre:

```
===== REPORTE DE CIERRE =====
Total de pedidos procesados: 6
Total recaudado: $43000.0
Pedido con mayor valor: #3 ($13500.0)
```
