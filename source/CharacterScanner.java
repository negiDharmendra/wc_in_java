
public class CharacterScanner implements Scanner {
    private int count;

    public CharacterScanner() {
        count = 0;
    }
    @Override
    public void scan(char character) {
        count++;
    }
    public String toString(){
        return count+"";
    }
}
