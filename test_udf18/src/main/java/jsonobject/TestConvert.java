package jsonobject;
import org.json.JSONObject;
import org.json.XML;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FilenameUtils;
public class TestConvert {

    private static File fileEntry;
    public static void main(String[] args) throws IOException {

        final Path xmlFolder = Paths.get("D:\\oracle_xml\\data.XML");
        final Path jsonFolder = xmlFolder.resolveSibling("D:\\oracle_xml\\oracle1.json");
        Files.list(xmlFolder)
                .forEach(path -> {
                    try {

                        String xml = new String(Files.readAllBytes(fileEntry.toPath()),
                                StandardCharsets.UTF_8);

                        // 1
                        final int initialXmlSize = 320 * 1024;
                        JSONObject obj = XML.toJSONObject(xml);
                        StringWriter xmlOut = new StringWriter(initialXmlSize);
                        Writer write = obj.write(xmlOut);
                        String xml1= xmlOut.toString();
                        // 2

                        String jsonFileName = path.getFileName().toString().replaceFirst("\\.[^\\.]+$",
                                "") + ".json";
                        Path xmlPath = jsonFolder.resolve(jsonFileName);
                        Files.write(xmlPath, xml1.getBytes(StandardCharsets.UTF_8));
                    } catch (IOException e) {
                        System.err.println("File " + path);
                        e.printStackTrace();
                    }

                })
    ;}

}
