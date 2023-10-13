import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;


public class Producersimple {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.19.182.0:9092");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        //If the request fails, the producer can automatically retry,
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        //Reduce the no of requests less than 0
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        //The buffer.memory controls the total amount of memory available to the producer for buffering.
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer
                <String, String>(props);
        String topic = "test_xml1";
       String xmlinput = "<?xml version='1.0' encoding='UTF-8'?>\n" +
               "<operation table='SACOM_SW_OWN.ATMSTATUS' type='I' ts='2023-08-22 13:56:19.361910' current_ts='2023-08-22T13:56:26.563000' pos='00000000020001370425' numCols='10'>\n" +
               "<col name='UNIT' index='0'>\n" +
               "<before missing='true'/>\n" +
               "<after><![CDATA[88]]></after>\n" +
               "</col>\n" +
               "<col name='GROUP_NAME' index='1'>\n" +
               "<before missing='true'/>\n" +
               "<after><![CDATA[CDM5020105]]></after>\n" +
               "</col>\n" +
               "<col name='STATUS_DATE' index='2'>\n" +
               "<before missing='true'/>\n" +
               "<after><![CDATA[2023-08-07 00:00:00]]></after>\n" +
               "</col>\n" +
               "<col name='STATUS_TIME' index='3'>\n" +
               "<before missing='true'/>\n" +
               "<after><![CDATA[23010]]></after>\n" +
               "</col>\n" +
               "<col name='STATUS' index='4'>\n" +
               "<before missing='true'/>\n" +
               "<after><![CDATA[619]]></after>\n" +
               "</col>\n" +
               "<col name='SDESC' index='5'>\n" +
               "<before missing='true'/>\n" +
               "<after><![CDATA[DISPENSER NO NOTES DISPENSED ]]></after>\n" +
               "</col>\n" +
               "<col name='O_ROWID' index='6'>\n" +
               "<before missing='true'/>\n" +
               "<after><![CDATA[0]]></after>\n" +
               "</col>\n" +
               "<col name='INSTITUTIONID' index='7'>\n" +
               "<before missing='true'/>\n" +
               "<after><![CDATA[1]]></after>\n" +
               "</col>\n" +
               "<col name='SITE_ID' index='8'>\n" +
               "<before missing='true'/>\n" +
               "<after><![CDATA[1]]></after>\n" +
               "</col>\n" +
               "<col name='LOG_ID' index='9'>\n" +
               "<before missing='true'/>\n" +
               "<after><![CDATA[AAEBaADMZM/0wgAB]]></after>\n" +
               "</col>\n" +
               "</operation>";
       StringBuilder sbt = new StringBuilder();
       for (int i =0 ; i <100 ; i++) {
           sbt.append(xmlinput);
           producer.send(new ProducerRecord<String,String>(topic,"key" ,xmlinput));

       }
        producer.close();
    }

}
