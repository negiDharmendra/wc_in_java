package source;
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
    public int wordCount(){
    	String [] words = content.split("\\s");
    	return words.length;
    }
    public int lineCount(){
    	byte [] byteCodes = content.getBytes();
    	int numberOfLines = 0;
    	for (byte byteCode: byteCodes)
    		if(byteCode==10) numberOfLines++;//10 is byte code of new line char
    	return numberOfLines;
    }
    public int byteCount(){
    	byte [] byteCodes = content.getBytes();
    	return byteCodes.length;
    }
}
