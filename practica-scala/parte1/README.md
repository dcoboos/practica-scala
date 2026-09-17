## 1.1 Entorno 1 — JupyterLab + Almond Kernel + Scala 2.12.21

### Instalación de JupyterLab

Para preparar el entorno interactivo de desarrollo en Windows 11, utilicé el gestor de paquetes de Python (`pip`) para instalar JupyterLab de manera local en el sistema.

Una vez completada la ejecución del comando, el sistema descargó todas las dependencias necesarias y dejó listo el entorno para poder arrancar el servidor de Jupyter.

### Instalación de Almond Kernel y Scala 2.12.21
Para poder gestionar la instalación del kernel de Scala, previamente fue necesario descargar e instalar la herramienta **Coursier** en Windows 11. Para ello, accedí al repositorio oficial de releases de Coursier:

* **Enlace de descarga:** [Coursier GitHub Releases](https://github.com/coursier/coursier/releases/latest/download/cs-x86_64-pc-windows.zip)

Descargué el archivo ejecutable comprimido y lo preparé en el sistema para permitir la configuración automática de la máquina virtual Java y el registro de aplicaciones Scala.


Utilizando el archivo ejecutable de Coursier en el sistema, procedí a lanzar la instalación del kernel de Almond para Jupyter configurado específicamente con la versión de Scala 2.12.21 requerida.



Una vez completada la ejecución del comando, el kernel se registró correctamente en el sistema Windows 11 para estar disponible en los entornos interactivos.

### Arranque de JupyterLab y Ejecución de Pruebas en Scala 2.12.21

Para comprobar el funcionamiento del entorno, inicié el servidor local ejecutando el comando correspondiente en la terminal, lo que abrió la interfaz web en mi navegador predeterminado. **python -m jupyter lab**

Luego, creé un nuevo cuaderno seleccionando el kernel de Scala e introduje las celdas de código necesarias para verificar la versión exacta y probar variables, operaciones numéricas y colecciones.



Como se puede ver en la captura, el entorno procesó correctamente la versión 2.12.21 de Scala, interpretó las variables con interpolación de cadenas, resolvió la operación matemática y devolvió la lista de elementos de forma satisfactoria.

## Entorno 2 — Visual Studio Code + Metals + Scala 2.12.21 + JDK 17 + sbt

### Objetivo
Preparar un entorno de desarrollo profesional para proyectos Scala estructurados mediante el uso de Visual Studio Code, el servidor de lenguaje Metals, sbt y la versión específica de Scala 2.12.21 sobre JDK 17.

---

### Actividades y Desarrollo

#### 1. Instalación y Verificación de JDK 17

Instalé el Java Development Kit (JDK) en su versión 17 para asegurar la compatibilidad con Scala y sbt. Desde la terminal del sistema, comprobé que las variables de entorno funcionaban correctamente ejecutando los comandos de versión:




#### 2. Instalación de Visual Studio Code

Procedí a instalar la última versión estable de **Visual Studio Code** en Windows 11 como editor principal de código fuente.




#### 3. Instalación de la extensión Metals

A través del marketplace de extensiones de VS Code (`Ctrl + Shift + X`), busqué e instalé la extensión oficial **Scala (Metals)** para dotar al editor de capacidades de autocompletado, refactorización y análisis de código Scala.




#### 4. Instalación y Comprobación de sbt (Scala Build Tool)

Instalé el gestor de compilación **sbt** mediante el instalador oficial para Windows (`.msi`) y verifiqué desde la línea de comandos que estuviera accesible globalmente:




#### 5. Creación del Proyecto Scala con sbt y Estructura de Directorios

Creé una carpeta dedicada al proyecto llamada `vscode` y estructuré los directorios siguiendo el estándar de sbt:

```text
vscode/
├── build.sbt
├── project/
└── src/
    └── main/
        └── scala/
            └── Main.scala



#### 6. Configuración de Scala 2.12.21 en build.sbt

Abrí el archivo build.sbt en VS Code y configuré de forma explícita el nombre del proyecto y la versión requerida de Scala (2.12.21):




#### 7. Creación del Programa Principal (Main.scala)

Dentro de la ruta src/main/scala/, creé el archivo Main.scala incluyendo un objeto ejecutable que utiliza interpolación de cadenas para comprobar el funcionamiento del entorno:



Scala

object Main extends App {



  val entorno = "Visual Studio Code"



  println("Práctica de programación básica con Scala")

  println(s"Ejecutando desde: $entorno")

}






#### 8. Compilación del Proyecto

Desde la terminal integrada situada en la raíz del proyecto, ejecuté la herramienta de compilación para verificar que no existían errores de sintaxis: sbt compile




#### 9. Ejecución del Proyecto

Finalmente, tras guardar correctamente los cambios en el código, ejecuté la aplicación Scala empaquetada mediante sbt para comprobar la salida estándar por consola: sbt run


## 1.3 Entorno 3 — IntelliJ IDEA Community + Scala 2.12.21 + sbt

### Objetivo
Preparar un entorno de desarrollo profesional basado en un IDE completo utilizando **IntelliJ IDEA Community Edition**, el plugin oficial de Scala, **JDK 17**, **Scala 2.12.21** y **sbt** como herramienta de construcción para proyectos complejos.

---

### Pasos de Configuración y Desarrollo

#### 1. Instalación de IntelliJ IDEA Community Edition
* **Descarga e instalación:** Se descargó e instaló el instalador oficial de *IntelliJ IDEA Community Edition* para Windows 11 desde la plataforma de JetBrains.
* **Verificación:** Se ejecutó el programa por primera vez para comprobar el correcto acceso a la interfaz de bienvenida y gestión de proyectos.

#### 2. Instalación del soporte para Scala
* **Plugin:** Se instaló el plugin oficial **Scala** desde el Marketplace de extensiones de IntelliJ (`Plugins > Marketplace`).
* **Estado:** Instalado correctamente. Tras la notificación del sistema, se reinició el IDE para aplicar los cambios en el motor de análisis sintáctico.

#### 3. Configuración de JDK 17
* **SDK del proyecto:** Se configuró el entorno para utilizar **JDK 17** (seleccionado o descargado directamente desde los asistentes de configuración de IntelliJ).
* **Comprobación:** Se verificó que el Java Development Kit activo correspondía exactamente a la versión 17 requerida por el entorno.

#### 4. Creación de un proyecto sbt
* **Nuevo proyecto:** Se seleccionó la opción de creación de proyectos basada en **sbt** dentro del generador de proyectos Scala.
* **Parámetros iniciales:**
  * **Nombre del proyecto:** `scala-intellij`
  * **Versión de Scala:** `2.12.21`

#### 5. Revisión del archivo `build.sbt`
Se comprobó que el archivo de configuración raíz `build.sbt` contiene la especificación correcta de la versión y el nombre del proyecto:

```scala
scalaVersion := "2.12.21"

name := "scala-intellij"


#### 6. Creación del programa Scala (Main.scala)

Se creó el archivo fuente en la ruta estándar del proyecto src/main/scala/Main.scala con el siguiente contenido de prueba:

Scala
object Main extends App {

  val entorno = "IntelliJ IDEA"

  println("Práctica de programación básica con Scala")
  println(s"Ejecutando desde: $entorno")
}


#### 7. Ejecución desde IntelliJ IDEA
Se utilizó el botón de ejecución integrado (▶) al margen del objeto Main.

Se comprobó que la consola inferior del IDE (Run) muestra de manera correcta los mensajes de texto programados:

Plaintext
Práctica de programación básica con Scala
Ejecutando desde: IntelliJ IDEA


#### 8. Ejecución mediante sbt (Terminal)
Tras instalar y configurar sbt a nivel global en el sistema, se abrió la terminal integrada en la raíz del proyecto.

Se ejecutó el comando de compilación:

Bash
sbt compile
Posteriormente, se ejecutó la aplicación:

Bash
sbt run
Se verificó la correcta compilación y salida por consola de los comandos de sbt.


