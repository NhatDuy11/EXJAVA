package example
class StringExample {
  var s1 = "Scala String example "
  def show(): Unit = {
    println(s1)
  }
  def param (name:String): Unit = {
    println("result : " + name)

  }

}
object String {
  def main(args: Array[String]): Unit = {
    var s = new StringExample()
    s.show()
    s.param("Scala")

  }

}
