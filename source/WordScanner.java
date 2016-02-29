import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordScanner implements Scanner {
    private char prevChar;
    private int count;

    public WordScanner() {
        count = 0;
        prevChar = ' ';
    }

    @Override
    public void scan(char character) {
        Pattern compile = Pattern.compile("\\s+");
        Matcher matcher = compile.matcher(character + "");
        Matcher prevMatcher = compile.matcher(prevChar + "");
        if (!matcher.find() && prevMatcher.find())
            count++;
        prevChar = character;
    }

    public String toString() {
        return (count) + "";
    }
}