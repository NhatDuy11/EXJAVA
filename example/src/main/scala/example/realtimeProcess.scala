package example


import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent._
import scala.concurrent.duration._

object realtimeProcess {
  def main(args: Array[String]): Unit = {
    val dataStream =Stream("Data Point 1 ","Data Point 2","Data Point 3" ,"Data Point 4"

    )
    val processFuturing = Future{
      dataStream.foreach{
        data => val processedData = processData(data)
          println(s"Procced :  $processedData")
          Thread.sleep(1000)
      }
    }
    Await.result(processFuturing,Duration.Inf)
  }
  def processData(data:String):String = {
    data.toUpperCase()
  }

}
