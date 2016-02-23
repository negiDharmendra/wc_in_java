import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.Arrays;

import source.CommandLineArgsReader;


public class CommandLineArgsReaderTest {
	@Test
    public void getMethodNameShouldGiveTheMethodNameAccordingToProvidedOption(){
    	String [] args = {"-l","sample.txt"};
    	CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
    	String [] methods = {"lineCount"};
    	assertArrayEquals(methods,commandLineArgs.getMethodName());
    }
    @Test
    public void getMethodNameShouldGiveEmptyArrayForNoOption(){
        String [] args = {};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String [] methods = {};
        assertArrayEquals(methods,commandLineArgs.getMethodName());
    }
    @Test
    public void getMethodNameShouldGiveEmptyArrayWhenThereIsNoOptionBeginsWithHyphen(){
        String [] args = {"l","w","m","sample.txt"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String [] methods = {};
        assertArrayEquals(methods,commandLineArgs.getMethodName());
    }
    @Test
    public void getMethodNameShouldGiveAllTheMethodNamesAccordingToProvidedOptions(){
    	String [] args = {"-l","-w","-m","sample.txt"};
    	CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
    	String [] methods = {"lineCount","wordCount","charCount"};
    	assertArrayEquals(methods,commandLineArgs.getMethodName());
    }
    @Test
    public void getMethodNameShouldNotRepeatTheMethodNames(){
        String [] args = {"-l","-w","-m","-l","-w","-m","-l","-w","-m","-l","-w","-m","-l","-w","-m","sample.txt"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String [] methods = {"lineCount","wordCount","charCount"};
        assertArrayEquals(methods,commandLineArgs.getMethodName());
    }
    @Test
    public void getMethodNameShouldSelectTheLastMethodAmongTheByteCountOrCharCount(){
        String [] args = {"-l","-w","-m","-c","sample.txt"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String [] methods = {"lineCount","wordCount","byteCount"};
        assertArrayEquals(methods,commandLineArgs.getMethodName());

        String [] args1 = {"-l","-w","-c","-m","sample.txt"};
        commandLineArgs = new CommandLineArgsReader(args1);
        String [] methods1 = {"lineCount","wordCount","charCount"};
        assertArrayEquals(methods1,commandLineArgs.getMethodName());
    }
    @Test
    public void getMethodNameShouldThrowAnErrorForInvalidOptions(){
        String [] args = {"-l","-q","-m","sample.txt"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String errorMessage = "\n\twc: illegal option -- q\n\tusage: wc [-clmw] [file ...]";
        try {
            commandLineArgs.getMethodName();
        } catch (IllegalArgumentException err) {
            assertEquals(err.getMessage(), errorMessage);
        }
    }
    @Test
    public void getMethodNameShouldReturnsEmptyArrayInTheAbsenceOfOptions(){
        String [] args = {"sample.txt"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String [] methods = {};
        assertArrayEquals(methods,commandLineArgs.getMethodName());
    }
    @Test
    public void getMethodNameShouldGiveAllMethodNameEvenIfAllOptionsAreTogetherInAString(){
        String [] args = {"-lwc"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String [] methods = {"lineCount","wordCount","byteCount"};
        assertArrayEquals(methods,commandLineArgs.getMethodName());
    }
    @Test
    public void getFilesShouldGiveTheAllTheProvidedFileName(){
        String [] args = {"-l","sample.txt"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String [] filesName = {"sample.txt"};
        assertArrayEquals(filesName,commandLineArgs.getFiles());
    }
    @Test
    public void getFilesShouldTreatAllThoseArgsStartWithoutHyphonAsFileName(){
        String [] args = {"-sample1.txt","w","l","sample.txt"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String [] filesName = {"w","l","sample.txt"};
        assertArrayEquals(filesName,commandLineArgs.getFiles());
    }
    @Test
    public void getFilesShouldTreatTheSingleHyphonAsFileName(){
        String [] args = {"-","-"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String [] filesName = {"-","-"};
        assertArrayEquals(filesName,commandLineArgs.getFiles());
    }
    @Test
    public void getFilesShouldThrowAnErrorInTheAbsenceOfFiles(){
        String [] args = {"-l"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String errorMessage = "\n\t File name is not provided";
        try {
            commandLineArgs.getMethodName();
        } catch (IllegalArgumentException err) {
            assertEquals(err.getMessage(), errorMessage);
        }
    }
}
