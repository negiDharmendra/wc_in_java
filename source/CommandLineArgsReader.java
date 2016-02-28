import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandLineArgsReader {
	private String [] args;
    public CommandLineArgsReader(String [] args){
    	this.args = args;
    }
    private String  getOption (){
        int index = 0;
        String result="";
        while(args.length>index&&args[index].charAt(0)=='-'&&args[index].length()>1){
            result +=args[index].substring(1);
            index++;
        }
        return result;
    }
    private String convertOptionIntoMethodName(String options){
        String methodNames = "";
        String [] optionSequence = {"l","w","c","m"};
        for (String option:optionSequence)
            if(options.contains(option))
                methodNames+=option;
        if(options.lastIndexOf("c")>options.lastIndexOf("m"))
            methodNames = methodNames.replaceAll("m","");
        if(options.lastIndexOf("c")<options.lastIndexOf("m"))
            methodNames = methodNames.replaceAll("c","");
        return methodNames;
    }
    private void filterInvalidOptions(String options){
        String pattern = "[^lwcm]";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(options);
        if(matcher.find())
            throw new IllegalArgumentException("\n\twc: illegal option -- "+matcher.group(0)+"\n\tusage: wc [-clmw] [file ...]");
    }
    public String getOptions(){
        String options = getOption();
        if(options.length()==0)return options;
        filterInvalidOptions(options);
    	return convertOptionIntoMethodName(options);
    }
    public String [] getFiles(){
       int index = 0;
        String files = "";
        while(args.length>index&&args[index].charAt(0)=='-'&&args[index].length()>1)
            index++;
        while(index<args.length){
            files += args[index]+"\n";
            index++;
        }
        if(files.length()<1) throw new UnsupportedOperationException("\n\t File name is not provided");
        return files.split("\\n");
    }
}
