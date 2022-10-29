import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Sonnet {
    @XmlAttribute
    private String type;
    private Author author;
    private Lines lines;

    public Sonnet() {
    }

    public Sonnet(String type, Author author, Lines lines) {
        this.type = type;
        this.author = author;
        this.lines = lines;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Lines getLines() {
        return lines;
    }

    public void setLines(Lines lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return String.format("Sonnet:\nTitle: %s\n%s\n%s", type, author, lines);
    }
}
