import java.util.HashMap;


public class AllScanner {
    private HashMap<String,Scanner> scanners = new HashMap<String,Scanner>(10);

    public AllScanner() {
        scanners.put("l",new LineScanner());
        scanners.put("w",new WordScanner());
        scanners.put("m",new CharacterScanner());
        scanners.put("c",new ByteScanner());
    }
    public HashMap<String,Scanner> get(){
        return scanners;
    }
}
