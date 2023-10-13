package example

import scala.io.Source

object Streamprocessdata {
  def main(args: Array[String]): Unit = {
    val filePath = "D:\\abc.txt"
    val fileStream = Source.fromFile(filePath).getLines().toStream
    val processStream = fileStream
      .map(processLine)
      .filter(optional => optional.isDefined)
      .map(option => option.get)
    processStream.foreach(println)

  }
  def processLine(line:String):Option[String] = {
    if(line.contains("Scala")){
      Some(s"Processed: $line")
    }else {
      None
    }

  }
}
