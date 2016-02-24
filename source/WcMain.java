package source;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import source.CommandLineArgsReader;
import source.FileOperation;
import source.Wc;

public class WcMain {
    public static void main(String[] args)  throws FileNotFoundException,IOException{
    	CommandLineArgsReader argsReader = new CommandLineArgsReader(args);
    	String [] methods =  argsReader.getMethodName();
        String [] files = argsReader.getFiles();
    	FileOperation filesReader = new FileOperation(files);
    	String fileContent = "";
        int [] total = new int [methods.length]; 
    	for(String file: files){
    		fileContent = filesReader.readNext();
    		if(fileContent==null) break;
            String []result = methodCaller(methods,fileContent,file);
            for (int i=0;i<result.length-1 ;i++ )
                total[i]+=Integer.parseInt(result[i]);
            printResult(result);
        }
        printResult(total);
    }
    private static String [] methodCaller(String [] methods,String fileContent,String fileName){
		Wc wc = new Wc(fileContent);
        String [] result = new String[methods.length+1];
		for (int index=0;index<methods.length; index++) {
			if(methods[index].equals("lineCount"))
				result[index]=wc.lineCount()+"";
			if(methods[index].equals("charCount"))
				result[index]=wc.charCount()+"";
			if(methods[index].equals("wordCount"))
				result[index]=wc.wordCount()+"";
			if(methods[index].equals("byteCount"))
				result[index]=wc.byteCount()+"";
		}
        result[methods.length] = fileName;
        return result;
    }
    private static void printResult(String [] values){
        String result = "";
        for (String value: values )
            result+="\t"+value;
        System.out.println(result);
    }
    private static void printResult(int [] values){
        String result = "";
        for (int value: values )
            result+="\t"+value;
        System.out.println(result);
    }
}
