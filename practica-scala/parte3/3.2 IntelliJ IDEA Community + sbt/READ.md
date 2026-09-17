# Analizador de calificaciones

## 1. Descripción del proyecto

Este proyecto consiste en una aplicación desarrollada en **Scala 2.12.21** utilizando **sbt** e **IntelliJ IDEA Community**.

El objetivo del programa es analizar las calificaciones de un grupo de estudiantes. Para ello, se almacenan los nombres de los estudiantes y sus respectivas notas, se determina si cada estudiante ha aprobado o suspendido y se calculan diferentes estadísticas.

Además, el programa permite clasificar las notas, analizar una segunda evaluación, comparar los resultados de ambas evaluaciones y trabajar con listas de estudiantes.

---

## 2. Entorno de trabajo

El proyecto se ha desarrollado utilizando:

* **IntelliJ IDEA Community**
* **Scala 2.12.21**
* **JDK 17**
* **sbt**

La estructura del proyecto es la siguiente:

```text
analizador-notas/
├── build.sbt
├── project/
└── src/
    └── main/
        └── scala/
            └── Main.scala
```

---

## 3. Configuración de `build.sbt`

El archivo `build.sbt` contiene la configuración principal del proyecto:

```scala
scalaVersion := "2.12.21"

name := "analizador-notas"
```

De esta forma se especifica que el proyecto utiliza **Scala 2.12.21** y que el nombre del proyecto es **analizador-notas**.

---

## 4. Programa principal

El programa principal se encuentra en:

```text
src/main/scala/Main.scala
```

El código comienza con:

```scala
object Main extends App {
```

Al utilizar `extends App`, el código que se encuentra dentro del objeto se ejecuta cuando se inicia el programa.

---

## 5. Datos iniciales

Los nombres de los estudiantes se almacenan en una `List`:

```scala
val estudiantes = List(
  "Ana",
  "Luis",
  "Marta",
  "Pedro",
  "Sofia"
)
```

Las notas de la primera evaluación se almacenan en un `Array`:

```scala
val notas = Array(
  8,
  4,
  10,
  6,
  3
)
```

Cada nombre se corresponde con la nota que ocupa la misma posición.

| Estudiante | Nota |
| ---------- | ---: |
| Ana        |    8 |
| Luis       |    4 |
| Marta      |   10 |
| Pedro      |    6 |
| Sofia      |    3 |

Por ejemplo:

```text
estudiantes(0) -> Ana
notas(0)       -> 8
```

---

## 6. Función `aprobado`

Se ha creado la función:

```scala
def aprobado(nota: Int): Boolean = {
  if (nota >= 5) {
    true
  } else {
    false
  }
}
```

Esta función recibe una nota de tipo `Int` y devuelve un valor `Boolean`.

La condición para aprobar es tener una nota mayor o igual que 5.

* Si la nota es mayor o igual que 5, devuelve `true`.
* Si la nota es menor que 5, devuelve `false`.

Ejemplos:

```text
aprobado(8) -> true
aprobado(5) -> true
aprobado(4) -> false
```

---

## 7. Función `estadoNota`

La función `estadoNota` indica si un estudiante está aprobado o suspenso:

```scala
def estadoNota(nota: Int): String = {
  if (aprobado(nota) == true) {
    val aprobado = "APROBADO"
    aprobado
  } else {
    val suspenso = "SUSPENSO"
    suspenso
  }
}
```

Si la nota es mayor o igual que 5 devuelve:

```text
APROBADO
```

En caso contrario devuelve:

```text
SUSPENSO
```

Esta función utiliza la función `aprobado` para comprobar previamente la nota.

---

## 8. Función `maxNota`

Se ha creado la función:

```scala
def maxNota(a: Int, b: Int): Int = {
  if (a > b) {
    a
  } else if (a < b) {
    b
  } else {
    println("Las notas son iguales")
    0
  }
}
```

Esta función recibe dos notas y devuelve la mayor utilizando `if`, `else if` y `else`.

Por ejemplo:

```scala
maxNota(6, 7)
```

devuelve:

```text
7
```

Si las dos notas son iguales, se muestra un mensaje indicando que las notas son iguales.

---

## 9. Listado de estudiantes

Para recorrer los estudiantes y mostrar sus notas se utiliza un bucle `while`:

```scala
var i = 0

while (i < notas.length) {
  val nombreEstudiante = estudiantes(i)
  val nota = notas(i)
  val resultadoNota = estadoNota(nota)

  println(s"El estudiante $nombreEstudiante tiene la nota de $nota --> $resultadoNota")

  i = i + 1
}
```

El índice `i` permite acceder a la misma posición tanto de la lista de estudiantes como del array de notas.

La salida es:

```text
El estudiante Ana tiene la nota de 8 --> APROBADO
El estudiante Luis tiene la nota de 4 --> SUSPENSO
El estudiante Marta tiene la nota de 10 --> APROBADO
El estudiante Pedro tiene la nota de 6 --> APROBADO
El estudiante Sofia tiene la nota de 3 --> SUSPENSO
```

---

## 10. Estadísticas del grupo

El programa calcula las siguientes estadísticas:

* Número total de estudiantes.
* Número de aprobados.
* Número de suspensos.
* Nota más alta.

### Número total de estudiantes

Se utiliza:

```scala
val totalEstudiantes = estudiantes.length
```

El resultado es:

```text
5
```

### Número de aprobados

Se utiliza `filter` junto con la función `aprobado`:

```scala
val totalAprobados = notas.filter(n => aprobado(n)).length
```

El resultado es:

```text
3
```

### Número de suspensos

Para obtener los suspensos se utiliza:

```scala
val totalSuspensos = notas.filter(n => !aprobado(n)).length
```

El resultado es:

```text
2
```

### Nota más alta

Para obtener la nota máxima se utiliza:

```scala
val notaAlta = notas.max
```

El resultado es:

```text
10
```

### Resumen

El programa muestra:

```text
--- Resumen del grupo ---
Total de estudiantes: 5
Total de aprobados: 3
Total de suspensos: 2
Mejor nota: 10
```

---

## 11. Clasificación de las notas

Se ha creado la función `clasificacion`:

```scala
def clasificacion(nota: Int): String = {
  if (nota >= 9) {
    "EXCELENTE"
  } else if (nota >= 7) {
    "NOTABLE"
  } else if (nota >= 5) {
    "APROBADO"
  } else {
    "SUSPENSO"
  }
}
```

La clasificación utilizada es:

| Nota   | Clasificación |
| ------ | ------------- |
| 9 - 10 | EXCELENTE     |
| 7 - 8  | NOTABLE       |
| 5 - 6  | APROBADO      |
| 0 - 4  | SUSPENSO      |

Para mostrar las clasificaciones se utiliza `foreach`:

```scala
notas.foreach {
  n => println(s"Tu nota es $n --> ${clasificacion(n)}")
}
```

El resultado es:

```text
Tu nota es 8 --> NOTABLE
Tu nota es 4 --> SUSPENSO
Tu nota es 10 --> EXCELENTE
Tu nota es 6 --> APROBADO
Tu nota es 3 --> SUSPENSO
```

---

## 12. Segunda evaluación

Se añade una segunda evaluación mediante otro `Array`:

```scala
val notasSegundaEvaluacion = Array(
  9,
  5,
  8,
  7,
  6
)
```

La lista original de estudiantes no se modifica.

Los resultados son:

| Estudiante | 1ª evaluación | 2ª evaluación |
| ---------- | ------------: | ------------: |
| Ana        |             8 |             9 |
| Luis       |             4 |             5 |
| Marta      |            10 |             8 |
| Pedro      |             6 |             7 |
| Sofia      |             3 |             6 |

Para la segunda evaluación se utilizan las mismas funciones creadas anteriormente, como `aprobado` y `clasificacion`.

---

## 13. Comparación de las evaluaciones

El programa obtiene la mejor nota de cada evaluación:

```scala
val mejorNota1 = notas.max
val mejorNota2 = notasSegundaEvaluacion.max
```

También calcula el número de aprobados de la segunda evaluación:

```scala
val totalAprobados2 = notasSegundaEvaluacion
  .filter(n => aprobado(n))
  .length
```

Los resultados son:

```text
Mejor nota 1ª ev: 10
Mejor nota 2ª ev: 9
Nº aprobados 1 ev: 3
Nº aprobados 2 ev: 5
```

Para decidir si el grupo ha mejorado, ha empeorado o se ha mantenido igual, el enunciado indica que se debe comparar el **número de aprobados** de ambas evaluaciones.

En este caso:

```text
Primera evaluación -> 3 aprobados
Segunda evaluación -> 5 aprobados
```

Por tanto, el grupo **ha mejorado**, ya que el número de aprobados aumenta de 3 a 5.

La comparación correcta según el enunciado es:

```scala
if (totalAprobados > totalAprobados2) {
  println("Ha empeorado")
} else if (totalAprobados < totalAprobados2) {
  println("Ha mejorado")
} else {
  println("Se mantiene igual")
}
```

---

## 14. Uso de listas

Para añadir un nuevo estudiante al principio de la lista se utiliza el operador `::`:

```scala
val nuevosEstudiantes = "Carlos" :: estudiantes
```

La lista original es:

```text
List(Ana, Luis, Marta, Pedro, Sofia)
```

La nueva lista es:

```text
List(Carlos, Ana, Luis, Marta, Pedro, Sofia)
```

### ¿Por qué no se modifica la lista original?

Las listas (`List`) de Scala son **inmutables**.

Esto significa que la operación:

```scala
"Carlos" :: estudiantes
```

no modifica la lista `estudiantes`.

En su lugar, crea una nueva lista llamada `nuevosEstudiantes` que contiene a `Carlos` al principio y mantiene los elementos de la lista original.

Por eso se pueden mostrar ambas listas:

```scala
println(estudiantes)
println(nuevosEstudiantes)
```

y obtener:

```text
List(Ana, Luis, Marta, Pedro, Sofia)
List(Carlos, Ana, Luis, Marta, Pedro, Sofia)
```

---

## 15. Colecciones utilizadas

En el proyecto se utilizan principalmente dos tipos de colecciones.

### `List`

Se utiliza para almacenar los nombres de los estudiantes:

```scala
val estudiantes = List(
  "Ana",
  "Luis",
  "Marta",
  "Pedro",
  "Sofia"
)
```

La `List` es inmutable y permite utilizar el operador `::` para crear una nueva lista añadiendo elementos al principio.

### `Array`

Se utiliza para almacenar las notas:

```scala
val notas = Array(8, 4, 10, 6, 3)
```

También se utiliza otro `Array` para la segunda evaluación:

```scala
val notasSegundaEvaluacion = Array(9, 5, 8, 7, 6)
```

Los elementos del array pueden ser consultados mediante un índice.

---

## 16. Funciones creadas

Durante el desarrollo se han creado las siguientes funciones:

| Función                            | Descripción                                    |
| ---------------------------------- | ---------------------------------------------- |
| `aprobado(nota: Int): Boolean`     | Comprueba si una nota es igual o superior a 5. |
| `estadoNota(nota: Int): String`    | Devuelve `APROBADO` o `SUSPENSO`.              |
| `maxNota(a: Int, b: Int): Int`     | Devuelve la mayor de dos notas.                |
| `clasificacion(nota: Int): String` | Clasifica una nota según su valor.             |

También se utilizan diferentes métodos de las colecciones:

* `filter`
* `length`
* `max`
* `foreach`

---

## 17. Conceptos de Scala utilizados

Durante el proyecto se han aplicado diferentes conceptos básicos de Scala:

* Variables con `val` y `var`.
* Tipos `Int`, `String` y `Boolean`.
* Definición de funciones mediante `def`.
* Condicionales `if`, `else if` y `else`.
* Bucles `while`.
* Listas mediante `List`.
* Arrays mediante `Array`.
* Método `filter`.
* Método `foreach`.
* Método `length`.
* Método `max`.
* Interpolación de strings mediante `s"..."`.
* Inmutabilidad de las listas.
* Operador `::`.

---

## 18. Ejecución con sbt

El proyecto se puede compilar y ejecutar utilizando la terminal integrada de IntelliJ IDEA.

### Compilación

Primero se ejecuta:

```bash
sbt compile
```

Este comando comprueba que el proyecto y el código fuente compilan correctamente.

### Ejecución

Después se ejecuta:

```bash
sbt run
```

Este comando ejecuta el programa principal.

La consola muestra el listado de estudiantes, las notas, el estado de cada estudiante, las clasificaciones, las estadísticas y los resultados de la comparación entre las dos evaluaciones.

---

## 19. Problemas encontrados y soluciones

### Relación entre estudiantes y notas

Uno de los aspectos importantes del programa es mantener la correspondencia entre cada estudiante y su nota.

Se utiliza la misma posición en las dos colecciones:

```text
estudiantes(0) -> Ana
notas(0)       -> 8
```

Para conseguirlo se utiliza un índice dentro del bucle `while`.

### Cálculo de aprobados y suspensos

Para calcular los aprobados y suspensos se utiliza el método `filter`:

```scala
notas.filter(n => aprobado(n))
```

De esta forma se seleccionan únicamente las notas que cumplen la condición correspondiente.

### Inmutabilidad de las listas

Al añadir a Carlos se utiliza:

```scala
val nuevosEstudiantes = "Carlos" :: estudiantes
```

La lista original no se modifica porque `List` es una colección inmutable en Scala.

### Comparación de las evaluaciones

El enunciado indica que para determinar si el grupo ha mejorado o empeorado hay que comparar el número de aprobados.

Por ello, se deben comparar:

```scala
totalAprobados
```

y:

```scala
totalAprobados2
```

En lugar de comparar únicamente las mejores notas.

---

## 20. Resultados finales

### Primera evaluación

```text
Ana -> 8 -> APROBADO
Luis -> 4 -> SUSPENSO
Marta -> 10 -> APROBADO
Pedro -> 6 -> APROBADO
Sofia -> 3 -> SUSPENSO
```

Resumen:

```text
--- Resumen del grupo ---
Estudiantes: 5
Aprobados: 3
Suspensos: 2
Mejor nota: 10
```

### Clasificación

```text
Ana -> 8 -> NOTABLE
Luis -> 4 -> SUSPENSO
Marta -> 10 -> EXCELENTE
Pedro -> 6 -> APROBADO
Sofia -> 3 -> SUSPENSO
```

### Segunda evaluación

```text
Ana -> 9
Luis -> 5
Marta -> 8
Pedro -> 7
Sofia -> 6
```

Resultados:

```text
Aprobados: 5
Suspensos: 0
Mejor nota: 9
```

### Comparación

```text
Mejor nota 1ª evaluación: 10
Mejor nota 2ª evaluación: 9

Aprobados 1ª evaluación: 3
Aprobados 2ª evaluación: 5

Resultado: Ha mejorado
```

---

## 21. Capturas de pantalla

Como parte de la entrega se incluyen capturas de pantalla que muestran:

1. IntelliJ IDEA abierto.
2. Plugin de Scala activo.
3. JDK 17 seleccionado.
4. Proyecto sbt cargado.
5. Scala 2.12.21 configurado.
6. Ejecución de `sbt compile`.
7. Compilación correcta del proyecto.
8. Ejecución de `sbt run`.
9. Salida completa del programa.

Las capturas sirven como evidencia de la configuración, compilación y ejecución del proyecto.

La documentación explica además el funcionamiento del código, las funciones creadas, las colecciones utilizadas, los resultados obtenidos y los problemas encontrados durante el desarrollo.

---

## 22. Conclusión

El proyecto permite aplicar los principales conceptos básicos de programación en Scala mediante una aplicación práctica.

Se han utilizado funciones, condicionales, bucles, listas, arrays y diferentes métodos de colecciones para analizar las calificaciones de un grupo de estudiantes.

El programa permite:

* Almacenar estudiantes y notas.
* Determinar aprobados y suspensos.
* Calcular estadísticas.
* Obtener la nota más alta.
* Clasificar las notas.
* Analizar una segunda evaluación.
* Comparar los resultados de ambas evaluaciones.
* Crear una nueva lista sin modificar la lista original.
* Compilar y ejecutar el proyecto mediante `sbt`.

El resultado final es una aplicación sencilla que permite practicar diferentes conceptos fundamentales de **Scala 2.12.21** dentro de un proyecto estructurado con **sbt**.
