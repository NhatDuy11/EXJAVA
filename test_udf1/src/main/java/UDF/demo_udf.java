package UDF;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.*;
public class demo_udf {

        public String xmlToJson (String xml) throws Exception {
            ObjectMapper xmlMapper = new ObjectMapper();
            Object obj = xmlMapper.readValue(xml, Object.class);
            ObjectMapper jsonMapper = new ObjectMapper();
            return jsonMapper.writeValueAsString(obj);

        }

    public static void main(String[] args) {

            demo_udf demoUdf = new demo_udf();
            demoUdf.xmlToJson(String);


    }

    }








