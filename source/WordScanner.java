import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordScanner implements Scanner {
    private int count;

    public WordScanner() {
        count = 0;
    }
    @Override
    public void scan(char character) {
        Pattern compile = Pattern.compile("\\s+");
        Matcher matcher = compile.matcher(character + "");
        if(matcher.find())
            count++;
    }
    public String toString(){
        return (count+1)+"";
    }
}