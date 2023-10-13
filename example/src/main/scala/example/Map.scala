package example

import scala.collection.mutable
class Employee {
  var salary:Float = 1100
}
class programer extends  Employee {
  var bonus:Int = 500
  println(s"bonus: $bonus  ")
  println(s"salary : $salary")
}


object Map {
  def main(args: Array[String]): Unit = {
    var s1 = new programer()
    println(s1.bonus)
    println(s1.salary)
    val myMap = mutable.HashMap("apple" -> 1 , "banana" ->2 , "Pineapple" ->3)
    val appleCount = myMap("apple")
    println(s"Apple count :  $appleCount")
    val bananaCountr = myMap("banana")
    println(s"banana Count : $bananaCountr ")
    myMap("grape") = 4
    for((key,value) <- myMap){
      println(s"Key:$key,Value: $value")
    }
    val containPear = myMap.contains("peach")
    println(s"check contains 'pear' :  $containPear")
    myMap.remove("Pineapple")
    for ((key,value) <- myMap) {
      println(s"key : $key,value : $value")
    }
  }

}
