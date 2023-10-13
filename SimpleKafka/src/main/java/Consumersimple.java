import java.util.Arrays;
import java.util.Properties;
import java.util.UUID;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumersimple {
    private static final Logger logger = Logger.getLogger("org.apache.kafka.common.metrics.Metrics");

    public static void main(String[] args) {
        logger.setLevel(Level.OFF);
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.19.182.0:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG,UUID.randomUUID().toString());
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        KafkaConsumer<String,String>consumer  = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("test"));
        while (true) {
            // get value from kakfa using poll
            ConsumerRecords<String,String> records = consumer.poll(100);
            // for-loop record get value from records
            for (ConsumerRecord<String,String>record : records){
               System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                // %d specified integer , %s specified String , %n specied new line which consumer data from topic
            }

        }



    }
}
