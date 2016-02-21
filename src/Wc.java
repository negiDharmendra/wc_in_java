package src;
import java.util.Arrays;

public class Wc {
	private String content;
    public Wc (String content){
    	this.content = content;
    }
    public int charCount(){
    	char [] chars = new char[content.length()];
    	content.getChars(0,content.length(),chars,0);
    	return chars.length;
    }
}
