public class ByteScanner implements Scanner {
    private int count;

    public ByteScanner() {
        count = 0;
    }
    @Override
    public void scan(char character) {
        String stringChar = String.valueOf(character);
        count+=stringChar.getBytes().length;
    }
    public String toString(){
        return count+"";
    }
}
