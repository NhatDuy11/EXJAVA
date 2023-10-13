package example

class ArrayExample {
  var arr =Array(1,2,3,4,5,6)
  def show(): Unit = {
    for ( a <- arr) {
      println(a)
    }
    println(" access array index two : " + arr(2))

    val abc:Int =10




  }

  def methodString(): Unit = {
    val s1= "CND"
    val s2 = "CAH"
    val s3 = "NDL"


    println(s1.compareTo(s2))
    println( s2.compareTo(s3))
  }

}
object Array1 {

  def main(args: Array[String]): Unit = {
    val example = new ArrayExample()
    example.show()
    example.methodString()
    var a = 10;
    while ( a <=20) {
      a = a+ 2
      println(a)
    }

  }

}









