import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.yaml.snakeyaml.Yaml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class XML {
    public static void main(String[] args) {
        try{
            String tableName = "ATMSTATUS";
           String file = Files.readString(Paths.get("atm.xml"),StandardCharsets.UTF_8);
           file = file.replace("\u001C","");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource inputSource = new InputSource( new StringReader(file));
            Document doc =db.parse(inputSource);
            doc.getDocumentElement().normalize();
//            System.out.println(doc.getDocumentElement().getNodeName());
//            NodeList nodelist = doc.getDocumentElement().getChildNodes();
//            for ( int i = 0 ; i < nodelist.getLength() ; i++){
//                Node node = nodelist.item(i);
//                if ( node.getNodeType() == Node.ELEMENT_NODE){
//                    Element element = (Element) node;
//                    String name = element.getNodeName();
////                    System.out.println(element.getNodeName());
//
//
//                    String value = element.getTextContent();
////                    System.out.println("name: " + name);
////                    System.out.println("value : " + value);
//                }
//            }


            InputStream in = new FileInputStream("D:\\JAVA\\XML_ATHOME\\atmstatus.yaml");
            Yaml yaml = new Yaml();
            Map<String,Object> data = yaml.load(in);
            List<Map<String, Object>> tables = (List<Map<String, Object>>) ((List<Map<String, Object>>) data.get("database"));
            NodeList colElements = doc.getElementsByTagName("col");

            NodeList operation  = doc.getElementsByTagName("operation");
            System.out.println(operation);

            for (int i = 0 ; i < colElements.getLength() ; i++) {
                Element colElement = (Element) colElements.item(i);
                String colName = colElement.getAttribute("name");
                String colValue = colElement.getElementsByTagName("after").item(0).getTextContent();



            }


//            System.out.println(data);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            StringWriter stringWriter = new StringWriter();
            transformer.transform(new DOMSource(doc),new StreamResult(stringWriter));
            System.out.println(stringWriter.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
