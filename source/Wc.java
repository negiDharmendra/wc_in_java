import java.util.ArrayList;
import java.util.List;

public class Wc {
    private String content;
    private List<Scanner> scanners;

    public Wc(String content) {
        this.content = content;
        scanners = new ArrayList<Scanner>();
    }

    public void addScanner(Scanner scanner) {
        scanners.add(scanner);
    }


    private void count(char character) {
        for (Scanner scanner : scanners)
            scanner.scan(character);
    }
    public void count() {
        for (int i = 0; i < content.length(); i++)
            count(content.charAt(i));
    }

    public String summery() {
        PrepareResult prepareResult = new PrepareResult("\t");
        return prepareResult.add(scanners);
    }
}
