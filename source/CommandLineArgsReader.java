package source;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandLineArgsReader {
	private String [] args;
    public CommandLineArgsReader(String [] args){
    	this.args = args;
    }
    private String [] getOption (){
        int index = 0,newIndex = 0;
        String [] options = new String [args.length];
        while(args.length>index&&args[index].charAt(0)=='-'&&args[index].length()>1){
            options[index]=args[index];
            index++;
        }
        String [] result = new String [index];
        for (String option : options)
            if(option!=null){
                result[newIndex] = option.substring(1);
                newIndex++;
            }
        return result;
    }
    private String [] convertOptionIntoMethodName(String [] options){
        String methodNames = "";
        String allOptions = Arrays.toString(options);
        if(allOptions.indexOf("l")>=0)
            methodNames+="lineCount\n";
        if(allOptions.indexOf("w")>=0)
            methodNames+="wordCount\n";
        if(allOptions.lastIndexOf("c")>allOptions.lastIndexOf("m"))
            methodNames+="byteCount\n";
        if(allOptions.lastIndexOf("c")<allOptions.lastIndexOf("m"))
            methodNames+="charCount\n";
        return methodNames.split("\\n");
    }
    private void filterInvalidOptions(String [] options){
        String pattern = "[^lwcm]";
        String optionString ="";
        for (int i=0; i<options.length; i++)
            optionString += options[i];
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(optionString);
        if(matcher.find())
            throw new IllegalArgumentException("\n\twc: illegal option -- "+matcher.group(0)+"\n\tusage: wc [-clmw] [file ...]");
    }
    public String [] getMethodName(){
        String [] options = getOption();
        if(options.length==0)return options;
        filterInvalidOptions(options);
        String [] methodNames = convertOptionIntoMethodName(options);
    	return methodNames;
    }
}
