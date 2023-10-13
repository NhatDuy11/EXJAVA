import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
public class XmlToJson {
    public static void main(String[] args) throws  IOException {
        // tạo đối tương File , đường dẫn XML
        File xmlFile = new File("D:\\\\oracle.XML");
        // chuyển đổi dữ liệu XML sang dạng đối tượng java
        XmlMapper xmlMapper = new XmlMapper();
        // sử dụng object mapper chuyển đối tượng java sang dạng JSON
        ObjectMapper objectMapper = new ObjectMapper();
        Object data = xmlMapper.readValue(xmlFile,Object.class);
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
        System.out.println(json);








    }

}

