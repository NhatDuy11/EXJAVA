package com.example.XmlToJsonUdf;
import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


@UdfDescription(name = "xmlTojson1",description = "Convert XML to Json")
public class XmlToJsonUdf {
    @Udf(description = "Converts XML to JSON")
    public String xmlToJson(String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xml);

            Element root = doc.getDocumentElement();
            JSONObject json = new JSONObject();
            json.put(root.getNodeName(), parseElement(root));

            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private JSONObject parseElement(Element element) {
        JSONObject json = new JSONObject();

        // Process attributes
        if (element.hasAttributes()) {
            JSONObject attributes = new JSONObject();
            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                Element attr = (Element) element.getAttributes().item(i);
                attributes.put(attr.getNodeName(), attr.getTextContent());
            }
            json.put("attributes", attributes);
        }

        // Process child elements
        NodeList children = element.getChildNodes();
        if (children.getLength() == 1 && children.item(0).getNodeType() == Element.TEXT_NODE) {
            // Only text content, no child elements
            json.put("value", element.getTextContent());
        } else {
            // Child elements present
            JSONObject childElements = new JSONObject();
            for (int i = 0; i < children.getLength(); i++) {
                if (children.item(i).getNodeType() == Element.ELEMENT_NODE) {
                    Element child = (Element) children.item(i);
                    String childName = child.getNodeName();
                    if (!childElements.has(childName)) {
                        childElements.put(childName, new JSONArray());
                    }
                    ((JSONArray) childElements.get(childName)).put(parseElement(child));
                }
            }
            json.put("children", childElements);
        }

        return json;
    }

}
