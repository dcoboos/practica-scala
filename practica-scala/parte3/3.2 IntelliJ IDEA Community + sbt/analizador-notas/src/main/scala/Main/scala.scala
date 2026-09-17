package Main

object Main extends App {
  val estudiantes = List(
    "Ana",
    "Luis",
    "Marta",
    "Pedro",
    "Sofia"
  )

  val notas = Array(
    8,
    4,
    10,
    6,
    3
  )
  def aprobado(nota:Int):Boolean={
    if(nota>=5){
      true
    }else{
      false
    }

  }
  def estadoNota(nota:Int):String={
    if(aprobado(nota)==true){
      val aprobado="APROBADO"
      aprobado

    }else{
      val suspenso="SUSPENSO"
      suspenso
    }

  }
  def maxNota(a:Int,b:Int):Int={
    if(a>b){
      a
    }else if(a<b){
      b
    }else {
      println("Las notas son iguales")
      0
    }

  }
  //println(aprobado((6)))
  //println(estadoNota((7)))
  //println(maxNota(6,7))
  var i=0
while (i<notas.length){
  val nombreEstudiante=estudiantes(i)
  val nota=notas(i)
  val resultadoNota=estadoNota(nota)
  println(s"El estudiante $nombreEstudiante tiene la nota de $nota --> $resultadoNota")
  i=i+1
}
  val totalEstudiantes=estudiantes.length
  val totalAprobados=notas.filter(n => aprobado(n)).length
  val totalSuspensos=notas.filter(n => !aprobado(n)).length
  val notaAlta=notas.max
  println("--- Resumen del grupo ---")
  println(s"Total de estudiantes: $totalEstudiantes")
  println(s"Total de aprobados: $totalAprobados")
  println(s"Total de suspensos: $totalSuspensos")
  println(s"Mejor nota: $notaAlta")

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

  notas.foreach{
    n=>println(s"Tu nota es $n --> ${clasificacion(n)}")
  }

  val notasSegundaEvaluacion = Array(
    9,
    5,
    8,
    7,
    6
  )
  val mejorNota1=notas.max
  val mejorNota2=notasSegundaEvaluacion.max
  val totalAprobados2=notasSegundaEvaluacion.filter(n =>aprobado(n)).length
  println("--- Comparacion de las 2 evaluaciones ---")
  println(s"Mejor nota 1ª ev: $mejorNota1")
  println(s"Mejor nota 2ª ev: $mejorNota2")
  println(s"Nº aprobados 1 ev: $totalAprobados")
  println(s"Nº aprobados 2 ev: $totalAprobados2")

  if(totalAprobados>totalAprobados2){
   println("Ha empeorado")
  }else if(totalAprobados<totalAprobados2){
    println("Ha mejorado")
  }else{
    println("Se mantiene igual")
  }
  val nuevosEstudiantes = "Carlos" :: estudiantes
  println(estudiantes)
  println(nuevosEstudiantes)
}

