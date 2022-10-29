import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBTest {
    private JAXBTest() {
    }

    public static void xmlToObj(File file) throws JAXBException {
        JAXBTest jaxbTest = new JAXBTest();
        Sonnet sonnet = jaxbTest.parseToObject(file);
        System.out.println(sonnet);
    }

    public Sonnet parseToObject(File file) throws JAXBException {
        Sonnet unmarshal;
        JAXBContext jaxbContext = JAXBContext.newInstance(Sonnet.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        unmarshal = (Sonnet) jaxbUnmarshaller.unmarshal(file);
        return unmarshal;
    }

    public void toXmlFile(String path, Sonnet sonnet) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Sonnet.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.marshal(sonnet, new File(path));
    }


}
