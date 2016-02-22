package source;
import java.util.Arrays;

public class CommandLineArgsReader {
	private String [] args;
    public CommandLineArgsReader(String [] args){
    	this.args = args;
    }
    private String [] getOption (){
    	int index = 0,newIndex = 0;
    	String [] options = new String [args.length];
    	while(args[index].charAt(0)=='-'&&args[index].length()>1){
    		options[index]=args[index];
    		index++;
    	}
    	String [] result = new String [index];
    	for (String option : options)
    		if(option!=null){
    			result[newIndex] = option;
    			newIndex++;
    		}
    	return result;
    }
    private String [] convertOptionIntoMethodName(String [] options){
    	String methodNames = "";
    	for (String option : options){
    		if(option=="-l")
    			methodNames+="lineCount\n";
    		if(option=="-w")
    			methodNames+="wordCount\n";
    		if(option=="-m")
    			methodNames+="charCount\n";
    		if(option=="-c")
    			methodNames+="byteCount\n";
    	}
    	return methodNames.split("\\n");
    }
    public String [] getMethodName(){
    	String [] options = getOption();
    	String [] methodNames = convertOptionIntoMethodName(options);
    	return methodNames;
    }
}
