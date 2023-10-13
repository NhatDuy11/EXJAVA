package CSV
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession
import scala.io.Source
object sparkCSV {
  def main(args: Array[String]): Unit = {
    val filePath = "D:\\data.csv"
    val spark = SparkSession.builder()
      .appName("ReadCSVFile")
      .master("spark://DESKTOP30N599C:7077") // Địa chỉ Spark Master
      .getOrCreate()
    val dataFrame = spark.read
      .option("header", "true") // Bỏ qua dòng header
      .option("inferSchema", "true") // Tự động suy đoán kiểu dữ liệu cột
      .csv(filePath)
    dataFrame.show()
    dataFrame.createOrReplaceTempView("CSV_TABLE")
    val result = spark.sql("SELECT * FROM CSV_TABLE ")
    result.show()

    spark.stop()
  }

  private def readCSVFile(filePath: String): Unit = {
    val source = Source.fromFile(filePath)
    val lines = source.getLines().toList

    // Xử lý từng dòng dữ liệu
    for (line <- lines) {
      val data = line.split(",") // Phân tách dữ liệu bằng dấu phẩy

      // Xử lý dữ liệu tại đây
      // Ví dụ: In ra từng cột
      for (column <- data) {
        println(column)
      }
    }

    source.close()
  }
}
