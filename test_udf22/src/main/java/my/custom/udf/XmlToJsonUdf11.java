package my.custom.udf;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;
import java.io.IOException;
@UdfDescription(name = "xml_to_json", description = "Converts XML to JSON")
public class XmlToJsonUdf11 {
    @Udf(description = "Converts the input XML byte array to a JSON string")
    public String xmlToJson(@UdfParameter(value = "value", description = "The XML data to convert") final String value) throws IOException {



        XmlMapper xmlMapper = new XmlMapper();

        ObjectMapper objectMapper = new ObjectMapper();
        Object data = xmlMapper.readValue(value,Object.class);
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
        return json;
    }


}
