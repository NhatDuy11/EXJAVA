package org.example.com;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.common.serialization.*;
import io.confluent.kafka.streams.serdes.avro.GenericAvroSerde;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.kstream.ValueMapper;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.StringReader;
import java.util.Properties;

@UdfDescription(name = "XML",description = "XMLT0AVR0")
public class XmlToAvroUDF1 {
    public static void main(String[] args) throws SAXException {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "xml-to-avro-udf");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        final Serde<String> stringSerde = Serdes.String();
        final Serde<byte[]> avroSerde = new Serdes.ByteArraySerde();
//        GenericAvroSerde avroSerde = new GenericAvroSerde();
//        Serde<GenericRecord> byteArraySerde = Serdes.serdeFrom(avroSerde.serializer(), avroSerde.deserializer());


        // Load the XSD
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(XmlToAvroUDF1.class.getResource("/my-schema.xsd"));


        StreamsBuilder builder = new StreamsBuilder();

        builder.stream("input-topic", Consumed.with(stringSerde, stringSerde))
            .mapValues(new XmlToAvroMapper(schema))
                .to("output-topic", Produced.with(stringSerde, avroSerde));




        Topology topology = builder.build();
        System.out.println(topology.describe());

        KafkaStreams streams = new KafkaStreams(topology, props);
        streams.start();
    }

    public static class XmlToAvroMapper implements ValueMapper<String, byte[]> {

        private Validator validator;

        public XmlToAvroMapper(Schema schema) {
            this.validator = schema.newValidator();
        }

        @Override
        public byte[] apply(String xml) {
            try {
                // Validate the XML against the XSD
                validator.validate(new StreamSource(new StringReader(xml)));

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                InputSource is = new InputSource(new StringReader(xml));
                Document doc = builder.parse(is);

                // TODO: Implement your XML to AVRO transformation logic here

                return null; // Return the transformed AVRO byte array
            } catch (Exception e) {
                throw new RuntimeException("Error parsing XML: " + e.getMessage());
            }
        }
    }
}
