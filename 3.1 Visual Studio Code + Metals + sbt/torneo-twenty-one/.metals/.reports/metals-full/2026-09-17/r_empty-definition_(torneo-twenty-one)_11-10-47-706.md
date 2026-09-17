error id: file:///C:/Users/AlumnoM_AI/Documents/ProyectosTajamar/parte3/3.1%20Visual%20Studio%20Code%20+%20Metals%20+%20sbt/torneo-twenty-one/src/main/scala/Main.scala:
file:///C:/Users/AlumnoM_AI/Documents/ProyectosTajamar/parte3/3.1%20Visual%20Studio%20Code%20+%20Metals%20+%20sbt/torneo-twenty-one/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -p.
	 -p#
	 -p().
	 -scala/Predef.p.
	 -scala/Predef.p#
	 -scala/Predef.p().
offset: 1300
uri: file:///C:/Users/AlumnoM_AI/Documents/ProyectosTajamar/parte3/3.1%20Visual%20Studio%20Code%20+%20Metals%20+%20sbt/torneo-twenty-one/src/main/scala/Main.scala
text:
```scala
object Main extends App {
  
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
var totalJugadores=jugadores.length
var totalValidas=
println("--- Resumen de la ronda ---")
println(s"Jugadores ${jugadores.length}")
println(s"Manos validas: ${puntuaciones.count(p=>!bust(p@@))")
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 