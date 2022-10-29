import java.util.List;

public class Lines {
    private List<String> line;

    public Lines() {
    }

    public Lines(List<String> line) {
        this.line = line;
    }

    public List<String> getLine() {
        return line;
    }

    public void setLine(List<String> line) {
        this.line = line;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Lines: ");
        line.forEach(x -> result.append(x).append("\n"));
        return result.toString();
    }
}
