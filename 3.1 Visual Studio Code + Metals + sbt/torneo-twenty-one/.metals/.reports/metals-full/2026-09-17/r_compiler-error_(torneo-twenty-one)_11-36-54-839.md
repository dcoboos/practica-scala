error id: 82A0FBE7484265536A061956FDC5CE9E
file:///C:/Users/AlumnoM_AI/Documents/ProyectosTajamar/parte3/3.1%20Visual%20Studio%20Code%20+%20Metals%20+%20sbt/torneo-twenty-one/src/main/scala/Main.scala
### scala.reflect.internal.FatalError: 
  ThisType(value $anonfun) for sym which is not a class
     while compiling: file:///C:/Users/AlumnoM_AI/Documents/ProyectosTajamar/parte3/3.1%20Visual%20Studio%20Code%20+%20Metals%20+%20sbt/torneo-twenty-one/src/main/scala/Main.scala
        during phase: globalPhase=<no phase>, enteringPhase=parser
     library version: version 2.12.21
    compiler version: version 2.12.21
  reconstructed args: -classpath <WORKSPACE>\.bloop\torneo-twenty-one\bloop-bsp-clients-classes\classes-Metals-URaet79gQ2as0pEI5lmZvw==;<HOME>\AppData\Local\bloop\cache\semanticdb\com.sourcegraph.semanticdb-javac.0.12.3\semanticdb-javac-0.12.3.jar;<HOME>\.sbt\boot\scala-2.12.21\lib\scala-library.jar -Xplugin-require:semanticdb -Yrangepos -Ymacro-expand:discard -Ycache-plugin-class-loader:last-modified -Ypresentation-any-thread

  last tree to typer: Literal(Constant(26))
       tree position: line 16 of file:///C:/Users/AlumnoM_AI/Documents/ProyectosTajamar/parte3/3.1%20Visual%20Studio%20Code%20+%20Metals%20+%20sbt/torneo-twenty-one/src/main/scala/Main.scala
            tree tpe: Int(26)
              symbol: null
           call site: <none> in <none>

== Source file context for tree position ==

    13   24,
    14   21,
    15   20,
    16   26
    17 )
    18 
    19 

occurred in the presentation compiler.



action parameters:
offset: 2278
uri: file:///C:/Users/AlumnoM_AI/Documents/ProyectosTajamar/parte3/3.1%20Visual%20Studio%20Code%20+%20Metals%20+%20sbt/torneo-twenty-one/src/main/scala/Main.scala
text:
```scala
object Main extends App {
//PRIMERA RONDA  
val jugadores = List(
  "Alex",
  "Chen",
  "Marta",
  "Sindhu",
  "Luis"
)

val puntuaciones = Array(
  18,
  24,
  21,
  20,
  26
)



def bust(puntuacion: Int):Boolean={
    if (puntuacion>21){
        true
    }else{
        false
    }
}
//println(bust(24))

def estadoMano(puntuacion:Int):String={
    if (bust(puntuacion)==true){
        val esBust="BUST"
        esBust
        
    }
    else{
        val esValida="VALIDA"
        esValida
        
    }
}
//println(estadoMano(18))
def mejorMano(handA: Int, handB: Int): Int={
   
   if (bust(handA) && bust(handB)){
    0
   }else if(bust(handA)){
    handB
   }else if(bust(handB)){
    handA
   }else{
    if(handA>handB){
    handA
    }else{
        handB
    }
    
   }
}
//println(mejorMano(4,7))
var i=0
while(i<puntuaciones.length){
    val jugador=jugadores(i)
    val puntuacion=puntuaciones(i)
    val estado=estadoMano(puntuacion)
    println(s"El jugador $jugador con la puntuacion $puntuacion tiene el estado $estado")
    i=i+1
}
val totalJugadores=jugadores.length
val totalValidas=puntuaciones.count(p=> !bust(p))
val totalBust=puntuaciones.count(p=>bust(p))
val puntuacionesValidas = puntuaciones.filter(p => !bust(p))
val mejorPuntuacion = if (puntuacionesValidas.nonEmpty) puntuacionesValidas.max else 0
println("--- Resumen de la ronda ---")
println(s"Jugadores $totalJugadores")
println(s"Manos validas: $totalValidas")
println(s"Total bust: $totalBust")
println(s"Mejor puntuacion valida: $mejorPuntuacion")

//SEGUNDA RONDA
val puntuacionesRonda2 = Array(
  22,
  19,
  20,
  21,
  17
)
val mejorPuntuacionR1=puntuaciones.max
val mejorPuntuacionR2=puntuacionesRonda2.max
//println("Puntuacion ronda 1 "+mejorPuntuacionR1)
//println("Puntuacion ronda 2 "+ mejorPuntuacionR2)
if (mejorPuntuacionR1 > mejorPuntuacionR2){
    println(s"La ronda 1 ha tenido mejor puntuacion y la puntuacion es: $mejorPuntuacionR1")
}else if(mejorPuntuacionR1<mejorPuntuacionR2){
    println(s"La ronda 2 ha tenido mejor puntuacion y la puntuacion es: $mejorPuntuacionR2")
}
else{
    println("HA HABIDO UN EMPATE ENTRE LAS MEJORES PUNTUACIONES")
}

puntuaciones.foreac@@h
}

  

```


presentation compiler configuration:
Scala version: 2.12.21
Classpath:
<WORKSPACE>\.bloop\torneo-twenty-one\bloop-bsp-clients-classes\classes-Metals-URaet79gQ2as0pEI5lmZvw== [exists ], <HOME>\AppData\Local\bloop\cache\semanticdb\com.sourcegraph.semanticdb-javac.0.12.3\semanticdb-javac-0.12.3.jar [exists ], <HOME>\.sbt\boot\scala-2.12.21\lib\scala-library.jar [exists ]
Options:
-Yrangepos -Xplugin-require:semanticdb




#### Error stacktrace:

```
scala.reflect.internal.Reporting.abort(Reporting.scala:69)
	scala.reflect.internal.Reporting.abort$(Reporting.scala:65)
	scala.reflect.internal.SymbolTable.abort(SymbolTable.scala:28)
	scala.reflect.internal.Types$ThisType.<init>(Types.scala:1193)
	scala.reflect.internal.Types$UniqueThisType.<init>(Types.scala:1213)
	scala.reflect.internal.Types$ThisType$.apply(Types.scala:1217)
	scala.meta.internal.pc.AutoImportsProvider$$anonfun$1.applyOrElse(AutoImportsProvider.scala:108)
	scala.meta.internal.pc.AutoImportsProvider$$anonfun$1.applyOrElse(AutoImportsProvider.scala:90)
	scala.collection.immutable.List.collect(List.scala:315)
	scala.meta.internal.pc.AutoImportsProvider.autoImports(AutoImportsProvider.scala:90)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$autoImports$1(ScalaPresentationCompiler.scala:399)
	scala.meta.internal.pc.CompilerAccess.retryWithCleanCompiler(CompilerAccess.scala:182)
	scala.meta.internal.pc.CompilerAccess.$anonfun$withSharedCompiler$1(CompilerAccess.scala:155)
	scala.Option.map(Option.scala:230)
	scala.meta.internal.pc.CompilerAccess.withSharedCompiler(CompilerAccess.scala:154)
	scala.meta.internal.pc.CompilerAccess.$anonfun$withInterruptableCompiler$1(CompilerAccess.scala:92)
	scala.meta.internal.pc.CompilerAccess.$anonfun$onCompilerJobQueue$1(CompilerAccess.scala:209)
	scala.meta.internal.pc.CompilerJobQueue$Job.run(CompilerJobQueue.scala:152)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
	java.base/java.lang.Thread.run(Thread.java:840)
```
#### Short summary: 

scala.reflect.internal.FatalError: 
  ThisType(value $anonfun) for sym which is not a class
     while compiling: file:///C:/Users/AlumnoM_AI/Documents/ProyectosTajamar/parte3/3.1%20Visual%20Studio%20Code%20+%20Metals%20+%20sbt/torneo-twenty-one/src/main/scala/Main.scala
        during phase: globalPhase=<no phase>, enteringPhase=parser
     library version: version 2.12.21
    compiler version: version 2.12.21
  reconstructed args: -classpath <WORKSPACE>\.bloop\torneo-twenty-one\bloop-bsp-clients-classes\classes-Metals-URaet79gQ2as0pEI5lmZvw==;<HOME>\AppData\Local\bloop\cache\semanticdb\com.sourcegraph.semanticdb-javac.0.12.3\semanticdb-javac-0.12.3.jar;<HOME>\.sbt\boot\scala-2.12.21\lib\scala-library.jar -Xplugin-require:semanticdb -Yrangepos -Ymacro-expand:discard -Ycache-plugin-class-loader:last-modified -Ypresentation-any-thread

  last tree to typer: Literal(Constant(26))
       tree position: line 16 of file:///C:/Users/AlumnoM_AI/Documents/ProyectosTajamar/parte3/3.1%20Visual%20Studio%20Code%20+%20Metals%20+%20sbt/torneo-twenty-one/src/main/scala/Main.scala
            tree tpe: Int(26)
              symbol: null
           call site: <none> in <none>

== Source file context for tree position ==

    13   24,
    14   21,
    15   20,
    16   26
    17 )
    18 
    19 