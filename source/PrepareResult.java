import java.util.List;


public class PrepareResult {
    String delimeter;

    public PrepareResult(String delimiter) {
        this.delimeter = delimiter;
    }

    public String add(List<Scanner> scanners) {
        String separator = "";
        String result = "";
        for (Scanner scanner : scanners) {
            result += separator + scanner.toString();
            separator = delimeter;
        }
        return result;
    }

    public String add(String []contents) {
        String separator = "";
        String result = "";
        for (String content : contents) {
            result += separator + content;
            separator = delimeter;
        }
        return result;
    }
    public String add(int []contents) {
        String separator = "";
        String result = "";
        for (int content : contents) {
            result += separator + content;
            separator = delimeter;
        }
        return result;
    }
}
