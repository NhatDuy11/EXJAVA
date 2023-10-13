package KAFKATRANSFORM;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.net.URL;
import java.util.Collections;
import java.util.Properties;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.apache.log4j.PropertyConfigurator;
import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;


@UdfDescription(
        name = "xmltojson",
        author = "example user",
        version = "1.0.2",
        description = "A custom XML TO JSON , convert xml to json"

)
public class KafkaXMLToJsonTransformer {
    private static Properties LOG4J_PROPERTIES_FILE_PATH;
    private String topic;
    private URL xsdUrl;
    private KafkaConsumer<String, String> consumer;

    public KafkaXMLToJsonTransformer(String topic, URL xsdUrl) {
        this.topic = topic;
        this.xsdUrl = xsdUrl;
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumer = new KafkaConsumer<>(props);
    }
    @Udf(description = "The standard version of the tranform with integer parameters.")
    public void consumeTransform() {


        consumer.subscribe(Collections.singletonList(topic));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            records.forEach(record -> {
                try {
                    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                    Schema schema = schemaFactory.newSchema(xsdUrl);

                    JAXBContext jaxbContext = JAXBContext.newInstance(Object.class);
                    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                    unmarshaller.setSchema(schema);

                    StringReader reader = new StringReader(record.value());
                    Object obj = unmarshaller.unmarshal(reader);

                    ObjectMapper mapper = new ObjectMapper();
                    String jsonString = mapper.writeValueAsString(obj);
                    System.out.println(jsonString);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }




    public static void main(String[] args) throws Exception {
        URL xsdUrl = new URL("https://raw.githubusercontent.com/NhatDuy11/XSD_FBNK_ACCOUNT/main/validXSD.XSD");
        KafkaXMLToJsonTransformer transformer = new KafkaXMLToJsonTransformer("dwdb.STPUSER.FBNK_ACCOUNT.XMLRECORD", xsdUrl);
        transformer.consumeTransform();
        PropertyConfigurator.configure(LOG4J_PROPERTIES_FILE_PATH);

    }

}
