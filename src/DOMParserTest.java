import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DOMParserTest {
    private final Document document;

    private DOMParserTest(File file) throws ParserConfigurationException, IOException, SAXException {
        document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
    }

    public static void startDOMParser(File file) throws ParserConfigurationException, IOException, SAXException {
        DOMParserTest domParser = new DOMParserTest(file);
        String result = domParser.readXml();
        domParser.writeToTxt(result);
    }

    private String readXml() {
        NodeList lines = document.getElementsByTagName("line");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lines.getLength(); i++) {
            result.append(lines.item(i).getTextContent()).append("\n");
        }
        return result.toString();
    }

    private void writeToTxt(String string) throws IOException {
        String fileName = String.format("%s_%s_%s.txt",
                document.getElementsByTagName("firstName").item(0).getTextContent(),
                document.getElementsByTagName("lastName").item(0).getTextContent(),
                document.getElementsByTagName("sonnet").item(0).getAttributes().item(0).getTextContent());
        Files.write(Path.of(fileName), string.getBytes());
    }

}
