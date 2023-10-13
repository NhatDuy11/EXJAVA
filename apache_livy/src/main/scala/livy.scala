import org.json4s._
import org.json4s.native.JsonMethods._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}
import scalaj.http.Http

object livy {
  def main(args: Array[String]): Unit = {
    implicit val formats: DefaultFormats.type = DefaultFormats

    val livyUrl = "http://localhost:8998"
    val sessionId = 1

    val code =
      """
        |val data = Seq(1, 2, 3, 4, 5)
        |val rdd = sc.parallelize(data)
        |val sum = rdd.reduce(_ + _)
        |sum
      """.stripMargin

    val request = Http(s"$livyUrl/sessions/$sessionId/statements")
      .header("Content-Type", "application/json")
      .postData(write(Map("code" -> code)))

    val response = request.asString
    val batchId = parse(response.body) \ "id"

    println(s"Submitted batch job with ID: $batchId")
  }
}