import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaStream {
    public static void main(String[] args) {

        String bootstrap = "172.19.182.0:9092";
        String topic = "test1";
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrap);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        Producer<String,String> producer = new KafkaProducer<>(props);
        try {
            for ( int i= 0 ; i<10 ;i++){
                String message = "Message " + i;
                ProducerRecord<String,String> record = new ProducerRecord<>(topic,message);
                producer.send(record);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            producer.close();
        }




    }
}
