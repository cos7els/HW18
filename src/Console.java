import java.io.File;
import java.util.Scanner;

public class Console {
    private static final Scanner in = new Scanner(System.in);

    public static void start() {
        String read;
        System.out.print("""
                ------------------------------
                  Welcome to XML parser v1.0
                ------------------------------
                """);
        try {
            System.out.print("""
                    Enter '1' for parse xml file by SAX
                    Enter '2' for parse xml file by DOM
                    Enter '3' for parse xml file to Sonnet object by JAXB
                    """);
            System.out.print("Your choice: ");
            read = in.nextLine().trim();
            switch (read) {
                case "1" -> SAXParserTest.startSAXParser(checkFiles());
                case "2" -> DOMParserTest.startDOMParser(checkFiles());
                case "3" -> JAXBTest.xmlToObj(checkFiles());
                default -> System.out.printf("'%s' incorrect value\n", read);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            in.close();
        }
    }

    private static File checkFiles() {
        System.out.print("Enter the path to xml file: ");
        String path = in.nextLine().trim();
        int xmlCounter = 0;
        File result = null;
        File[] files = null;
        File file = new File(path);
        if (file.isFile() && file.getName().endsWith(".xml")) {
            return file;
        } else if (file.isDirectory()) {
            files = new File(path).listFiles();
        }
        if (files == null) {
            throw new NullPointerException();
        } else if (files.length == 0) {
            throw new NullPointerException();
        }
        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(".xml")) {
                result = f;
                xmlCounter++;
            }
        }
        if (xmlCounter == 0) {
            System.out.println("There is no '.xml' files");
        }
        return result;
    }
}
