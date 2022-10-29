import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SAXParserTest {
    private final SAXParser saxParser;
    private final static StringBuilder lines = new StringBuilder();
    private final static StringBuilder fileName = new StringBuilder();

    private SAXParserTest() throws ParserConfigurationException, SAXException {
        saxParser = SAXParserFactory.newInstance().newSAXParser();
    }

    public static void startSAXParser(File file) throws ParserConfigurationException, SAXException, IOException {
        SAXParserTest saxParserTest = new SAXParserTest();
        XMLHandler xmlHandler = new XMLHandler();
        saxParserTest.saxParser.parse(file, xmlHandler);
        Files.write(Path.of(fileName.toString()), lines.toString().getBytes());
    }

    private static class XMLHandler extends DefaultHandler {
        private String currentElement;
        private String lastName;
        private String title;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            currentElement = qName;
            if (qName.equals("sonnet")) {
                title = attributes.getValue("type");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String currentLine = new String(ch, start, length).replace("\n", "").trim();
            if (currentElement.equals("line") && currentLine.length() > 0) {
                lines.append(currentLine.replace("\n", "").trim()).append("\n");
            } else if (currentElement.equals("firstName") && currentLine.length() > 0) {
                fileName.append(currentLine).append("_").append(lastName).append("_").append(title).append(".txt");
            } else if (currentElement.equals("lastName") && currentLine.length() > 0) {
                lastName = currentLine;
            }
        }

    }

}
