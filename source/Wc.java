import java.util.ArrayList;
import java.util.List;

public class Wc {
    private String content;
    private List<Scanner> scanners;
    String contentWithOutMultipleSpaces;

    public Wc(String content) {
        this.content = content;
        contentWithOutMultipleSpaces = content.replaceAll("\\s+"," ");
        scanners = new ArrayList<Scanner>();
    }

    public void addScanner(Scanner scanner) {
        scanners.add(scanner);
    }


    private void count(char character) {
        for (Scanner scanner : scanners)
            if(!(scanner instanceof WordScanner))
                scanner.scan(character);
    }
    private void countWord(char character) {
        for (Scanner scanner : scanners)
            if(scanner instanceof WordScanner)
                scanner.scan(character);
    }

    public void count() {
        for (int i = 0; i < content.length(); i++)
            count(content.charAt(i));
        for (int i = 0; i < contentWithOutMultipleSpaces.length(); i++)
            if(!(contentWithOutMultipleSpaces.matches(" ")&&contentWithOutMultipleSpaces.length()==1))
                countWord(contentWithOutMultipleSpaces.charAt(i));
    }

    public String summery() {
        PrepareResult prepareResult = new PrepareResult("\t");
        return prepareResult.add(scanners);
    }
}
