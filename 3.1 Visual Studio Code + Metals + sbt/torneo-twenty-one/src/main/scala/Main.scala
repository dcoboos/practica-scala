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

puntuacionesRonda2.foreach{ 
    p=>println(s"La puntuacion $p --> ${estadoMano(p)}")
}
}

  
