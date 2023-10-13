package KAFKATOPIC;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;
public class kafKa_toPic {
    public static void main(String[] args) {
        String topicName = "test_1";
        String key = "abcc";
        String value = "12312312312";

        // Tạo cấu hình cho Kafka Producer
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");


        // Tạo Kafka Producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        // Tạo một ProducerRecord
        ProducerRecord<String, String> record = new ProducerRecord<>(topicName, key, value);

        // Gửi tin nhắn
        producer.send(record);


        producer.close();

        System.out.println("SimpleProducer Completed.");
    }

}
