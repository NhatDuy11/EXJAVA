package UDF;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.kafka.streams.kstream.ValueMapper;
import org.w3c.dom.Document;
public class jsonTF implements ValueMapper <String,String> {
    public  String apply(Sring value){
        return json;

    }

}
