package example

import scala.runtime.BoxesRunTime.divide

class Studen(id:Int,name:String){
  var age:Int = 0;
  def showDetait(): Unit = {
    println(id + " " + name + " " + age)
  }
  def this(id:Int,name:String,age:Int) {
    this(id,name)
    this.age = age

  }

}

object trycatchExample {
  def main(args: Array[String]): Unit = {
    try {

      var detail = new Studen(101,"Duy",20);
      detail.showDetait()

      val a:Int = 100
      val result = divide (10,0)
      println(s"result:$result")
      println(s"s : $a")

    } catch {
      case e:ArithmeticException =>
        println(e.getMessage)
      case ex : Exception => println("Exception : " + ex.getMessage)
    }finally {
      println("Finally block excuted")
    }
  }

}
