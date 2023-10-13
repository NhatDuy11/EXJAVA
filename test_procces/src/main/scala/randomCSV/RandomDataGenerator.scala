package randomCSV
import scala.util.Random
import java.io.PrintWriter

object RandomDataGenerator {
  def main(args: Array[String]): Unit = {
    val random = new Random()
    val numCustomers = 100
    val numTransactions = 1000
    val data = (1 to numTransactions).map { transactionId =>
      val customerId = random.nextInt(numCustomers) + 1
      val transactionAmount = random.nextDouble() * 1000
      s"$transactionId,$customerId,$transactionAmount"
    }
    val writer = new PrintWriter("D:\\data.csv")
    writer.println("transaction_id,customer_id,transaction_amount")
    data.foreach(writer.println)
    writer.close()

    println("Random data generation completed.")

  }

}
