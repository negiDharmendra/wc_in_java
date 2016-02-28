
public class LineScanner implements Scanner {
    private int count;

    public LineScanner() {
        count = 0;
    }
    @Override
    public void scan(char character) {
        if(character=='\n')
            count++;
    }
    public String toString(){
        return count+"";
    }
}
