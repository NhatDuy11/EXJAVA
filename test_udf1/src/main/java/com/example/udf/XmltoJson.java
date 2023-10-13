package com.example.udf;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.sink.SinkRecord;

import org.apache.kafka.connect.transforms.Transformation;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.TransformerSupplier;

import java.io.IOException;
import java.util.Map;

public class XmltoJson implements Transformer {
    private static final String FIELD_CONFIG = "field";
    private static final String DEFAULT_FIELD = "payload";

    private String fieldName = DEFAULT_FIELD;

    @Override
    public void configure(Map<String, ?> configs) {
        if (configs.containsKey(FIELD_CONFIG)) {
            fieldName = (String) configs.get(FIELD_CONFIG);
        }
    }

    @Override
    public SinkRecord apply(SinkRecord record) {
        Object value = record.value();
        if (value instanceof Struct) {
            Struct struct = (Struct) value;
            if (struct.schema().field(fieldName) != null && struct.get(fieldName) instanceof String) {
                String xmlString = (String) struct.get(fieldName);
                try {
                    ObjectMapper xmlMapper = new XmlMapper();
                    Object xmlObj = xmlMapper.readValue(xmlString, Object.class);
                    ObjectMapper jsonMapper = new ObjectMapper();
                    jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
                    String jsonString = jsonMapper.writeValueAsString(xmlObj);
                    Struct updatedStruct = new Struct(struct.schema())
                            .put(struct.schema().fields().get(0), struct.get(struct.schema().fields().get(0)))
                            .put(fieldName, jsonString);
                    return new SinkRecord(record.topic(), record.kafkaPartition(), record.keySchema(), record.key(),
                            updatedStruct.schema(), updatedStruct, record.kafkaOffset());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return record;
    }

    @Override
    public ConfigDef config() {
        return new ConfigDef().define(FIELD_CONFIG, ConfigDef.Type.STRING, DEFAULT_FIELD, ConfigDef.Importance.HIGH,
                "Field containing XML data");
    }

    @Override
    public void close() {

    }

    @Override
    public void open(Map<String, ?> configs) {

    }

    @Override
    public String[] target() {
        return new String[] {String.valueOf(Schema.STRING_SCHEMA.type())};
    }



}
