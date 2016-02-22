package source;

public class CommandLineArgsReader {
	private String [] args;
    public CommandLineArgsReader(String [] args){
    	this.args = args;
    }
    public String [] getMethodName(){
    	String [] result = {"lineCount"};
    	return result;
    }
}
